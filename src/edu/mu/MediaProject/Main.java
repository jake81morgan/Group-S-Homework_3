package edu.mu.MediaProject;

import java.util.ArrayList;
import edu.mu.MediaProject.MediaProducts.CDRecordProduct;
import edu.mu.MediaProject.MediaProducts.Genre;
import edu.mu.MediaProject.MediaProducts.MediaProduct;
import edu.mu.MediaProject.MediaProducts.TapeRecordProduct;
import edu.mu.MediaProject.MediaProducts.VinylRecordProduct;


public class Main {
	public static void main(String[] args) {
		StockManagerSingleton inventory = StockManagerSingleton.getInstance();
		
		// Checks if initializingStock works
		if(!inventory.initializeStock()) {
			System.out.println("Inventory was not initialized.");
		}
		
		// Checks getMediaProductBelowPrice method
		int price = 15;
		System.out.println("***************Items below $15*****************\n");
		for(MediaProduct product : inventory.getMediaProductBelowPrice(price)) {
			System.out.println(product);
		}
		
		System.out.println("\n***************Other Method Checks*****************\n");
		// Checks updateItemPrice
		MediaProduct product = inventory.getInventory().get(0);
		if(inventory.updateItemPrice(product, 100)) {
			System.out.println("Price Updated to 100.");
		}
		
		// Checks adding and removing methods
		product = inventory.getInventory().get(1);
		MediaProduct product_2 = new CDRecordProduct("Tester", 20.22, 2024, Genre.POP);
		if(inventory.removeItem(product)) {
			System.out.println("Removal correct.");
		}
		if(inventory.addItem(product_2)) {
			System.out.println("Addition correct.");
		}
		
		// Checks saveStock method
		if(inventory.saveStock()) {
			System.out.println("Inventory updated to CSV");
		}
		
		// Check getting CD, Tape, and Vinyl lists
		ArrayList<MediaProduct> products = inventory.getInventory();
		System.out.println("\n***************CD List*****************\n");
		for(CDRecordProduct cd : inventory.getCDRecordsList(products)) {
			System.out.println(cd);
		}
		System.out.println("\n***************Tape List*****************\n");
		for(TapeRecordProduct tape : inventory.getTapeRecordList(products)) {
			System.out.println(tape);
		}
		System.out.println("\n***************Vinyl List*****************\n");
		for(VinylRecordProduct vinyl : inventory.getVinylRecordList(products)) {
			System.out.println(vinyl);
		}
		
		
    
       
	}
}
