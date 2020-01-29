package com.nc.entity.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = -6574991389294370408L;

	@EmbeddedId
	private EmployeeId employeeId;

	private String name;
	@Column(unique = true)
	private String email;
	private String phoneNumber;

	public Employee() {
	}

	public Employee(EmployeeId employeeId, String name, String email, String phoneNumber) {
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
