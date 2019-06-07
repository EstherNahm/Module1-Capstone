package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Inventory {
	//Inventory of Slot ID's and associated snacks.
	private static TreeMap<String, ArrayList<Snack>> slots = new TreeMap<String, ArrayList<Snack>>();
	//int[] snackQuantities = new int[16];
	/**
	 * @return the slots
	 */
	public TreeMap<String, ArrayList<Snack>> getSlots() {
		return slots;
	}
	
//	public int[] getSnackQuantities() {
//		return snackQuantities;
//	}	

	public Inventory() {
		//Got the file with the inventory.
		File input = new File("vendingmachine.csv");
		//Created a place to store the data.
		String line;
		
		try {
		Scanner fileScanner = new Scanner(input);
			while (fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				String words[] = line.split("\\|");
				Snack newSnack = new Snack(words[1], Double.parseDouble(words[2]), words[3], 5);
				ArrayList<Snack> newSnacks = new ArrayList<Snack>();
				for(int i = 0; i < 5; i++) {
					newSnacks.add(newSnack);
					//snackQuantities[i] = 5;
				}
				slots.put(words[0], newSnacks);
			}
		}catch(FileNotFoundException e) {
			
		}
	}
		
	public void printContents() {
		Set <String>inventoryKeys = slots.keySet();
		for(String slotID : inventoryKeys) {
			System.out.println(slotID + "|" + slots.get(slotID).get(1));
		}
	}
}