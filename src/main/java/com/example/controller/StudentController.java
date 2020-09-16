/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.model.persistence.entities.Student;
import com.example.model.persistence.repository.StudentRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kurisutian
 */
@Controller @Slf4j
@RequestMapping(value = "/")
public class StudentController {

    @Autowired
    private StudentRepository repository;
    
    @GetMapping(value = "students/get-students")
    public ResponseEntity<Iterable<Student>> getAll(){
        return new ResponseEntity<Iterable<Student>>(repository.findAll(), HttpStatus.OK);
    }
    
    // Hard-coded
    @PutMapping(value = "students/base-create")
    public ResponseEntity<HttpStatus> createBase(){       
        Student student = new Student();
        student.setName("Cristian");
        student.setLast_name("Elgueta");
        student.setRut("123456789");
        repository.save(student);
        log.info("[!] Añadido el curso base ".concat(student.getName()));
        return new ResponseEntity<HttpStatus> (HttpStatus.CREATED);
    }
    
    @PostMapping(value = "students/body-find")
    public ResponseEntity<Student> bodyFind(@RequestBody Student student){
        Optional<Student> c = repository.findById(student.getId());
        return new ResponseEntity<Student>(c.get(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "students/param-find")
    public ResponseEntity<Student> paramFind(@RequestParam Long id){
        Optional<Student> c = repository.findById(id);
        return new ResponseEntity<Student>(c.get(), HttpStatus.OK);
    }
    
    @PutMapping(value = "students/path-find/{id}")
    public ResponseEntity<Student> pathFind(@PathVariable("id") Long id){
        Optional<Student> rsp = repository.findById(id);
        return new ResponseEntity<Student>(rsp.get(), HttpStatus.OK);
    }
    
}
