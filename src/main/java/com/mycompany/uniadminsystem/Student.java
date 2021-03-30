/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author geusa
 */
// @Entity indicates that the instances of this class will be stored persistently.
// @Table specifies the name of the database table to be used for storing the entities
@Entity(name="Students") @Table(name = "Students")
public class Student extends Person implements Serializable {
    @Id 
    //eneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;
    //@Column(name = "FullName", length = 255)
    //private String FullName;
    @Column(name = "StudyYear", length = 255)
    private int Semester;
    @ManyToMany
    /* Not required but used in case JPA's naming conventions don't match our table/row names*/
    @JoinTable(
            name = "enrollments", 
            joinColumns = @JoinColumn(name = "StudentID"), 
            inverseJoinColumns = @JoinColumn(name = "SubjectID"))
    private List<Subject> Subjects = new ArrayList<Subject>();
    
    
    public Student(){}
    public Student( String name, int semester){
        this.setName(name);
        this.Semester = semester;
        
    }
    
     public Integer getId (){
        return this.ID;
    }
    public int getSemester (){
        return this.Semester;
    }
    public void setSemester (int semester){
    this.Semester = semester;
    }
    
    List<Subject> getSubjects(){
        return this.Subjects;
    }

    void addSubject(Subject subject){
        this.Subjects.add(subject);
    }
    
    void removeSubject(Subject subject){
        this.Subjects.remove(subject);
    }


   /* 
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
  student = new Student("Sherry Pie", 1);
  em.persist( student);
  student = new Student("0465026567","Gorge Pete", 2);
  em.persist( student);
  student = new Student("0465030793","Lilly Allen", 3);
  em.persist( student);
  ut.commit();
}
*/
    
    
    
}
