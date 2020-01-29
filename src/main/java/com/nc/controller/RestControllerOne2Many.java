package com.nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nc.entity.one2many.Book;
import com.nc.repository.one2many.BookRepository;

@RestController
@RequestMapping("/one2many")
public class RestControllerOne2Many {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> fetchData() {
		return ResponseEntity.ok().body(bookRepository.findAll());
	}
}
