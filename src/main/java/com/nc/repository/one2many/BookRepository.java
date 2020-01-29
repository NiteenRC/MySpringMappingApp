package com.nc.repository.one2many;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.one2many.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
}
