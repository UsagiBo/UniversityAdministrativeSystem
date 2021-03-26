/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author geusa
 */
@Entity @Table(name= "Teachers")
public class Teacher extends Person {
    @OneToOne
    @Id private int ID;
    @Column(name = "FullName")
    private String FullName;
    @Column(name = "Title")
    public String Title;
    //idk
    public Set<Subject> Subjects;
    
    public Teacher(String n,String t){
        this.FullName = n;
        this.Title = t;
        this.Subjects = new HashSet<Subject>();
    }
    
    String getTitle(){
    return this.Title;
    }
    void setTitle(String t){
    this.Title = t;
    }
    
    int getID(){
    return this.ID;
    }
    
    
    
    
    
}
