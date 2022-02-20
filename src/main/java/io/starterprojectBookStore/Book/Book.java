package io.starterprojectBookStore.Book;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Books")
public class Book {
 
	@Id
	private String name;
	private int rating;
	private String author;
	
	public Book() {
		super();
	}
	
	public Book(String id, String name, int rating, String author) {
		super();
		this.name = name;
		this.rating = rating;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
