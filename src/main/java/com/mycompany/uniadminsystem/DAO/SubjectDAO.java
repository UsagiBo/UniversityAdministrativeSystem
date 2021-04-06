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
 */
public class SubjectDAO implements Dao<Subject> {
    private  final String PERSISTENCE_UNIT_NAME = "unidb";
    private  EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

   @Override
    public Optional<Subject> get(long id) {
        EntityManager entityManager = factory.createEntityManager();
        Optional<Subject> subject = Optional.ofNullable(entityManager.find(Subject.class, id));
        entityManager.close();
        return subject;
    }
    
    @Override
    public List<Subject> getAll() {
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = entityManager.createQuery("select t from Subjects t");
        List<Subject> subjectList;
        try{
        subjectList = q.getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return subjectList;
    }
    
        public List<Long> getAllById() {
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = entityManager.createQuery("select t.ID from Subjects t");
        List<Long> subjectList;
        try{
        subjectList = q.getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return subjectList;
    }
    

    public List<Object[]> getWithMostStudents() {
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        @SuppressWarnings("unchecked")
        Query q = entityManager.createQuery("Select t.Name, count(su) as cou From Subjects t, Students su, su.Subjects as subj where t.ID = subj.ID  group by t.Name order by cou DESC", Student.class);
        List<Object[]> subjectList;
        try{
        subjectList = q.setMaxResults(3).getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return subjectList;
    }
    
    @Override
    public void save(Subject subject) {

        executeInsideTransaction(entityManager -> entityManager.persist(subject));
    }
    
    public void update(Subject s) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        if (!entityManager.contains(s)) {
            entityManager.merge(s);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void updateSubject(Subject s){
        executeInsideTransaction(entityManager -> entityManager.merge(s));
    }
    
    @Override 
    public void delete(Subject subject) {
        executeInsideTransaction(entityManager -> entityManager.remove(subject));
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
