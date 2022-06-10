package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;

public class VendingMachineCLI {

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

	public void run() {
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
				System.out.println("Current Money Provided: $" + balance.getBalance());
				boolean purchasing = true;
				while(purchasing){
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if(purchaseChoice.equals(PURCHASE_MENU_FEED)){
						balance.setBalance(vm.feedMoney(balance.getBalance()));

						System.out.println(balance.getBalance());
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

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);


		cli.run();
	}
}
