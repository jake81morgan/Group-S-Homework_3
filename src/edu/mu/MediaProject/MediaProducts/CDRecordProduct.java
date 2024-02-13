package edu.mu.MediaProject.MediaProducts;

public class CDRecordProduct extends MediaProduct {

	public CDRecordProduct(String title, Double price, int year, Genre genre) {
		
		super(title, price, year, genre);
		
	}

	@Override
	public String toString() {
		return "CDRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}

}
