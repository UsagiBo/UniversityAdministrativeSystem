/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem.DAO;

import com.mycompany.uniadminsystem.Student;
import com.mycompany.uniadminsystem.Subject;
import com.mycompany.uniadminsystem.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author geusa
 */
public class SampleDAO {

    private static final String PERSISTENCE_UNIT_NAME = "unidb";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void addSampleData() throws Exception {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction in order to persist a new entity
        em.getTransaction().begin();
        
        Subject subject = new Subject();
        subject.setName("Applied Phisics");
        subject.setCredit(15);
        //subject.setTeacher(teacher);
        em.persist(subject);
       
        //build teacher-subject relationship
        Teacher teacher = new Teacher();
        teacher.setName("Jhon Hawkins");
        teacher.setTitle("Professor");
       
        List<Subject> subjects = new ArrayList<Subject>();
        subjects.add(subject);
        teacher.setSubjects(subjects);
        em.persist(teacher);

        
        Subject subject1 = new Subject();
        subject1.setName("Biomedical Engineering");
        subject1.setCredit(7.5);
        em.persist(subject1);
        
        Subject subject2 = new Subject();
        subject2.setName("Aerospace Engineering");
        subject2.setCredit(15);
        em.persist(subject2);
        
        //subject1.setTeacher(teacher1);
        
        Teacher teacher1 = new Teacher();
        teacher1.setName("Dava Newman");
        teacher1.setTitle("Professor");
        
        //build teacher-subject relationship
        List<Subject> subjects1 = new ArrayList();
        subjects1.add(subject1);
        subjects1.add(subject2);
        teacher1.setSubjects(subjects1);
        em.persist(teacher1);
        
        char c = 'A';
        //create 40 new students
        for (int i = 0; i < 40; i++) {
            Student student = new Student();
            student.setName(c + "aura" + " " + c + "elly");
            student.setSemester((i % 3)+1);
            student.getSubjects().add(subject);
            //we have to edit the Subject object to include the student too as Student is the owning side of the @ManyToMany relationship
            subject.getStudents().add(student);
            if (i % 2 == 0) {
                student.getSubjects().add(subject1);
                subject1.getStudents().add(student);
            }
            
            // persist student
            em.persist(student);
            c++;
        }
        
        // Commit the transaction - 
        // store entities in the database
        em.getTransaction().commit();

        em.close();

    }
}
