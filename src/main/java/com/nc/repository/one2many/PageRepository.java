package com.nc.repository.one2many;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.one2many.Book;
import com.nc.entity.one2many.Page;

public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}
