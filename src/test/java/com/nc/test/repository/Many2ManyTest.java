package com.nc.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nc.entity.many2many.Course;
import com.nc.repository.many2many.CourseRepository;
import com.nc.repository.many2many.StudentRepository;

@SpringBootTest
public class Many2ManyTest {

	private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void testFetchAllUsers() {
		assertTrue(courseRepository.findAll().size() >= 1);
		LOGGER.info("courseRepository ::" + courseRepository.findAll());

		assertTrue(studentRepository.findAll().size() >= 1);
		LOGGER.info("studentRepository ::" + studentRepository.findAll());

	}

	@Test
	void testFetchFeeLessThan() {
		List<Course> courses = courseRepository.findByFeeLessThan(801);
		assertTrue(courses.size() >= 1);
		LOGGER.info("testFetchFeeLessThan " + courses.size());

		long feesCount = courses.stream().filter(x -> x.getFee() < 801).count();
		assertEquals(courses.size(), feesCount);
		LOGGER.info("testFetchFeeLessThan size " + feesCount);
	}

	@Test
	void testfindByTitleContaining() {
		List<Course> courses = courseRepository.findByTitleContainingIgnoringCase("Machine");
		assertTrue(courses.size() >= 1);
		LOGGER.info("testfindByTitleContaining " + courses.size());

		long titleCount = courses.stream().filter(x -> x.getTitle().contains("Machine")).count();
		assertEquals(courses.size(), titleCount);
		LOGGER.info("testfindByTitleContaining size " + titleCount);
	}

}
