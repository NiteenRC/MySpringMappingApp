package com.nc.repository.many2many;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.many2many.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
