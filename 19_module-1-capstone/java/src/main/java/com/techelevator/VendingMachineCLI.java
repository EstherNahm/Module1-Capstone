package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;

public class VendingMachineCLI extends VendingMachineClass{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT
													    };
	//menu items for Purchase Menu 
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY                  = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT              = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION          = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
													    PURCHASE_MENU_OPTION_SELECT_PRODUCT,
													    PURCHASE_MENU_OPTION_FINISH_TRANSACTION,
													    };
	private static Menu vendingMenu;              // Menu object to be used by an instance of this class
	private static VendingMachineClass ourVendingMachine = new VendingMachineClass();
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pass a menu for this class to use
		vendingMenu = menu;           // Make the Menu the user object passed, our Menu
	}
	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	 * @throws FileNotFoundException 
	***************************************************************************************************************************/
	
	public void run() throws FileNotFoundException {

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					System.out.printf("Current Money Provided: $ %.2f", getBalance(), "0");
					purchaseItems();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_EXIT:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;                    // Exit switch statement
			}	
		}
		return;                               // End method and return to caller
	}
/********************************************************************************************************
 * Methods used to perform processing
 ********************************************************************************************************/
	public static void displayItems() {      // static attribute used as method is not associated with specific object instance
		ourVendingMachine.printInventory();
	}
	
	//loop for purchase menu 
	public static void purchaseItems() throws FileNotFoundException {	 // static attribute used as method is not associated with specific object instance
	
		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			String choice = (String)vendingMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); 
			 // Display menu and get choice
			switch(choice) { 
				
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					insertMoney();           // method to display items in purchase menu 
					break;                    
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					selectProduct();          // method to pick item from purchase menu 
					break;                    
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					exitOut();    // method to finish out 
					shouldProcess = false;// Set variable to end loop
					break;                    // Exit switch statement
			}
		}
		return;
	}
	
	//private static void selectProduct() {}
		// TODO Auto-generated method stub
		
	
	public static void endMethodProcessing() { // static attribute used as method is not associated with specific object instance
		ourVendingMachine.printSales();
	}
}
