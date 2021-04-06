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
public class TeacherDAO implements Dao<Teacher> {
    private  final String PERSISTENCE_UNIT_NAME = "unidb";
    private  final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
  

    // standard constructors
    
    @Override
    public Optional<Teacher> get(long id) {
        EntityManager entityManager = factory.createEntityManager();
        
        Optional<Teacher> teacher = Optional.ofNullable(entityManager.find(Teacher.class, id));
        entityManager.close();
        return teacher;
    }
    
    @Override
    public List<Teacher> getAll() {
        EntityManager entityManager = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = entityManager.createQuery("select t from Teachers t");
        List<Teacher> teacherList;
        try{
        teacherList = q.getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return teacherList;
        
    }
    
    public List<Object[]> getTeacherSubjectStudentCount(){
        EntityManager entityManager = factory.createEntityManager();
        
        List<Object[]> teacherSubStud;
        try{  
        Query q = entityManager.createQuery("select t.FullName, su.Name, Count(r) from Teachers t, t.Subjects as su, Students r, r.Subjects as rus Where rus.ID = su.ID group by t.FullName, su.Name", Student.class);
        
        teacherSubStud = q.getResultList();
        }catch(Exception e){throw e;}
        
        entityManager.close();
        return teacherSubStud;
    }
    
    public List<Object[]> getMostStudents(){
        EntityManager entityManager = factory.createEntityManager();
         
        Query q = entityManager.createQuery("Select t.FullName as name, Count(r) as total  from Teachers t, t.Subjects as su, Students r, r.Subjects as subjc Where subjc.ID = su.ID group by name order by total DESC ", Student.class);
        List<Object[]> popularTeachers;
        
        try{
        popularTeachers = q.setMaxResults(3).getResultList();
        }catch(Exception e){throw e;}
        entityManager.close();
        return popularTeachers;
    }
    
    @Override
    public void save(Teacher teacher) {

        executeInsideTransaction(entityManager -> entityManager.persist(teacher));
    }
    
   //@Override
    public void update(Teacher t) {
EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        if (!entityManager.contains(t)) {
            entityManager.merge(t);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
    
    @Override 
    public void delete(Teacher teacher) {
        executeInsideTransaction(entityManager -> entityManager.remove(teacher));
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

