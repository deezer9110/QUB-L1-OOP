package part01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class acts as the application for the user to interact with the system, as
 * well as having many utility methods embedded into it for the user to use
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 */
public class QUBKitchen extends Resources {

	public static ArrayList<Ingredient> allIngredients = addIngredients();
	public static ArrayList<Recipe> allRecipes = addRecipes();
	public static ArrayList<DailyMenu> allDailyMenus = addDailyMenus();
	public static ArrayList<String> availableDays = new ArrayList<String>(
			Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
	public static String[] ingredientOptions = { "Id", "Name", "Food Group" };
	public static String[] recipeOptions = { "Id", "Name" };
	public static Scanner input = new Scanner(System.in); // Creates a static input to be used throughout the code

	/**
	 * Main method which begins on the main menu, contains a while loop so all
	 * commands can be done without having to recall the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		allIngredients = sortIngredients(allIngredients);
		allRecipes = sortRecipes(allRecipes);
		allDailyMenus = sortDailyMenus(allDailyMenus);
		setAvailableDays();
		availableDays = sortAvailableDays(availableDays);

		String[] options = { "Manage Ingredients", "Manage Recipes", "Manage Weekly Menu", "Quit" }; // Main menu
																										// options
		Menu mainMenu = new Menu("QUBKitchen", options); // Creates the main menu
		int choice = 0; // Used to take note of the user's choice
		mainMenu.display();

		do {
			try {
				choice = mainMenu.getChoice(); // Runs method to take in the user's choice and process it
				switch (choice) {
				case 1:
					manageIngredients(); // Opens the Manage Ingredients menu
					mainMenu.display();
					break;
				case 2:
					manageRecipes(); // Opens the Manage Recipes menu
					mainMenu.display();
					break;
				case 3:
					manageWeeklyMenu(); // Opens the Manage Weekly Menu menu
					mainMenu.display();
					break;
				default:
					break;
				}
			} catch (Exception e) { // Catches unexpected errors
				System.out.println("Unexpected error: " + e + "\nRestarting menu");
				mainMenu.display();
			}
		} while (choice != options.length); // If an option equal to the option's length if picked, the program will
											// quit
		System.out.println("Goodbye! Have a nice day!");
		System.exit(0);
	}

	/**
	 * Allows user's input to be checked to cancel their current operation in the
	 * application for Strings
	 * 
	 * @param input - String input from user
	 * @return - true/false to see if operation should or shouldn't be cancelled
	 */
	public static boolean checkCancel(String input) {
		if (input.equals("cancel")) { // Checks if their input is equal to "cancel", if it returns true, a method will
										// cancel and they'll be sent to their relevant menu
			return true;
		}
		return false;
	}

	/**
	 * Overloaded checkCancel for integer values
	 * 
	 * @param input - Integer input from user
	 * @return - true/false to see if operation should or shouldn't be cancelled
	 */
	public static boolean checkCancel(int input) {
		if (input == -1) { // Checks if their input is equal to -1 instead of "cancel"
			return true;
		}
		return false;
	}

	/**
	 * This method provides an option for users to enter a String value without
	 * using System.out.print in every other method, allowing all other methods to
	 * be implemented easily into the Console
	 * 
	 * @param prompt - Details about what user is asked to enter
	 * @return - Returns String input from user
	 */
	public static String selectString(String prompt) {
		try {
			String result = ""; // Initialises return String
			System.out.print("\nType 'cancel' to cancel and return to menu\n" + prompt + "\n---> ");
			// Gives user an option to cancel the input (so it can be checked after
			// returning to original method) and prompts them to enter a value
			result = input.nextLine(); // Result reads and uses the next line for its value
			return result;
		} catch (Exception e) {
			System.out.println("Enter a valid choice"); // If an error is found, it will prompt the user to try again
														// until it's valid
			return selectString(prompt);
		}
	}

	/**
	 * Provides an option for users to enter an integer for better implementation
	 * with a new console, similar to the selectString method
	 * 
	 * @param prompt - Details about what user is asked to enter
	 * @return - Returns integer input from user
	 */
	public static int selectInt(String prompt) {
		try {
			int result = 0; // Initialises return integer
			System.out.print("\nType -1 to cancel and return to menu\n" + prompt + "\n---> ");
			// Gives user an option to cancel the input which is checked after return,
			// prompts user to enter a value
			result = input.nextInt(); // Reads and saves the next inputed integer
			input.nextLine(); // Reads and clears input scanner
			return result;
		} catch (Exception e) {
			System.out.println("Invalid option picked! Ensure valid input!"); // Prompts user to redo the method if an
																				// error is caught
			input.nextLine();
			return selectInt(prompt);
		}
	}

	/**
	 * Displays all items in a relative menu for user to select an index from
	 * 
	 * @param menu   - Relative menu name for displaying items
	 * @param prompt - Details about what user is asked to enter
	 * @return - Returns index of the item that is being selected
	 */
	public static int selectItem(String menu, String prompt) {

		System.out.println("\n" + displayAllItems(menu)); // Displays all items of relative menu
		if (displayAllItems(menu).equals("No items to display from selected list")) {
			// returns -2 if there are no items to select in the desired menu
			return -2;
		}
		int itemIndex = selectInt(prompt) - 1; // User enters the item they want, removes 1 to account for indexes
												// starting from 0, not 1
		if (itemIndex == -2) { // Ensures -2 is returned for check cancel in the case of cancelling
			return itemIndex;
		}
		switch (menu) { // Ensures the item selected is valid -> not less than 0, less than the relative
						// array list size
		case "Ingredient":
			if (itemIndex >= allIngredients.size() || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Recipe":
			if (itemIndex >= allRecipes.size() || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Daily Menu":
			if (itemIndex >= allDailyMenus.size() || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Food Type":
			if (itemIndex >= FoodType.values().length || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Available Day":
			if (itemIndex >= availableDays.size() || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Ingredient Option":
			if (itemIndex >= ingredientOptions.length || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		case "Recipe Option":
			if (itemIndex >= recipeOptions.length || itemIndex < 0) {
				return selectItem(menu, "Please enter a valid " + menu + " index: ");
			}
			break;
		}
		return itemIndex;
	}

	/**
	 * Leads users to a method to add or remove an item from a relevant menu between
	 * ingredients, recipes and daily menus
	 * 
	 * @param menu - Relative menu name for displaying items
	 * @return - Returns true/false if operation has run
	 */
	public static boolean addItem(String menu) {
		switch (menu) { // Switches the menu parameter to decide what method to bring the user to
		case "Ingredient":
			return addIngredient();
		case "Recipe":
			return addRecipe();
		case "Daily Menu":
			return addDailyMenu();
		}
		return false;
	}

	/**
	 * Allows the user to remove an item from a relevant menu with an index from the
	 * user to decide which one
	 * 
	 * @param menu  - Relative menu name for displaying items
	 * @param index - Index of item to remove
	 * @return - Returns true / false if method has run successfully or not
	 */
	public static boolean removeItem(String menu, int index) {

		setAvailableDays();
		switch (menu) {
		case "Ingredient":
			// This set of nested for loops is for a cascade delete to ensure the system's
			// lists stay intact with missing ingredient references
			for (int r = 0; r < allRecipes.size(); r++) { // Iterates through each recipe
				for (int i = 0; i < allRecipes.get(r).getIngredients().size(); i++) {
					// Iterates through each ingredient of a recipe
					if (allRecipes.get(r).getIngredients().get(i).equals(allIngredients.get(index))) {
						// Compares each recipe ingredient with the one to remove
						for (int d = 0; d < allDailyMenus.size(); d++) {
							// Iterates through each Daily Menu
							for (int x = 0; x < allDailyMenus.get(d).getRecipes().length; x++) {
								// Iterates through each recipe in a Daily Menu
								if (allDailyMenus.get(d).getRecipes()[x].equals(allRecipes.get(r))) {
									// Compares each recipe with the one that has an ingredient that's going to be
									// deleted
									availableDays.add(allDailyMenus.get(d).getDayOfTheWeek());
									// Adds that Daily Menu's day of the week back to the list for further addition
									availableDays = sortAvailableDays(availableDays);
									// Sorts the days of the week back into order
									allDailyMenus.remove(d); // Removes that daily menu from the list of all Daily Menus
									d--; // Decrements the for loop so it doesn't break as the allDailyMenus list is
											// getting one value smaller
									break;
								}
							}
						}
						allRecipes.remove(r); // Removes the recipe with the ingredient to be removed and breaks the
												// loop
						r--;
						break;
					}

				}
			}
			allIngredients.remove(index); // Removes the ingredient
			return true;
		case "Recipe":
			// This set of nested for loops is for a cascade delete to ensure the system's
			// lists stay intact with missing ingredient references
			for (int d = 0; d < allDailyMenus.size(); d++) {
				// Iterates through each Daily Menu
				for (int r = 0; r < allDailyMenus.get(d).getRecipes().length; r++) {
					// Iterates through each recipe in the Daily Menu
					if (allDailyMenus.get(d).getRecipes()[r].equals(allRecipes.get(index))) {
						// Compares the Daily Menu recipe with the one to be deleted
						availableDays.add(allDailyMenus.get(d).getDayOfTheWeek()); // Available days list updated
						availableDays = sortAvailableDays(availableDays);
						// Sorts the days of the week back into order
						allDailyMenus.remove(d); // Daily Menu with the recipe removed
					}
				}
			}
			allRecipes.remove(index); // Recipe removed
			return true;
		case "Daily Menu":
			availableDays.add(allDailyMenus.get(index).getDayOfTheWeek()); // Updates available days
			availableDays = sortAvailableDays(availableDays); // Sorts the days of the week back into order
			allDailyMenus.remove(index); // Removes the daily menu from the list
			return true;
		}

		return false;
	}

	/**
	 * Removes all items from selected list with a cascade delete
	 * 
	 * @param menu - Relative menu name for displaying items
	 * @return - Returns true/false if method has run successfully
	 */
	public static boolean removeAllItems(String menu) {
		switch (menu) {
		case "Ingredient":
			allIngredients.clear();
			allRecipes.clear();
			allDailyMenus.clear();
			break;
		case "Recipe":
			allRecipes.clear();
			allDailyMenus.clear();
			break;
		case "Daily Menu":
			allDailyMenus.clear();
			availableDays = new ArrayList<String>(
					Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
			break;
		}
		availableDays = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
		return true;
	}

	/**
	 * Displays all items from a desired menu for user to select or view items in
	 * lists
	 * 
	 * @param menu - Relative menu name for displaying items
	 * @return - Returns String of all items from a selected list
	 */
	public static String displayAllItems(String menu) {
		String result = "All " + menu + "s are as follows: "; // Initial message so user can establish what's going to
																// be shown

		switch (menu) { // Menu is switched to allow for each item to be presented, starting from a
						// value of 1 to its list length
		case "Ingredient":
			for (int i = 0; i < allIngredients.size(); i++) {
				result += "\n" + (i + 1) + ". " + allIngredients.get(i).getName();
			}
			break;
		case "Recipe":
			for (int i = 0; i < allRecipes.size(); i++) {
				result += "\n" + (i + 1) + ". " + allRecipes.get(i).getName();
			}
			break;
		case "Daily Menu":
			for (int i = 0; i < allDailyMenus.size(); i++) {
				result += "\n" + (i + 1) + ". " + allDailyMenus.get(i).getDayOfTheWeek();
			}
			break;
		case "Food Type":
			for (int i = 0; i < FoodType.values().length; i++) {
				result += "\n" + (i + 1) + ". " + FoodType.values()[i];
			}
			break;
		case "Available Day":
			for (int i = 0; i < availableDays.size(); i++) {
				result += "\n" + (i + 1) + ". " + availableDays.get(i);
			}
			break;
		case "Ingredient Option":
			for (int i = 0; i < ingredientOptions.length; i++) {
				result += "\n" + (i + 1) + ". " + ingredientOptions[i];
			}
			break;
		case "Recipe Option":
			for (int i = 0; i < recipeOptions.length; i++) {
				result += "\n" + (i + 1) + ". " + recipeOptions[i];
			}
			break;
		}

		if (result.equals("All " + menu + "s are as follows: ")) { // Allows a message to be sent to show there are no
																	// days in the list
			result = "No items to display from selected list";
		}

		return result; // Result is returned

	}

	/**
	 * Returns the toString method of the details of an item chosen by the user
	 * 
	 * @param menu  - Relative menu name for displaying items
	 * @param index - Index of list from
	 * @return - Returns toString of an item's details
	 */
	public static String displayItemDetails(String menu, int index) {
		if (allIngredients.size() < 1 || allRecipes.size() < 1 || allDailyMenus.size() < 1) {
			return "No " + menu + "s available to display";
			// Ensures error is handled if lists are empty
		}
		String itemDetails = "";
		switch (menu) { // Switches menu to add item details to a string
		case "Ingredient":
			itemDetails = allIngredients.get(index).toString();
			break;
		case "Recipe":
			itemDetails = allRecipes.get(index).toString();
			break;
		case "Daily Menu":
			itemDetails = allDailyMenus.get(index).toString();
			break;
		default:
			itemDetails = "No data available";
			break;

		}
		return itemDetails; // Returns item details
	}

	/**
	 * Manage ingredients menu for users to use all ingredient related functions
	 */
	public static void manageIngredients() {
		String[] options = { "Add ingredient", "Remove ingredient", "Remove all ingredients", "Display all ingredients",
				"Display ingredient details", "Search for an ingredient", "Update ingredient details",
				"Return to Main Menu" };
		// All options for ingredients
		Menu ingredientsMenu = new Menu("Manage Ingredients", options); // Creates menu object for ingredients
		int choice = 0; // Instantiates choice
		ingredientsMenu.display(); // Displays ingredients menu
		do {
			allIngredients = sortIngredients(allIngredients); // Sorts ingredients into alphabetical order
			try {
				choice = ingredientsMenu.getChoice(); // Gets user choice for menu
				switch (choice) {
				case 1: // Add ingredient
					if (addItem("Ingredient")) { // Runs method to add an item which will run the method to add an
													// ingredient
						System.out.println("Ingredient added successfully! "); // Success message
					} else {
						System.out.println("Ingredient not added "); // Failure message
					}
					ingredientsMenu.display(); // Redisplays ingredients menu
					break;
				case 2: // Removes ingredients
					if (allIngredients.size() > 0) { // Checks that ingredient size is over 0
						int index = selectItem("Ingredient", "Enter a valid ingredient: ");
						// Prompts user to select an ingredient to remove
						if (!checkCancel(index + 1)) { // Checks cancel
							if (removeItem("Ingredient", index)) { // Removes item
								System.out.println("Ingredient removed!"); // Confirmation message
							}
						}
					} else {
						System.out.println("No ingredients to remove"); // Displays if allIngredients is empty
					}
					ingredientsMenu.display();
					break;
				case 3: // Removes all ingredients
					if (allIngredients.size() > 0 && removeAllItems("Ingredient")) {
						// Checks to make sure allIngredients had items and removes them after
						System.out.println("Ingredients removed!"); // Confirmation message
					} else {
						System.out.println("No ingredients to remove"); // Stated if there aren't ingredients to remove
					}
					ingredientsMenu.display();
					break;
				case 4: // Display all ingredients
					if (allIngredients.size() > 0) { // Checks size of allIngredients
						System.out.println(displayAllItems("Ingredient")); // Displays all ingredients
					} else {
						System.out.println("No ingredients to display!"); // Displays if list is empty
					}
					ingredientsMenu.display();
					break;
				case 5: // Display ingredient details
					if (allIngredients.size() > 0) { // Ensures list has items
						int index = selectItem("Ingredient", "Enter a valid ingredient: "); // Prompts for index of
																							// ingredient to display
						if (!checkCancel(index + 1)) { // Checks cancel
							System.out.println(displayItemDetails("Ingredient", index)); // Displays details of
																							// ingredient
						}
					} else {
						System.out.println("No ingredients to display!"); // Displays if list is empty
					}
					ingredientsMenu.display();
					break;
				case 6: // Search for an ingredient
					if (allIngredients.size() > 0) { // Checks that there are items in the list
						int searchBy = selectItem("Ingredient Option", "Select what you want to search by: ");
						// Prompts for an option to search by
						if (!checkCancel(searchBy)) { // Checks cancel
							switch (searchBy) {
							case 0: // Search by id
								int search1 = selectInt("Enter ingredient id: "); // Prompts for id
								if (!checkCancel(search1)) { // Checks cancel
									ArrayList<Ingredient> results = searchForIngredient(allIngredients, search1);
									// Creates results array
									if (results.size() > 0) { // Makes sure it's over 0
										for (Ingredient i : results) {
											System.out.println("\n" + i); // Prints each item in the results array
										}
									} else {
										System.out.println("No results meet the criteria"); // Empty results list result
									}
								}
								break;
							case 1: // Search by name
								String search2 = selectString("Enter ingredient name: "); // Checks that there are items
								if (!checkCancel(search2)) {
									ArrayList<Ingredient> results = searchForIngredient(allIngredients, search2);
									if (results.size() > 0) {
										for (Ingredient i : results) {
											System.out.println("\n" + i);
										}
									} else {
										System.out.println("No results meet the criteria");
									}
								}
								break;
							case 2: // Search by food group
								int search3 = selectItem("Food Type", "Enter ingredient food type: ");
								if (!checkCancel(search3)) {
									FoodType foodType = FoodType.values()[search3]; // Gets correct food group from
																					// index
									ArrayList<Ingredient> results = searchForIngredient(allIngredients, foodType);
									if (results.size() > 0) {
										for (Ingredient i : results) {
											System.out.println("\n" + i);
										}
									} else {
										System.out.println("No results meet the criteria");
									}
								}
								break;
							default:
								break;
							}
						} else {
							System.out.println("No ingredients to display!"); // Displays if list is empty
						}
						ingredientsMenu.display();
					}
					break;
				case 7: // Update ingredient
					if (allIngredients.size() > 0 && updateIngredientChoice(allIngredients)) {
						// Ensures list has ingredients and runs the update method
						System.out.println("Ingredient updated!"); // Confirmation message
					} else {
						System.out.println("No ingredients to update!"); // Empty list message
					}
					ingredientsMenu.display();
				default:
					break;
				}
			} catch (Exception e) { // Catches unexpected menu errors
				System.out.println("Unexpected error: " + e + "\nRestarting menu");
				ingredientsMenu.display();
			}
		} while (choice != options.length); // Breaks loop if last (8th) option is picked

		System.out.println("Back to main menu: ");
	}

	/**
	 * Allows user to add an ingredient
	 * 
	 * @return - Returns true/false if ingredient has been added
	 */
	public static boolean addIngredient() {

		try {
			String name = selectString("Enter name: "); // Prompts for name
			if (checkCancel(name)) { // Checks cancel
				return false;
			}
			FoodType foodType;
			int foodTypeIndex = selectItem("Food Type", "Enter a valid food type: "); // Selects a valid food type index
			if (checkCancel(foodTypeIndex + 1)) { // Checks cancel
				return false;
			}
			foodType = FoodType.values()[foodTypeIndex]; // Confirms food type
			int caloriesPer100g = 0;
			do {
				caloriesPer100g = selectInt("Enter the calories per 100g: "); // Gets calories
				if (checkCancel(caloriesPer100g)) { // Checks cancel
					return false;
				}
			} while (caloriesPer100g < 0); // Ensures calories are positive
			String extraDetails = selectString("Enter any extra details about the ingredient: "); // Prompts for extra
																									// details
			if (checkCancel(extraDetails)) { // Checks cancel
				return false;
			}
			Ingredient i = new Ingredient(name, foodType, caloriesPer100g, extraDetails); // Makes a new ingredient
			allIngredients.add(i); // Adds ingredient to list
			allIngredients = sortIngredients(allIngredients);
			return true;
		} catch (Exception e) { // Catches exceptions
			System.out.println("Error: " + e);
			return addIngredient();
		}
	}

	/**
	 * Allows user to update ingredient details
	 * 
	 * @param ingredientList - List of ingredients to choose one to update from
	 * @return - Returns true/false if ingredient has updated
	 */
	public static boolean updateIngredientChoice(ArrayList<Ingredient> ingredientList) {
		try {
			String allIngredients = "All ingredients are as follows: ";
			// Creates a string list of ingredients to output for prompt -> can't use
			// displayAllItems as this may have different recipe ingredient lists too
			for (int i = 0; i < ingredientList.size(); i++) {
				allIngredients += "\n" + (i + 1) + ": " + ingredientList.get(i).getName();
			}
			int index = 0;
			do {
				index = selectInt(allIngredients + "\nWhich ingredient would you like to update?") - 1; // Prompts for
																										// index
				if (checkCancel(index + 1)) { // Checks cancel
					return false;
				}
			} while (index < 0 || index > ingredientList.size() - 1); // Ensures index is valid
			int choice = 0;
			do {
				choice = selectInt(
						"\n1. Name\n2. Extra Details\n3. Food Type\n4. Calories per 100g\n\nWhich ingredient attribute do you want to update?: ");
				// Prompts user for what to update
				if (checkCancel(choice)) { // Checks cancel
					return false;
				}
				switch (choice) { // Switches choice
				case -1:
					return false;
				case 1: // Name
					String newName = selectString("Enter a new name: "); // Prompts for name
					if (checkCancel(newName)) { // Checks cancel
						return false;
					}
					if (!updateIngredient(ingredientList, index, 1, newName)) { // Updates
						return false;
					}
					break;
				case 2: // Extra Details
					String newEDs = selectString("Enter new extra details: "); // Prompts for extra details
					if (checkCancel(newEDs)) { // Checks cancel
						return false;
					}
					if (!updateIngredient(ingredientList, index, 2, newEDs)) { // Updates
						return false;
					}
					break;
				case 3: // Food Type
					int foodTypeIndex = selectItem("Food Type", "Enter new food type: "); // Prompts for food type
					if (checkCancel(foodTypeIndex)) {
						return false;
					}
					if (!updateIngredient(ingredientList, index, FoodType.values()[foodTypeIndex])) { // Updates
						return false;
					}
					break;
				case 4: // Calories per 100g
					int caloriesPer100g = 0;
					do {
						caloriesPer100g = selectInt("Enter new calories per 100g amount (must be >= 0): ");
						// Prompts for calories per 100g
						if (checkCancel(caloriesPer100g)) { // Checks cancel
							return false;
						}
					} while (caloriesPer100g < 1); // Ensures amount is more than 0
					if (!updateIngredient(ingredientList, index, caloriesPer100g)) { // Updates
						return false;
					}
					break;
				default:
					break;
				}
			} while (choice < 1 || choice > 4); // Ensures choice is between 1-4

			return true;
		} catch (Exception e) {
			return updateIngredientChoice(ingredientList); // Runs if an error occurs
		}
	}

	/**
	 * Used to update an ingredient's name or extra details
	 * 
	 * @param allIngredients  - list of ingredients
	 * @param ingredientIndex - ingredient index in list
	 * @param updateDetail    - update detail between name and extra details
	 * @param updateValue     - update value from user
	 * @return - true / false value if method word
	 */
	public static boolean updateIngredient(ArrayList<Ingredient> allIngredients, int ingredientIndex, int updateDetail,
			String updateValue) { // Switches what the user wants to update
		try {
			if (updateValue == null || updateValue == "") { // Ensures value isn't null or empty
				return false;
			}
			switch (updateDetail) {
			case 1:
				allIngredients.get(ingredientIndex).setName(updateValue); // Updates the ingredient name
				break;
			case 2:
				allIngredients.get(ingredientIndex).setExtraDetails(updateValue); // Updates the ingredient extra //
																					// details
				break;
			}
			return true; // Returns true on completion
		} catch (Exception e) {
			return updateIngredient(allIngredients, ingredientIndex, updateDetail, updateValue); // Will return the same
																									// method if an
			// error occurs
		}
	}

	/**
	 * Updates the ingredient's food group
	 * 
	 * @param allIngredients  - list of ingredients
	 * @param ingredientIndex - ingredient index in list
	 * @param updateValue     - update value from user
	 * @return
	 */
	public static boolean updateIngredient(ArrayList<Ingredient> allIngredients, int ingredientIndex,
			FoodType updateValue) {
		try {
			if (updateValue == null) { // Ensures value isn't null or empty
				return false;
			}
			allIngredients.get(ingredientIndex).setFoodType(updateValue); // Updates the value
			return true;
		} catch (Exception e) {
			return updateIngredient(allIngredients, ingredientIndex, updateValue); // Catches errors and returns the
																					// same method
		}
	}

	/**
	 * Updates the ingredient's calories per 100g
	 * 
	 * @param allIngredients  - list of ingredients
	 * @param ingredientIndex - ingredient index in list
	 * @param updateValue     - update value from user
	 * @return
	 */
	public static boolean updateIngredient(ArrayList<Ingredient> allIngredients, int ingredientIndex, int updateValue) {
		try {
			if (updateValue < 0) { // Ensures amount of calories is over 0
				return false;
			}
			allIngredients.get(ingredientIndex).setCaloriesPer100g(updateValue); // Sets calories
			return true;
		} catch (Exception e) {
			return updateIngredient(allIngredients, ingredientIndex, updateValue);
		}
	}

	/**
	 * Manage recipes menu for users to manage recipes
	 */
	public static void manageRecipes() {
		String[] options = { "Add recipe", "Remove recipe", "Remove all recipes", "Display all recipes",
				"Display recipe details", "Search for a recipe", "Update a recipe", "Return to main menu" };
		Menu recipesMenu = new Menu("Manage Recipes", options);
		// Creates recipe menu with all options
		int choice = 0;
		recipesMenu.display(); // Displays recipe menu
		do {
			allRecipes = sortRecipes(allRecipes); // Sorts recipes into alphabetical order
			try {
				choice = recipesMenu.getChoice(); // Gets user choice for menu
				switch (choice) {
				case 1: // Add recipe
					if (addItem("Recipe")) { // Runs method to add an item which will run the method to add an
												// recipe
						System.out.println("Recipe added successfully! "); // Success message
					} else {
						System.out.println("Recipe not added "); // Failure message
					}
					recipesMenu.display(); // Redisplays recipes menu
					break;
				case 2: // Removes recipes
					if (allRecipes.size() > 0) { // Checks that recipe size is over 0
						int index = selectItem("Recipe", "Enter a valid recipe: ");
						// Prompts user to select an recipe to remove
						if (!checkCancel(index + 1)) { // Checks cancel
							if (removeItem("Recipe", index)) { // Removes item
								System.out.println("Recipe removed!"); // Confirmation message
							}
						}
					} else {
						System.out.println("No recipes to remove"); // Displays if allRecipes is empty
					}
					recipesMenu.display();
					break;
				case 3: // Removes all recipes
					if (allRecipes.size() > 0 && removeAllItems("Recipe")) {
						// Checks to make sure allRecipes had items and removes them after
						System.out.println("Recipes removed!"); // Confirmation message
					} else {
						System.out.println("No recipes to remove"); // Stated if there aren't recipes to remove
					}
					recipesMenu.display();
					break;
				case 4: // Display all recipes
					if (allRecipes.size() > 0) { // Checks size of allRecipes
						System.out.println(displayAllItems("Recipe")); // Displays all recipes
					} else {
						System.out.println("No recipes to display!"); // Displays if list is empty
					}
					recipesMenu.display();
					break;
				case 5: // Display recipe details
					if (allRecipes.size() > 0) { // Ensures list has items
						int index = selectItem("Recipe", "Enter a valid recipe: "); // Prompts for index of
																					// recipe to display
						if (!checkCancel(index + 1)) { // Checks cancel
							System.out.println(displayItemDetails("Recipe", index)); // Displays details of
																						// recipe
						}
					} else {
						System.out.println("No recipes to display!"); // Displays if list is empty
					}
					recipesMenu.display();
					break;
				case 6: // Search for an recipe
					if (allRecipes.size() > 0) {
						int searchBy = selectItem("Recipe Option", "Select what you want to search by: ");
						// Prompts for an option to search by
						if (!checkCancel(searchBy)) { // Checks cancel
							switch (searchBy) {
							case 0: // Search by id
								int search1 = selectInt("Enter recipe id: "); // Prompts for id
								if (!checkCancel(search1)) { // Checks cancel
									ArrayList<Recipe> results = searchForRecipe(allRecipes, search1);
									// Creates results array
									if (results.size() > 0) { // Makes sure it's over 0
										for (Recipe r : results) {
											System.out.println("\n" + r); // Prints each item in the results array
										}
									} else {
										System.out.println("No results meet the criteria"); // Empty results list result
									}
								}
								break;
							case 1: // Search by name
								String search2 = selectString("Enter recipe name: "); // Checks that there are items
								if (!checkCancel(search2)) {
									ArrayList<Recipe> results = searchForRecipe(allRecipes, search2);
									// Creates results array
									if (results.size() > 0) { // Makes sure it's over 0
										for (Recipe r : results) {
											System.out.println("\n" + r); // Prints each item in the results array
										}
									} else {
										System.out.println("No results meet the criteria"); // Empty results list result
									}
								}
								break;
							default:
								break;
							}
						} else {
							System.out.println("No recipes to display!"); // Displays if list is empty
						}
						recipesMenu.display();
					}
					break;
				case 7: // Update ingredient
					if (allRecipes.size() > 0 && updateRecipeChoice()) {
						// Ensures list has recipes and runs the update method
						System.out.println("Recipe updated!"); // Confirmation message
					} else {
						System.out.println("No recipes to update!"); // Empty list message
					}
					recipesMenu.display();
				default:
					break;
				}
			} catch (Exception e) { // Catches unexpected menu errors
				System.out.println("Unexpected error: " + e + "\nRestarting menu");
				recipesMenu.display();
			}
		} while (choice != options.length);

		System.out.println("Back to main menu: ");
	}

	/**
	 * Allows user to add recipe
	 * 
	 * @return - Returns true/false if recipe has been added or not
	 */
	public static boolean addRecipe() {
		try {
			String name = selectString("Recipe name: "); // Prompts user for recipe name
			if (checkCancel(name)) { // Checks cancel on recipe name
				return false;
			}
			int portions = 0;
			do {
				portions = selectInt("How many portions does it serve?"); // Prompts user to enter portions
				if (checkCancel(portions)) { // Checks cancel
					return false;
				}
			} while (portions < 1); // Ensures portion amount is positive
			ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
			ArrayList<Integer> ingredientQuantities = new ArrayList<Integer>();
			int askAgain = 2;
			do {
				int ingredient = selectItem("Ingredient", "Enter a valid ingredient: "); // Prompts user to add
																							// ingredient
				if (checkCancel(ingredient + 1)) { // Checks cancel on ingredient index
					return false;
				}

				int iQuantity = 0;
				do {
					iQuantity = selectInt("How much do you need? (grams): "); // Prompts user to enter amount of
																				// ingredient
					if (checkCancel(iQuantity + 1)) {
						return false;
					}
				} while (iQuantity < 1); // Ensures portion is positive
				recipeIngredients.add(allIngredients.get(ingredient)); // Adds ingredient to recipe ingredients list
				ingredientQuantities.add(iQuantity); // Adds recipe quantity
				askAgain = askAgain(); // User prompted to ask again
				if (checkCancel(askAgain)) { // Check cancel on askAgain
					return false;
				}
			} while (askAgain == 1); // Loops until user doesn't want to add another ingredient

			String method = setRecipeMethod(); // Sets recipe method

			if (method == null) { // Makes sure recipe isn't null
				return false;
			}
			Recipe recipe = new Recipe(name, method, portions, recipeIngredients, ingredientQuantities); // Creates new
																											// recipe
			allRecipes.add(recipe); // New recipe added
			return true;

		} catch (Exception e) { // Catches exception and returns add recipe method
			return addRecipe();
		}

	}

	/**
	 * Allows user to set the recipe method for adding or updating recipes
	 * 
	 * @return - Returns String of recipe
	 */
	public static String setRecipeMethod() {
		String method = "";
		String addText = "";
		for (int i = 0; !addText.equals("done"); i++) { // Iterates until user types 'done'
			addText = selectString("Enter step " + (i + 1)
					+ ". (type 'done' if finished with method and don't include the '|' character in your steps):");
			// Prompts user to enter method step
			if (checkCancel(addText)) { // Checks for cancelling the method
				return null;
			}
			if (addText.contains("|")) { // Ensures the step can't contain the splitting character
				i--; // Reduces the step count
			}
			if (addText.trim().isEmpty()) { // Doesn't allow empty steps
				i--; // Reduces step count
			}
			if (!addText.equals("done") && !addText.contains("|") && !addText.trim().isEmpty()) { // Ensures addText is
																									// added to the
																									// method
				method += addText + "|"; // Adds splitter character
			}
		}

		return method; // Returns method

	}

	/**
	 * Checks if user wants to add another ingredient to a recipe
	 * 
	 * @return - Returns integer value
	 */
	public static int askAgain() {
		int response = selectInt("\nDo you want to add another ingredient?\n1. Yes\n2. No");
		if (response == 1) {
			return 1;
		}
		if (response == 2) {
			return 2;
		}
		if (response == -1) {
			return -1;
		} else {
			return askAgain();
		}
	}

	/**
	 * Allows user access to update recipe details
	 * 
	 * @return - Returns true/false if recipe has been updated
	 */
	public static boolean updateRecipeChoice() {
		try {
			String allRecipesString = "All recipes are as follows: "; // Prints out all recipes
			for (int i = 0; i < allRecipes.size(); i++) {
				allRecipesString += "\n" + (i + 1) + ": " + allRecipes.get(i).getName();
			}

			int index = 0;
			do {
				index = selectInt(allRecipesString + "\nWhich recipe would you like to update?") - 1;
				if (checkCancel(index + 1)) {
					return false;
				}
			} while (index < 0 || index > allRecipes.size() - 1); // Ensures index is in range of all recipes
			int choice = 0;
			do {
				choice = selectInt(
						"\n1. Name\n2. Method\n3. Portions\n4. Ingredients\n5. Ingredient Quantity\n6. Add new ingredient\n7. Remove ingredient\n\nWhich recipe attribute do you want to update?: ");
				// Prompts user to select something to update
				if (checkCancel(choice)) { // Checks cancel on choice
					return false;
				}
				switch (choice) {
				case 1: // Name
					String newName = selectString("Enter a new name: "); // Prompts for new name
					if (checkCancel(newName)) { // Checks cancel
						return false;
					}
					updateRecipe(index, newName);
					break;
				case 2: // Method
					updateRecipe(index);
					break;
				case 3: // Portions
					int newPortions = 0;
					do {
						newPortions = selectInt("Enter a new amount of portions (> 0): "); // Prompts for portions
						if (checkCancel(newPortions)) { // Checks cancel
							return false;
						}
					} while (newPortions < 1); // Ensures it's over 0
					updateRecipe(index, newPortions);
					break;
				case 4: // Ingredient
					updateRecipeIngredient(index);
					break;
				case 5: // Ingredient Quantity
					updateRecipeIngredientQuantity(index);
					break;
				case 6: // Add new ingredient
					addRecipeIngredient(index);
					break;
				case 7: // Remove ingredient
					removeRecipeIngredient(index);
					break;
				default:
					break;
				}
			} while (choice < 1 || choice > 7);

			return true;
		} catch (Exception e) {
			return updateRecipeChoice();
		}
	}

	/**
	 * Updates recipe name
	 * 
	 * @param recipeIndex - Recipe index to update
	 * @param updateValue - Value for name from user
	 * @return - true/false if recipe updates
	 */
	public static boolean updateRecipe(int recipeIndex, String updateValue) {
		try {
			if (updateValue == null || updateValue.isEmpty()) { // Checks value
				return false;
			}
			allRecipes.get(recipeIndex).setName(updateValue); // Updates
			return true;
		} catch (Exception e) { // Catches exceptions
			return false;
		}
	}

	/**
	 * Updates recipe method
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @return - true/false if recipe updates
	 */
	public static boolean updateRecipe(int recipeIndex) {
		try {
			allRecipes.get(recipeIndex).setMethod(setRecipeMethod()); // Sets recipe method with setRecipeMethod()
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Updates recipe portions
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @param updateValue - Amount of portions entered by users
	 * @return - true/false if recipe updates
	 */
	public static boolean updateRecipe(int recipeIndex, int updateValue) {
		try {
			if (updateValue < 1) { // Ensures amount of portions is over 0
				return false;
			}
			allRecipes.get(recipeIndex).setHowManyPortions(updateValue); // Sets the amount of portions
			return true;
		} catch (Exception e) { // Catches exception
			return false;
		}
	}

	/**
	 * Updates the ingredient in a recipe
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @return - true/false if recipe updates
	 */
	public static boolean updateRecipeIngredient(int recipeIndex) {
		try {
			if (updateIngredientChoice(allRecipes.get(recipeIndex).getIngredients())) { // Runs ingredient update method
																						// for recipe ingredients list
				return true;
			} else {
				return false;
			}
		} catch (Exception e) { // Catches exception
			return false;
		}
	}

	/**
	 * Updates a recipe ingredient quantity
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @return - true/false if recipe updates
	 */
	public static boolean updateRecipeIngredientQuantity(int recipeIndex) {
		try {
			String allIngredients = "All ingredients are as follows: "; // Initial statement
			for (int i = 0; i < allRecipes.get(recipeIndex).getIngredients().size(); i++) {
				// Iterates through each ingredient in a recipe and adds its name with its
				// quantity
				allIngredients += "\n" + (i + 1) + ".\n" + allRecipes.get(recipeIndex).getIngredients().get(i) + " --> "
						+ allRecipes.get(recipeIndex).getIngredientQuantities().get(i) + "g\n";
			}
			int index = 0;
			do {
				index = selectInt(allIngredients + "\nWhich ingredient would you like to update?") - 1;
				// Selects the ingredient index
				if (checkCancel(index + 1)) { // Checks cancel
					return false;
				}
			} while (index < 0 || index > allRecipes.get(recipeIndex).getIngredients().size()); // Ensures index is
																								// valid
			int amount = 0;
			do {
				amount = selectInt("Enter new amount: "); // Gets new amount for ingredient
				if (checkCancel(amount)) { // Checks cancel
					return false;
				}
			} while (amount < 1); // Ensures amount is more than 0
			allRecipes.get(recipeIndex).getIngredientQuantities().add(index, amount); // Adds new amount to be in line
																						// with ingredient
			allRecipes.get(recipeIndex).getIngredientQuantities().remove(index + 1); // Removes previous ingredient
																						// amount
			return true; // Returns true

		} catch (Exception e) {
			return updateRecipeIngredientQuantity(recipeIndex);
		}

	}

	/**
	 * Allows user to add an ingredient to an already existing recipe
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @return - true/false if recipe updates
	 */
	public static boolean addRecipeIngredient(int recipeIndex) {
		try {
			int index = selectItem("Ingredient", "Select an ingredient to add: "); // Sets index to add ingredient
			if (checkCancel(index + 1)) { // Checks cancel
				return false;
			}
			int amount = 0;
			do {
				amount = selectInt("Enter amount of ingredient required: "); // Sets value for amount
				if (checkCancel(amount)) {
					return false;
				}
			} while (amount < 1); // Ensures amount isn't negative

			allRecipes.get(recipeIndex).getIngredients().add(allIngredients.get(index)); // Adds ingredient
			allRecipes.get(recipeIndex).getIngredientQuantities().add(amount); // Adds amount to relative position

			return true;
		} catch (Exception e) {
			return addRecipeIngredient(recipeIndex);
		}
	}

	/**
	 * Allows user to remove an ingredient from an already existing recipe
	 * 
	 * @param recipeIndex - Index of recipe to update
	 * @return - true/false if recipe updates
	 */
	public static boolean removeRecipeIngredient(int recipeIndex) {
		try {
			String allIngredients = "All ingredients are as follows: ";
			for (int i = 0; i < allRecipes.get(recipeIndex).getIngredients().size(); i++) {
				// Iterates through each ingredient in a recipe and adds its name with its
				// quantity
				allIngredients += "\n" + (i + 1) + ".\n" + allRecipes.get(recipeIndex).getIngredients().get(i) + " --> "
						+ allRecipes.get(recipeIndex).getIngredientQuantities().get(i) + "g\n";
			}
			int index = selectInt(allIngredients + "Select an ingredient to remove: ") - 1;
			if (checkCancel(index + 1)) { // Selects ingredient to remove and checks cancel
				return false;
			}

			allRecipes.get(recipeIndex).getIngredients().remove(index); // Removes ingredient
			allRecipes.get(recipeIndex).getIngredientQuantities().remove(index); // Removes relative amount

			return true;
		} catch (Exception e) {
			return removeRecipeIngredient(recipeIndex);
		}
	}

	/**
	 * Allows user to manage daily menus
	 */
	public static void manageWeeklyMenu() {
		String[] options = { "Add daily menu", "Remove daily menu", "Remove all daily menus", "Display all daily menus",
				"Display daily menu details", "Update a daily menu", "Return to main menu" };
		Menu weeklyMenu = new Menu("Manage Weekly Menu", options); // Creates weekly menu
		int choice = 0;
		weeklyMenu.display(); // Displays menu
		do {
			try {
				setAvailableDays(); // Sets available days
				allDailyMenus = sortDailyMenus(allDailyMenus); // Sorts menus into daily order
				availableDays = sortAvailableDays(availableDays); // Sorts available days into daily order
				choice = weeklyMenu.getChoice(); // Runs method to take in the user's choice and process it
				switch (choice) {
				case 1: // Add daily menu
					if (allDailyMenus.size() < 5) {
						if (addItem("Daily Menu")) { // Runs method to add an item which will run the method to add an
														// daily menu
							System.out.println("Daily Menu added successfully! "); // Success message
						} else {
							System.out.println("Daily Menu not added "); // Failure message
						}
					} else {
						System.out.println("No room for any more daily menus");
					}
					weeklyMenu.display(); // Redisplays weekly menu
					break;
				case 2: // Removes daily menus
					if (allDailyMenus.size() > 0) { // Checks that daily menu size is over 0
						int index = selectItem("Daily Menu", "Enter a valid recipe: ");
						// Prompts user to select a daily menu to remove
						if (!checkCancel(index + 1)) { // Checks cancel
							if (removeItem("Daily Menu", index)) { // Removes item
								System.out.println("Daily Menu removed!"); // Confirmation message
							}
						}
					} else {
						System.out.println("No daily menus to remove"); // Displays if allDailyMenus is empty
					}
					weeklyMenu.display();
					break;
				case 3: // Removes all daily menus
					if (allDailyMenus.size() > 0 && removeAllItems("Daily Menu")) {
						// Checks to make sure allDailyMenus had items and removes them after
						System.out.println("Daily menus removed!"); // Confirmation message
					} else {
						System.out.println("No daily menus to remove"); // Stated if there aren't daily menus to remove
					}
					weeklyMenu.display();
					break;
				case 4: // Display all daily menus
					if (allDailyMenus.size() > 0) { // Checks size of allDailyMenus
						System.out.println(displayAllItems("Daily Menu")); // Displays all daily menus
					} else {
						System.out.println("No daily menus to display!"); // Displays if list is empty
					}
					weeklyMenu.display();
					break;
				case 5: // Display daily menu details
					if (allDailyMenus.size() > 0) { // Ensures list has items
						int index = selectItem("Daily Menu", "Enter a valid Daily Menu: "); // Prompts for index of
						// daily menu to display
						if (!checkCancel(index + 1)) { // Checks cancel
							System.out.println(displayItemDetails("Daily Menu", index)); // Displays details of
																							// daily menu
						}
					} else {
						System.out.println("No daily menus to display!"); // Displays if list is empty
					}
					weeklyMenu.display();
					break;
				case 6:
					if (allDailyMenus.size() > 0 && updateDailyMenuChoice()) { // Ensures daily menu sizes are over 0
																				// and
																				// update method returns true
						System.out.println("Daily menu updated!");
					} else {
						System.out.println("No daily menus to update!");
					}
					weeklyMenu.display();
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e + "\nRestarting menu");
				weeklyMenu.display();
			}

		} while (choice != options.length); // Returns to main menu after methods are run

		System.out.println("Back to main menu: ");

	}

	/**
	 * Adds daily menu
	 * 
	 * @return - true/false if daily menu is added
	 */
	public static boolean addDailyMenu() {
		try {
			int dayOfTheWeekIndex = selectItem("Available Day", "Enter the desired day of the week: "); // Asks for day
																										// of the week
			if (checkCancel(dayOfTheWeekIndex + 1)) { // Checks cancel
				return false;
			}
			// Asks for day of the week index
			String dayOfTheWeek = availableDays.get(dayOfTheWeekIndex); // Selects day of the week
			availableDays.remove(dayOfTheWeekIndex); // Removes day of the week that's been used
			Recipe[] dailyMenuRecipes = new Recipe[3]; // Creates recipe array

			for (int i = 0; i < dailyMenuRecipes.length; i++) { // Adds recipes to daily menu
				int index = selectItem("Recipe", "Enter recipe " + (i + 1)); // Asks for index
				if (checkCancel(index)) { // Checks cancel
					return false;
				}
				dailyMenuRecipes[i] = allRecipes.get(index); // Adds index
			}
			DailyMenu dailyMenu = new DailyMenu(dayOfTheWeek, dailyMenuRecipes);
			allDailyMenus.add(dailyMenu); // Adds daily menu to array list
			return true;
		} catch (Exception e) { // Catches exceptions
			return addDailyMenu();
		}
	}

	/**
	 * Sets the available days by comparing them with the currently used ones in a
	 * Daily Menu
	 */
	public static void setAvailableDays() {
		for (DailyMenu d : allDailyMenus) { // Iterates through each daily menu
			for (int i = 0; i < availableDays.size(); i++) { // Iterates through each available day and compares it with
																// the current daily menu
				if (d.getDayOfTheWeek().equals(availableDays.get(i))) {
					// If the days are equal it will remove that daily menu's day from the available
					// days list
					availableDays.remove(availableDays.get(i));
					i--; // Reduces i in line with the size of the available days list
				}
			}
		}
	}

	/**
	 * Allows user to update daily menus
	 * 
	 * @return - true/false if daily menu got updated
	 */
	public static boolean updateDailyMenuChoice() {
		setAvailableDays(); // Sets available days
		String allDailyMenusString = "All recipes are as follows: "; // Prints all daily menus
		for (int i = 0; i < allDailyMenus.size(); i++) {
			allDailyMenusString += "\n" + (i + 1) + ": " + allDailyMenus.get(i).getDayOfTheWeek();
		}

		int index = 0;
		do {
			index = selectInt(allDailyMenusString + "\nWhich daily menu would you like to update?") - 1;
			if (checkCancel(index + 1)) {
				return false;
			}
		} while (index < 0 || index > allDailyMenus.size() - 1); // Ensures index is valid
		int choice = 0;
		do {
			choice = selectInt(
					"\n1. Day of the Week\n2. Recipe List\n\nWhich daily menu attribute do you want to update?: ");
			// Prompts for choice to update
			if (checkCancel(choice)) { // Checks cancel
				return false;
			}
			switch (choice) {
			case 1: // Day of the week
				int newDayIndex = selectItem("Available Day", "Select a new day of the week"); // Select available day
																								// index
				if (checkCancel(newDayIndex + 1)) { // Checks cancel
					return false;
				}
				updateDailyMenu(index, newDayIndex);
				break;
			case 2: // Recipe list
				Recipe[] newRecipes = new Recipe[3];
				for (int i = 0; i < newRecipes.length; i++) {
					int newRecipe = selectItem("Recipe", "Select a new valid recipe");
					if (checkCancel(newRecipe + 1)) { // Checks cancel
						return false;
					}
					newRecipes[i] = allRecipes.get(newRecipe); // Adds recipes
				}
				updateDailyMenu(index, newRecipes);
				break;
			default:
				break;
			}
		} while (choice < 1 || choice > 2); // Ensures choice is limmited to current options

		return true;
	}

	/**
	 * Allows user to update the day of the week of a daily menu
	 * 
	 * @param dailyMenuIndex - Daily menu index
	 * @param updateValue    - new day of the week index
	 * @return - true/false if daily menu has been updated
	 */
	public static boolean updateDailyMenu(int dailyMenuIndex, int updateValue) {
		try {
			allDailyMenus.get(dailyMenuIndex).setDayOfTheWeek(availableDays.get(updateValue)); // Sets the new day of
																								// the week value
			setAvailableDays(); // Fixes the available days
			availableDays = sortAvailableDays(availableDays);
			return true;
		} catch (Exception e) { // Catches exception
			return false;
		}
	}

	/**
	 * Allows user to update the daily menu's list of recipes
	 * 
	 * @param dailyMenuIndex - Daily menu index
	 * @param newRecipeList  - new recipe list for daily menu
	 * @return - true/false if daily menu is updated
	 */
	public static boolean updateDailyMenu(int dailyMenuIndex, Recipe[] newRecipeList) {
		try {
			allDailyMenus.get(dailyMenuIndex).setRecipes(newRecipeList); // Sets the recipes with a new array of them
			return true;
		} catch (Exception e) { // Catches exception
			return false;
		}
	}

	/**
	 * Allows ingredients to get insertion sorted into alphabetical order
	 * 
	 * @param source - source array list for ingredients
	 * @return - sorted ingredient array list
	 */
	public static ArrayList<Ingredient> sortIngredients(ArrayList<Ingredient> source) {
		if (source.size() > 0) { // Ensures source has more than one item
			ArrayList<Ingredient> newArray = new ArrayList<Ingredient>(); // Creates new subset array
			newArray.add(source.get(0)); // Adds initial item for comparison
			for (int i = 1; i < source.size(); i++) { // Iterates through each source item
				String name1 = source.get(i).getName().toLowerCase(); // Saves the current source item's name
				for (int x = newArray.size() - 1; x >= 0; x--) { // Iterates through each item of the subset
					String name2 = newArray.get(x).getName().toLowerCase(); // Sets second name as the current subset
																			// item's name
					if (name1.compareTo(name2) >= 0) { // Compares the names ->
						// if they are equal or the source item follows the current subset item, it is
						// added after
						newArray.add(x + 1, source.get(i)); //
						break;
					}
				}
				if (name1.compareTo(newArray.get(0).getName().toLowerCase()) < 0) { // compares the current source
																					// item's name to the
					// lowest value
					newArray.add(0, source.get(i)); // Source item becomes new first item of the subset
				}
			}

			return newArray; // Returns the subset
		}
		return source; // Returns source if the list is empty
	}

	/**
	 * Allows recipes to get insertion sorted into alphabetical order, each step is
	 * identical to sortIngredients()
	 * 
	 * @param source - source array list for recipe
	 * @return - sorted recipe array list
	 */
	public static ArrayList<Recipe> sortRecipes(ArrayList<Recipe> source) {
		if (source.size() > 0) {
			ArrayList<Recipe> newArray = new ArrayList<Recipe>();
			newArray.add(source.get(0)); // Adds initial item for comparison
			for (int i = 1; i < source.size(); i++) { // Iterates through each source item
				String name1 = source.get(i).getName().toLowerCase(); // Saves the current source item's name
				for (int x = newArray.size() - 1; x >= 0; x--) { // Iterates through each item of the subset
					String name2 = newArray.get(x).getName().toLowerCase(); // Sets second name as the current subset
																			// item's name
					if (name1.compareTo(name2) >= 0) { // Compares the names ->
						// if they are equal or the source item follows the current subset item, it is
						// added after
						newArray.add(x + 1, source.get(i)); //
						break;
					}
				}
				if (name1.compareTo(newArray.get(0).getName().toLowerCase()) < 0) { // compares the current source
																					// item's name to the
					// lowest value
					newArray.add(0, source.get(i)); // Source item becomes new first item of the subset
				}
			}

			return newArray; // Returns the subset
		}
		return source; // Returns source if the list is empty
	}

	/**
	 * Sorts daily menus into daily order
	 * 
	 * @param source - source array list for daily menus
	 * @return - sorted daily menu list array list
	 */
	public static ArrayList<DailyMenu> sortDailyMenus(ArrayList<DailyMenu> source) {
		if (source.size() > 0) { // Ensures the source isn't empty
			ArrayList<DailyMenu> newArray = new ArrayList<DailyMenu>(); // Creates new subset
			DailyMenu[] orderedList = new DailyMenu[5]; // Creates new ordered list
			for (DailyMenu d : source) {
				// Checks each daily menu and adds it to the correct position in the array
				// depending on its day of the week
				switch (d.getDayOfTheWeek()) {
				case "Monday":
					orderedList[0] = d;
					break;
				case "Tuesday":
					orderedList[1] = d;
					break;
				case "Wednesday":
					orderedList[2] = d;
					break;
				case "Thursday":
					orderedList[3] = d;
					break;
				case "Friday":
					orderedList[4] = d;
					break;
				default:
					break;
				}
			}
			for (DailyMenu d : orderedList) {
				if (d != null) {
					newArray.add(d); // Adds each daily menu to the list, provided it isn't a null value
				}
			}

			return newArray;
		}
		return source;
	}

	/**
	 * Sorts the available days into weekly order, it works the same as
	 * sortDailyMenus
	 * 
	 * @param source - available days
	 * @return - sorted available days into daily order
	 */
	public static ArrayList<String> sortAvailableDays(ArrayList<String> source) {
		if (source.size() > 0) {
			ArrayList<String> newArray = new ArrayList<String>();
			String[] orderedList = new String[5];
			for (String d : source) { // Ensures daily menus are placed in correct place
				switch (d) {
				case "Monday":
					orderedList[0] = d;
					break;
				case "Tuesday":
					orderedList[1] = d;
					break;
				case "Wednesday":
					orderedList[2] = d;
					break;
				case "Thursday":
					orderedList[3] = d;
					break;
				case "Friday":
					orderedList[4] = d;
					break;
				default:
					break;
				}
			}
			for (String d : orderedList) { // Adds daily menus to list to ensure they are in daily order
				if (d != null) { // Ensures they aren't null
					newArray.add(d);
				}
			}

			return newArray;

		}

		return source;
	}

	/**
	 * Allows user to search for an ingredient by its name
	 * 
	 * @param source - ingredient array list to search through
	 * @param name   - name of ingredient to search for
	 * @return - array list of result items
	 */
	public static ArrayList<Ingredient> searchForIngredient(ArrayList<Ingredient> source, String name) {
		ArrayList<Ingredient> resultList = new ArrayList<Ingredient>(); // Creates a list to add ingredients with
																		// correct name/part name to
		for (Ingredient i : source) {
			if (i.getName().toLowerCase().contains(name.toLowerCase())) {
				// If an ingredient shares a name or part name with the target name, it will be
				// added to the list
				resultList.add(i);
			}
		}
		return resultList; // Returns list
	}

	/**
	 * ALlows user to search for an ingredient by its id
	 * 
	 * @param source - ingredient array list to search through
	 * @param id     - id of ingredient to search for
	 * @return - array list of result items
	 */
	public static ArrayList<Ingredient> searchForIngredient(ArrayList<Ingredient> source, int id) {
		ArrayList<Ingredient> resultList = new ArrayList<Ingredient>();
		for (Ingredient i : source) {
			if (i.getId() == id) { // Compares the id with the target one
				resultList.add(i);
			}
		}
		return resultList; // Returns list
	}

	/**
	 * Allows the user to search for an ingredient by its food type
	 * 
	 * @param source   - ingredient array list to search through
	 * @param foodType - food type of ingredient to search for
	 * @return - array list of result items
	 */
	public static ArrayList<Ingredient> searchForIngredient(ArrayList<Ingredient> source, FoodType foodType) {
		ArrayList<Ingredient> resultList = new ArrayList<Ingredient>();
		for (Ingredient i : source) {
			if (i.getFoodType() == foodType) { // Compares the type with the target one
				resultList.add(i);
			}
		}
		return resultList; // Returns list
	}

	/**
	 * Allows the user to search for a recipe by its name
	 * 
	 * @param source - recipe array list to search through
	 * @param name   - recipe name to search for
	 * @return - array list of result items
	 */
	public static ArrayList<Recipe> searchForRecipe(ArrayList<Recipe> source, String name) {
		ArrayList<Recipe> resultList = new ArrayList<Recipe>();
		for (Recipe r : source) {
			if (r.getName().toLowerCase().contains(name.toLowerCase())) { // Compares the name with the target one
				resultList.add(r);
			}
		}
		return resultList; // Returns list
	}

	/**
	 * Allows the user to search for a recipe by its id
	 * 
	 * @param source - recipe array list to search through
	 * @param id     - recipe id to search for
	 * @return - array list of result items
	 */
	public static ArrayList<Recipe> searchForRecipe(ArrayList<Recipe> source, int id) {
		ArrayList<Recipe> resultList = new ArrayList<Recipe>();
		for (Recipe r : source) {
			if (r.getId() == id) { // Compares the id with the target one
				resultList.add(r);
			}
		}
		return resultList; // Returns list
	}
}