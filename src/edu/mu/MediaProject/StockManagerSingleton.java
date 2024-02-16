package edu.mu.MediaProject;

import java.io.*;
import java.util.*;

import edu.mu.MediaProject.MediaProducts.*;

public class StockManagerSingleton {
	
	// Initialize members
	private static final String inventoryFilePath = "inventory.csv";
	private static StockManagerSingleton instance = null;
	private ArrayList<MediaProduct> inventory;
	
	private StockManagerSingleton() {
		
	}
	
	// Creates single instance of class
	public static StockManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockManagerSingleton();
		}
		return instance;
		
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

	
	// Updates the price of a given product
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
	if(newPrice >= 0) {
		product.setPrice(newPrice);
		return true;
	}
		return false;
	}
	
	// Adds product to inventory
	public boolean addItem(MediaProduct product) {
		if(inventory.contains(product)) {
		return false;
	}
		inventory.add(product);
		return true;
	}
	
	// Removes product from inventory
	public boolean removeItem(MediaProduct product) {
		inventory.remove(product);
		if(inventory.contains(product)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Takes the inventory ArrayList and saves it to the existing CSV file by overwriting
	public boolean saveStock() {
		
		try {
			
			// Initializes writer
			BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath));
			
			// Created header of file
			writer.write("Type,Title,Price,Year,Genre");
            writer.newLine();

            for(MediaProduct p : inventory) {
            	
            	// Adds products to CSV file
            	if(p instanceof CDRecordProduct) {
            		writer.write( "CD" + "," + p.getTitle() + "," + p.getPrice() + "," + p.getYear() + "," + p.getGenre());
            	} else if (p instanceof TapeRecordProduct) {
            		writer.write( "Tape" + "," + p.getTitle() + "," + p.getPrice() + "," + p.getYear() + "," + p.getGenre());
            	} else if (p instanceof VinylRecordProduct) {
            		writer.write( "Vinyl" + "," + p.getTitle() + "," + p.getPrice() + "," + p.getYear() + "," + p.getGenre());
            	}
            	
            	writer.newLine(); // Moves to next line
                
            }

            // Close the writer
            writer.close();
			
			return true;
			
		} catch (IOException e) {
			
			System.out.println("File write error.");
			return false;
			
		} 
		
	}
	
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		ArrayList<MediaProduct> belowPrice = new ArrayList<>();

        for (MediaProduct product : this.inventory) {
            if (product.getPrice() < maxPrice) {
                belowPrice.add(product);
            }
        }

        return belowPrice;
	}
	
	// Prints a list of MediaProducts
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
	    for (MediaProduct product : productList) {
	        System.out.println(product);
	    }
	}

	
	// Retrieves a list of VinylRecordProducts from a list of MediaProducts
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
	    ArrayList<VinylRecordProduct> vinylRecords = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof VinylRecordProduct) {
	            vinylRecords.add((VinylRecordProduct) product);
	        }
	    }
	    return vinylRecords;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		ArrayList<CDRecordProduct> CDRecords = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof CDRecordProduct) {
	        	CDRecords.add((CDRecordProduct) product);
	        }
	    }
	    return CDRecords;
	}
	
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		ArrayList<TapeRecordProduct> TapeRecords = new ArrayList<>();
	    for (MediaProduct product : productList) {
	        if (product instanceof TapeRecordProduct) {
	        	TapeRecords.add((TapeRecordProduct) product);
	        }
	    }
	    return TapeRecords;
	}
	
	
	// Inventory getter and setter
	
	public ArrayList<MediaProduct> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<MediaProduct> inventory) {
		this.inventory = inventory;
	}
	
}
