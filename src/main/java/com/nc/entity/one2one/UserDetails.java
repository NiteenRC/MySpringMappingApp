package com.nc.entity.one2one;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 6652033818949477145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String gender;

	public UserDetails() {
	}

	public UserDetails(String gender) {
		this.gender = gender;
	}

	@OneToOne // (fetch = FetchType.LAZY)
	// @MapsId
	// @PrimaryKeyJoinColumn
	@JsonIgnore // If this annotation removed then hibernate throws stackoverflow
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
