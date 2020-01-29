package com.nc.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/courses/{fee}")
	public ResponseEntity<List<Course>> fetchCoursesByFeeLessThan(@PathVariable double fee) {
		return ResponseEntity.ok().body(courseRepository.findByFeeLessThan(fee));
	}

	@PostMapping("/courses/title")
	public ResponseEntity<List<Course>> fetchCoursesByTitleContaining(@RequestParam String title) {
		return ResponseEntity.ok().body(courseRepository.findByTitleContainingIgnoringCase(title));
	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> fetchCoursesByQueryHint(@PathVariable Long id) throws Exception {
		try {
			courseRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Could not able to delete for given ID" + id);
		}
		return ResponseEntity.ok().body("Row is deleted for given ID: " + id);
	}

	@PostMapping("/courses/abbreviation/modules")
	public ResponseEntity<List<Course>> fetchCourseByAnnotatedQuery(@RequestParam String abbreviation,
			@RequestParam int modules) {
		return ResponseEntity.ok().body(courseRepository.findByAnnotatedQuery(abbreviation, modules));
	}

	@PostMapping("/courses/abbreviation")
	public ResponseEntity<List<Course>> fetchCoursesByFirstnameLikeNamed(
			@RequestParam(value = "abbreviation", required = false) Collection<String> abbreviation,
			@RequestParam(value = "modules", required = false) Collection<Integer> modules) {
		return ResponseEntity.ok().body(courseRepository.findByAbbrevationLikeNamed(abbreviation, modules));
	}
}
