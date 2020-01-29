package com.nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nc.entity.many2many.Course;
import com.nc.entity.many2many.Student;
import com.nc.repository.many2many.CourseRepository;
import com.nc.repository.many2many.StudentRepository;

@RestController
@RequestMapping("/many2many")
public class RestControllerMany2Many {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> fetchAllCoursesData() {
		return ResponseEntity.ok().body(courseRepository.findAll());
	} 
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> fetchAllStudentsData() {
		return ResponseEntity.ok().body(studentRepository.findAll());
	} 
}
