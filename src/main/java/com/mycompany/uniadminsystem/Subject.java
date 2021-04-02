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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author geusa
 */
@Entity(name="Subjects")  @Table(name= "Subjects")
public class Subject implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "FullName", length = 255)
    private String Name;
    @Column(name = "Credits")
    private double Credits;
    //@OneToOne(mappedby "ID")
    @JoinColumn(name = "TeacherID")
    @OneToOne
    private Teacher Teacher;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Subjects")
    List<Student> Students = new ArrayList<Student>();
    
    public Subject(){}
    
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
    
    public Teacher getTeacher(){
    return this.Teacher;
    }
    public void setTeacher(Teacher teacher){
    this.Teacher = teacher;
    }
    
    public List<Student> getStudents(){
    return this.Students;
    }

    
    
}
