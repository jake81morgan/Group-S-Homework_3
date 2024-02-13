package edu.mu.MediaProject.MediaProducts;

public class TapeRecordProduct extends MediaProduct{

	public TapeRecordProduct(String title, Double price, int year, Genre genre) {
		
		super(title, price, year, genre);

	}

	@Override
	public String toString() {
		return "TapeRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}

}
