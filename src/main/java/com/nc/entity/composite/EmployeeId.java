package com.nc.entity.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId implements Serializable {
	private static final long serialVersionUID = -2243720529417671025L;

	@Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "department_id")
    private Long departmentId;

    public EmployeeId() {
    }

    public EmployeeId(Long employeeId, Long departmentId) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
