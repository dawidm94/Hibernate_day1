package pl.coderslab.app;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "book")
public class Book {

	@Column(name = "id")
	@Id
	@GeneratedValue (strategy =	GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 255)
	private String title;

	@Column(length = 255)
	private String author;

	@Column(scale=2, precision=4)
	private BigDecimal rating;

	@Column(name = "publisher", nullable = false, unique = false)
	@ManyToOne
	private Publisher publisher;

	@Column(columnDefinition = "TEXT")
	private String description;
	
	public Book() {
		
	}

	public Long getId() {
		return id;
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

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
