package edu.mu.MediaProject;

import java.util.*;

import edu.mu.MediaProject.MediaProducts.Genre;
import edu.mu.MediaProject.MediaProducts.MediaProduct;


public class Main {
	public static void main(String[] args) {
		StockManagerSingleton inventory = StockManagerSingleton.getInstance();
		
		boolean Initialization = inventory.initializeStock();
		//Test to see if the Initialization went through or not
		if(!Initialization) {
			System.out.println("Could not initialize the stock");
			return ;
		}
		
		// Retrieve the inventory
       ArrayList<MediaProduct> Inventory = inventory.getInventory();
       // Loop through the inventory and print each item
       System.out.println("Inventory:");
       for (MediaProduct product : Inventory) {
           System.out.println(product);
       }  
       
       if(inventory.saveStock()) {
    	   System.out.println("Inventory written to CSV file.");
       } else {
    	   System.out.println("Writing error.");
       }
       
       ArrayList<MediaProduct> belowPriceProducts = inventory.getMediaProductBelowPrice(14);
       System.out.println("Products less than $14");
       for (MediaProduct product : belowPriceProducts) {
           System.out.println(product);
       }
       
	}
}
