package com.nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nc.entity.one2one.User;
import com.nc.repository.one2one.UserRepository;

@RestController
@RequestMapping("/one2one")
public class RestControllerOne2One {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public ResponseEntity<List<User>> fetchData() {
		return ResponseEntity.ok().body(userRepository.findAll());
	}
}
