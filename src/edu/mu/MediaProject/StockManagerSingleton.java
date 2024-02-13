package edu.mu.MediaProject;

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
	

}
