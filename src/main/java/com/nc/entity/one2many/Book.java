package com.nc.entity.one2many;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 9096414786696338115L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String author;
	//@Column(unique = true)
	private String isbn;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Page> pages;

	public Book() {
	}

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", isbn='" + isbn
				+ '\'' + '}';
	}
}
