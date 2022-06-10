package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

public class VendingMachineCLI {
	NumberFormat currency = NumberFormat.getCurrencyInstance();

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };

	private static final String PURCHASE_MENU_FEED = "Feed Money";
	private static final String PURCHASE_MENU_SELECT = "Select Product";
	private static final String PURCHASE_MENU_EXIT = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED, PURCHASE_MENU_SELECT, PURCHASE_MENU_EXIT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		boolean vending = true;
		String[] activeMenu = MAIN_MENU_OPTIONS;


		VendingMachine vm = new VendingMachine();
		List<Products> products = vm.importProducts();

		Money balance = new Money();
		balance.setBalance(0);

		while (vending) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vm.displayProducts(products);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println("Current Money Provided: " + currency.format(balance.getBalance()));
				boolean purchasing = true;
				while(purchasing){
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if(purchaseChoice.equals(PURCHASE_MENU_FEED)){
						balance.setBalance(vm.feedMoney(balance.getBalance()));

					}
					else if (purchaseChoice.equals(PURCHASE_MENU_SELECT)){
						//Purchase
						vm.purchaseProduct(balance, products);

					}
					else if(purchaseChoice.equals(PURCHASE_MENU_EXIT)){
						System.out.println("Returning to Main Menu");
						purchasing = false;
					}
				}

			}else if (choice.equals(MAIN_MENU_EXIT)){
				System.out.println("Thanks for shopping.");
				vending = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
