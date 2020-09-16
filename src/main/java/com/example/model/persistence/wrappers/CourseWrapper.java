/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model.persistence.wrappers;

import com.example.model.persistence.entities.Course;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Kurisutian
 */
@Data
public class CourseWrapper {
    
    private List<Course> courses;
    
}
