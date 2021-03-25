/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;


import java.util.Set;


/**
 *
 * @author geusa
 */
public class Student extends Person {
    private String name;
    private int year;
    private Set<Subject> subjects;
    
    void takeSubject(Subject subject){
        subjects.add(subject);
    }
    void dropSubject(Subject subject){
        subjects.remove(subject);
    }
    
}
