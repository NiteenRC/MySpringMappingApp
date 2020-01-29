package com.nc.entity.one2many;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Page implements Serializable {
	private static final long serialVersionUID = 5520621521275176741L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String content;
	private String chapter;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	public Page() {
	}

	public Page(String content, String chapter, Book book) {
		this.content = content;
		this.chapter = chapter;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Page{" + "id=" + id + ", content='" + content + '\'' + ", chapter='" + chapter + '\'' + ", book=" + book
				+ '}';
	}
}
