/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geusa
 */
public class Teacher extends Person {
    private String name;
    public Title title;
    public Set<Subject> subjects;
    
    public Teacher(String n,Title t){
        name = n;
        title = t;
        subjects = new HashSet<Subject>();
    }
    
    void addTitle(Title t){
    title = t;
    }
    
    
    
    
    
    
}
