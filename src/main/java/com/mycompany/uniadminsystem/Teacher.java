/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author geusa
 */
@Entity (name="Teachers") @Table(name= "Teachers")
public class Teacher extends Person implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long ID;
    @Column(name = "Title")
    private String Title;
    @OneToMany( targetEntity=Subject.class )
    public List<Subject> Subjects;
    
    public Teacher(){}
    public Teacher(String n,String t){
        this.setName(n);
        this.Title = t;
        //this.Subjects = new HashSet<Subject>();
    }
     public long getId (){
        return this.ID;
    }
    public String getTitle(){
    return this.Title;
    }
    public void setTitle(String t){
    this.Title = t;
    }
    
     public List<Subject> getSubjects(){
        return this.Subjects;
    }
    public void setSubjects(List<Subject> subjects){
        this.Subjects = subjects;
    }
/*
    public void addSubject(Subject subject){
        this.Subjects.add(subject);
    }
    
    public void removeSubject(Subject subject){
        this.Subjects.remove(subject);
    }
    */
    
}
