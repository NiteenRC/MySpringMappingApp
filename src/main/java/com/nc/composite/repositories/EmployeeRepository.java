package com.nc.composite.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nc.entity.composite.Employee;
import com.nc.entity.composite.EmployeeId;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

    List<Employee> findByEmployeeIdDepartmentId(Long departmentId);
}
