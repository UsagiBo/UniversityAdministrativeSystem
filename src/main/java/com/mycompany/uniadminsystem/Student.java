/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;


import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.UserTransaction;


/**
 *
 * @author geusa
 */
// @Entity indicates that the instances of this class will be stored persistently.
// @Table specifies the name of the database table to be used for storing the entities
@Entity @Table(name = "Students")
public class Student extends Person implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    @Column(name = "FullName", length = 255)
    private String FullName;
    @Column(name = "Semester", length = 255)
    private int Semester;
    private Set<Subject> Subjects;
    
    public Student(){}
    public Student(String id, String name, int semester){
        this.ID = id; 
        this.FullName = name;
        this.Semester = semester;
        
    }
    
    int getSemester (){
        return this.Semester;
    }
    void setSemester (int semester){
    this.Semester = semester;
    }
    
    void takeSubject(Subject subject){
        this.Subjects.add(subject);
    }
    void dropSubject(Subject subject){
        this.Subjects.remove(subject);
    }
    
    //CRUD
    //List of students 
    public static List<Student> retrieveAll( EntityManager em) {
  Query query = em.createQuery( "SELECT s FROM Students s", Student.class);
  List<Student> students = query.getResultList();
  return students;
}
    //clear all data from Student table
    public static void clearData( EntityManager em, 
    UserTransaction ut) throws Exception {
  ut.begin();
  Query deleteStatement = em.createQuery( "DELETE FROM Students");
  deleteStatement.executeUpdate();
  ut.commit();
}
    
    //populate table with test data
    public static void createTestData( EntityManager em, 
    UserTransaction ut) throws Exception {
   Student student = null;
  Student.clearData( em, ut);  // first clear the books table
  ut.begin();
  student = new Student("006251587X","Sherry Pie", 1);
  em.persist( student);
  student = new Student("0465026567","Gorge Pete", 2);
  em.persist( student);
  student = new Student("0465030793","Lilly Allen", 3);
  em.persist( student);
  ut.commit();
}
    
    
    
}
