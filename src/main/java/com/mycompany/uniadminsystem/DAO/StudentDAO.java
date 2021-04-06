/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem.DAO;

import com.mycompany.uniadminsystem.Student;
import com.mycompany.uniadminsystem.Subject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author geusa
 * Display Students and their courses
 */
public class StudentDAO implements Dao<Student> {
    private  final String PERSISTENCE_UNIT_NAME = "unidb";
    private  EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
  
    // standard constructors
    
    @Override
    public Optional<Student> get(long id) {
        EntityManager entityManager = factory.createEntityManager();
        
        Optional<Student> student = Optional.ofNullable(entityManager.find(Student.class, id));
        entityManager.close();
        return student;
    }
    
    @Override
    public List<Student> getAll() {
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = entityManager.createQuery("select t from Students t");
        List<Student> studentList;
        try{
        studentList = q.getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return studentList;
    }

    public List<Object[]> getAllCredit() {
        EntityManager entityManager = factory.createEntityManager();
        @SuppressWarnings("unchecked")
        Query q = entityManager.createQuery(""
                + "select t.FullName, SUM(su.Credits) from Students t, t.Subjects AS su  group by t.FullName",Subject.class);
        List<Object[]> studentCredit;
        try{
        studentCredit = q.getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return studentCredit;
    }
    
    @Override
    public void save(Student student) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
   //@Override
    public void update(Student student, String name, int semester, List<Subject> subj) {
        student.setName(Objects.requireNonNull(name, "Name cannot be null"));
        student.setSemester(Objects.requireNonNull(semester, "Semester cannot be null"));
        student.setSubjects(Objects.requireNonNull(subj, "Semester cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(student));
        
    }
    public void updateStudent(Student s){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        /*
        if (!entityManager.contains(s)) {
            entityManager.merge(s);
        }*/
        entityManager.getTransaction().commit();
        entityManager.close();
    }
       
    @Override 
    public void delete(Student student) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        if (!entityManager.contains(student)) {
            student = entityManager.merge(student);
        }
        entityManager.remove(student);
        entityManager.getTransaction().commit();

        entityManager.close();
        
    }
    
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        entityManager.close();
    }
}
