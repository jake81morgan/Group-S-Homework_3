package edu.mu.MediaProject;

public class Main {

	public static void main(String[] args) {

		StockManagerSingleton inventory = StockManagerSingleton.getInstance();
		inventory.initializeStock();

	}

}
