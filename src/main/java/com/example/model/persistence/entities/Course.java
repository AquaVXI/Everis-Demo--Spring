package com.example.model.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "code", length = 5)
    private String code;
    
    @Column(name = "name", length = 45)
    private String name;
    
    public Course() {
    }
    
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
