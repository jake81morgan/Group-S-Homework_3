package edu.mu.MediaProject;

import java.io.*;
import java.util.*;

import edu.mu.MediaProject.MediaProducts.*;

public class StockManagerSingleton {
	
	private static final String inventoryFilePath = "inventory.csv";
	private static StockManagerSingleton instance = null;
	private ArrayList<MediaProduct> inventory;
	
	private StockManagerSingleton() {
		
	}
	
	public static StockManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockManagerSingleton();
		}
		return instance;
		
	}
	
	// Returns inventory ArrayList
	public ArrayList<MediaProduct> getInventory() {
		return inventory;
	}
	
	// Adds products from file to inventory ArrayList
	public boolean initializeStock() {
		
		inventory = new ArrayList<MediaProduct>();
		
		try {
			
			// Initializes the file reader
			Scanner scanner = new Scanner(new FileInputStream(inventoryFilePath));
			
			// Skips header line of file
			scanner.nextLine();
			
			// Reads product info from file
			while(scanner.hasNext()) {
				
				MediaProduct product;
				String[] info;
				
				// Read product info off file
				info = scanner.nextLine().split(",");

				String type = info[0];
				String title = info[1];
				double price = Double.parseDouble(info[2]);
				int year = Integer.parseInt(info[3]);
				Genre genre = Genre.valueOf(info[4]);
				
				// Add product to inventory
				if(info[0].equals("CD")) {
					product = new CDRecordProduct(title, price, year, genre);
					inventory.add(product);
				} else if(info[0].equals("Tape")) {
					product = new TapeRecordProduct(title, price, year, genre);
					inventory.add(product);
					
				} else if(info[0].equals("Vinyl")) {
					product = new VinylRecordProduct(title, price, year, genre);
					inventory.add(product);
				}
				
			}
			
			return true;
			
		  // Thrown if file directory is incorrect
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found.");
			return false;
			
		}
		
	}

	
	//Updates the price of a given product
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
	if(newPrice >= 0) {
		product.setPrice(newPrice);
		return true;
	}
		return false;
	}
	
	//public boolean addItem(MediaProduct product);
	
	//public boolean removeItem(MediaProduct product);
	
	//public boolean saveStock();
	
	//public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice);
	
	//public void printListOfMediaProduct(ArrayList<MediaProduct> productList);
	
	//public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList);
	
	//public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList);
	
	//public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList);
	
}
