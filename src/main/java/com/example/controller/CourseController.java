package com.example.controller;

import com.example.model.persistence.entities.Course;
import com.example.model.persistence.repository.CourseRepository;
import com.example.model.persistence.wrappers.CourseWrapper;
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

@Controller @Slf4j
@RequestMapping(value = "/")
public class CourseController{

    @Autowired
    private CourseRepository repository;
    
    
    @GetMapping(value = "courses/get-courses")
    public ResponseEntity<Iterable<Course>> getAll(){
        return new ResponseEntity<Iterable<Course>>(repository.findAll(), HttpStatus.OK);
    }
    
    
    // Hard-coded
    @PutMapping(value = "courses/base-create")
    public ResponseEntity<HttpStatus> createBase(){       
        Course course = new Course();
        course.setCode("Java");
        course.setName("Java (Inicial)");
        repository.save(course);
        log.info("[!] Añadido el curso base ".concat(course.getName()));
        return new ResponseEntity<HttpStatus> (HttpStatus.CREATED);
    }
    
    
    
    //[BODY]
    @PostMapping(value = "courses/body-create")
    public void bodyCreate(@RequestBody Course course){
        try{
            repository.save(course);
            log.info("El curso ha sido creado correctamente.");
        }catch(Exception e){
            log.error("El curso no ha podido ser creado.");
            e.printStackTrace();
        }
    }
    
    @PutMapping(value = "courses/body-create-courses")
    public ResponseEntity<Course> bodyCreate(@RequestBody CourseWrapper courses){
        courses.getCourses().stream().forEach(e -> repository.save(e));
        return new ResponseEntity<Course>(HttpStatus.CREATED);
    }

    @PutMapping(value = "courses/body-update")
    public void bodyUpdate(@RequestBody Course course){
        try{
            repository.save(course);
            log.info("El curso ha sido creado correctamente.");
        }catch(Exception e){
            log.error("El curso no ha podido ser creado.");
            e.printStackTrace();
        }
    }
    
    @PutMapping(value = "courses/body-update-courses/{id}")
    public ResponseEntity<Course> createCourses(@RequestBody CourseWrapper courses, @PathVariable(value = "id") Long id){
        courses.getCourses().stream().forEach(c -> repository.save(c));
        return new ResponseEntity<Course>(HttpStatus.CREATED);
    }

    
    @PostMapping(value = "courses/body-find")
    public ResponseEntity<Course> bodyFind(@RequestBody Course course){
        Optional<Course> c = repository.findById(course.getId());
        return new ResponseEntity<Course>(c.get(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "courses/param-find")
    public ResponseEntity<Course> paramFind(@RequestParam Long id){
        Optional<Course> c = repository.findById(id);
        return new ResponseEntity<Course>(c.get(), HttpStatus.OK);
    }
    
    @PutMapping(value = "courses/path-find/{id}")
    public ResponseEntity<Course> pathFind(@PathVariable("id") Long id){
        Optional<Course> rsp = repository.findById(id);
        return new ResponseEntity<Course>(rsp.get(), HttpStatus.OK);
    }
    
}