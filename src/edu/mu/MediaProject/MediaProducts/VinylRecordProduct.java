package edu.mu.MediaProject.MediaProducts;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct(String title, Double price, int year, Genre genre) {
		
		super(title, price, year, genre);

	}

	@Override
	public String toString() {
		return "VinylRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}
	
}
