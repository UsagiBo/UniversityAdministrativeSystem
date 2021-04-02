/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;

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
    
    public List<Subject> getSubjects(){
        return this.Subjects;
    }

    public void addSubject(Subject subject){
        this.Subjects.add(subject);
    }
    
    public void removeSubject(Subject subject){
        this.Subjects.remove(subject);
    }
 
}
