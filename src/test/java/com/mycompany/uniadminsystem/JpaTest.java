/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author geusa
 */
@TestMethodOrder(OrderAnnotation.class)
public class JpaTest {
//To work we need to create tables at runtime on new clean DB
    //use persistance.xml to set up new DB on start-up
    private  final String PERSISTENCE_UNIT_NAME = "unidb";
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @Test
    @Order(1) 
    public void setUp() throws Exception {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction in order to persist a new entity
        em.getTransaction().begin();

        // read existing entries
        Query q = em.createQuery("select s from Students s");
        // Students should be empty

        // check for existing entries
        boolean createNewEntries = (q.getResultList().size() == 0);
        System.out.println("Ceating new Students "+createNewEntries);
        // Create new entries
        if (createNewEntries) {
            System.out.println("Creating new DB entries");
            assertTrue(q.getResultList().size() == 0);
            
            Teacher teacher = new Teacher();
            teacher.setName("Jhon Hawkins");
            teacher.setTitle("Professor");
            
            Subject subject = new Subject();
            subject.setName("Applied Phisics");
            subject.setCredit(15);
            
            //build teacher-subject relationship
            List<Subject> subjects = new ArrayList();
            subjects.add(subject);
            teacher.setSubjects(subjects);

            em.persist(teacher);
                
            //create 40 new students
            for (int i = 0; i < 40; i++) {
                Student student = new Student();
                student.setName("Laura_" + i +" "+ "Kelly_" + i);
                student.setSemester((1 + i)%4);
                student.getSubjects().add(subject);
                //we have to edit the Subject object to include the student too as Student is the owning side of the @ManyToMany relationship
                subject.getStudents().add(student);
                
                // persist student
                em.persist(student);

            }
            
            em.persist(subject);
        }

        // Commit the transaction - 
        // store entities in the database
        em.getTransaction().commit();

        em.close();

    }

    @Test
    @Order(2) 
    public void checkAvailableStudents() {

        // checking if the 40 new Students are there
        // new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all Students
        Query q = em.createQuery("select s from Students s");

        // Check if we have 40 Students in DB
        System.out.println("Students size is - "+q.getResultList().size());
        assertTrue(q.getResultList().size() == 40);

        em.close();
    }

    @Test
    @Order(3) 
    public void checkTeachers() {
        EntityManager em = factory.createEntityManager();
        // Select all Teachers and check their Subjects
        Query q = em.createQuery("select t from Teachers t");

        // Check if we have just 1 Teacher
        assertTrue(q.getResultList().size() == 1);
        
        //check Subjects the Teacher is teaching are just 1
        Teacher teacher = (Teacher)q.getSingleResult();
        assertTrue(teacher.getSubjects().size() == 1);
        em.close();
    }
    
    @Test
    @Order(4) 
    public void checkEnrollments() {
        EntityManager em = factory.createEntityManager();
        // Select all Subjects and check their Subjects
        Query q = em.createQuery("select s from Subjects s");

        // Check if we have just 1 Subject
        assertTrue(q.getResultList().size() == 1);
        
        //Check num of Students enrolled in Subject is 40
        System.out.println(((Subject)q.getSingleResult()).getName());
        System.out.println("Students in Subject are "+((Subject) q.getResultList().get(0)).getStudents().size());
        assertTrue((((Subject)q.getSingleResult())).getStudents().size() == 40);
        em.close();
    }
    
    @Test
    @Order(5) 
    public void deletePerson() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select s from Students s WHERE s.FullName = :name");
        q.setParameter("name", ("Laura_0 Kelly_0"));
        
        em.remove(q.getSingleResult());
        em.getTransaction().commit();
        
        Exception exception = assertThrows(javax.persistence.NoResultException.class, () -> {
        Student student = (Student)q.getSingleResult();
    });

   /* String expectedMessage = "NullPointerException";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));*/
        em.close();
    }
}
