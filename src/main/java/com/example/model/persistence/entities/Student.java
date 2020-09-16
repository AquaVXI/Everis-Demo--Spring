/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Kurisutian
 */
@Entity
@Data
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "rut", unique = true)
    private String rut;
    
    @Column(name = "name", length = 45)
    private String name;
    
    @Column(name = "last_name", length = 45)
    private String last_name;
    
    @Column(name = "fk_course")
    private Integer fk_course;
    
}
