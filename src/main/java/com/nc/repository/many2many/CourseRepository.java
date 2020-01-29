package com.nc.repository.many2many;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.many2many.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}
