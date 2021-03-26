/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author geusa
 */
@Entity @Table(name= "Subject")
public class Subject {
    /*
    ID  INTEGER PRIMARY KEY,
    Credits  DOUBLE,
    FullName       VARCHAR(255),
    TeacherID INTEGER  NOT NULL,*/
    @Id private int ID;
    @Column(name = "FullName", length = 255)
    private String FullName;
    @Column(name = "Credits")
    private double Credits;
    //@OneToOne(mappedby "ID")
    @Column(name = "TeacherID")
    private int TeacherID;
    
    double getCredit(){
        return this.Credits;
    }
    void setCredit(double credit){
        this.Credits = credit;
    }
    
    int getTeacherID(){
    return this.TeacherID;
    }
    void setTeacher(Teacher teacher){
    this.TeacherID = teacher.getID();
    }
    
    
    
}
