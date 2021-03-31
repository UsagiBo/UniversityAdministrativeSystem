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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author geusa
 */
@Entity (name="Teachers") @Table(name= "Teachers")
@XmlRootElement
public class Teacher extends Person {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer ID;
    //@Column(name = "FullName")
    //private String FullName;
    @Column(name = "Title")
    public String Title;
    @OneToMany
    public Set<Subject> subjects;
    
    public Teacher(){}
    public Teacher(String n,String t){
        this.setName(n);
        this.Title = t;
        //this.Subjects = new HashSet<Subject>();
    }
    
    String getTitle(){
    return this.Title;
    }
    void setTitle(String t){
    this.Title = t;
    }
    
    Integer getID(){
    return ID;
    }
    
    
}
