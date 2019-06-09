package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Inventory {
	//inventory of Slot ID's and associated snacks 
	private static TreeMap<String, ArrayList<Snack>> slots = new TreeMap<String, ArrayList<Snack>>();
	
	/**
	 * @return the slots
	 */
	public TreeMap<String, ArrayList<Snack>> getSlots() {
		return slots;
	}

	public Inventory() {
		//get the file with the inventory
		File input = new File("vendingmachine.csv");
		
		//String to store data
		String line;
		
		//scan in lines from file 
		try {
		Scanner fileScanner = new Scanner(input);
			while (fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				
				//split the files at | deliminator 
				String words[] = line.split("\\|");
				
				//assign index [1]-[3] to arrayList<Snack> which is the value of TreeMap slots
				Snack newSnack = new Snack(words[1], Double.parseDouble(words[2]), words[3]);
				ArrayList<Snack> newSnacks = new ArrayList<Snack>();
				for(int i = 0; i < 5; i++) {
					newSnacks.add(newSnack);
				}
				slots.put(words[0], newSnacks);
			}
		}catch(FileNotFoundException e) {
			
		}
	}
		
	public void printContents() {
		Set <String>inventoryKeys = slots.keySet();
		
		for(String slotID : inventoryKeys) {
			if(!(slots.get(slotID).size() <= 0)) {
				System.out.println(slotID + "|" + slots.get(slotID).get(0).getName() + " " + slots.get(slotID).get(0).getPrice() + " " + slots.get(slotID).get(0).getType());
			} else {
				System.out.println(slotID + "|" + "SOLD OUT");
			}
		
		}
	}
}