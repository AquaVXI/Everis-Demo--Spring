package com.example.model.persistence.repository;

import com.example.model.persistence.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
}