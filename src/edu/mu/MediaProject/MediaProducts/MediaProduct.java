package edu.mu.MediaProject.MediaProducts;

public class MediaProduct {
	
	String title;
	Double price;
	int year;
	Genre genre;
	
	public MediaProduct(String title, Double price, int year, Genre genre) {

		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
