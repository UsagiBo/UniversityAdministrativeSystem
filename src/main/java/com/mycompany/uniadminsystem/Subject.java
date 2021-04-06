/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author geusa
 */
@Entity(name="Subjects")  @Table(name= "Subjects")
public class Subject implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@ManyToOne
    @Column(name = "ID")
    private Long ID;
    @Column(name = "FullName", length = 255)
    private String Name;
    @Column(name = "Credits")
    private double Credits;
    /*@JoinColumn(name = "TeacherID")
    @OneToOne
    private Teacher Teacher;*/
    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "Subjects", cascade = CascadeType.ALL)
    @ManyToMany( mappedBy = "Subjects", cascade = CascadeType.ALL)
    private List<Student> Students = new ArrayList<Student>();
    
    public Subject(){}
    
    public long getId(){
    return this.ID;}
    
    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }
    
    public double getCredit(){
        return this.Credits;
    }
    public void setCredit(double credit){
        this.Credits = credit;
    }
    
    /*public Teacher getTeacher(){
    return this.Teacher;
    }
    public void setTeacher(Teacher teacher){
    this.Teacher = teacher;
    }*/
    
    public List<Student> getStudents(){
    return this.Students;
    }
    
    public void setStudents(List<Student> stu){
    this.Students = stu;
    }
    
    public void removeStudent(Student s){
    this.Students.remove(s);
    }
}
