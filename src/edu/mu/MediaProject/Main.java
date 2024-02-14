package edu.mu.MediaProject;

import java.util.*;
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
	}
}
