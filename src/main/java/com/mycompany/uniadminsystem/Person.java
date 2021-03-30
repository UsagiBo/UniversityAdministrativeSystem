/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author geusa
 */

@MappedSuperclass
public class Person {
    @Column(name = "FullName", length = 255)
    private String FullName;
    
    // Geter
  public String getName() {
    return FullName;
  }

  // Seter
  public void setName(String newName) {
    FullName = newName;
  }
}
