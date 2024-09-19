package part02;

import part01.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test Cases for application
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 */
public class TestCases {

	static ArrayList<Ingredient> allIngredients = Resources.addIngredients();
	static ArrayList<Recipe> allRecipes = Resources.addRecipes();
	static ArrayList<DailyMenu> allDailyMenus = Resources.addDailyMenus();
	static ArrayList<String> availableDays = new ArrayList<String>(
			Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
	static String[] ingredientOptions = { "Id", "Name", "Food Group" };
	static String[] recipeOptions = { "Id", "Name" };

	public static void main(String[] args) {
		testCase47d();
	}

	// INDIVIDUAL METHOD TESTING

	public static void testCase1a() {
		System.out.println("*****************\nTest case 1a: ");
		String example = QUBKitchen.selectString("Enter an example string: ");
		System.out.println(example);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase1b() {
		System.out.println(
				"*****************\nTest case 1b: Returns string from a prompt which is frequently reused through the code");
		String example = QUBKitchen.selectString("Enter an example string: ");
		System.out.println(example);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase2a() {
		System.out.println(
				"*****************\nTest case 2a: Tests for return int method that is frequently reused through the code ");
		int example = QUBKitchen.selectInt("Enter an example int: ");
		System.out.println(example);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase2b() {
		System.out.println(
				"*****************\nTest case 2b: Testing a return int method that is resued frequently through code ");
		int example = QUBKitchen.selectInt("Enter an example int: ");
		System.out.println(example);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3f() {
		System.out.println("*****************\nTest case 3f: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Food Type"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3a() {
		System.out.println("*****************\nTest case 3a: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Available Day"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3e() {
		System.out.println("*****************\nTest case 3e: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems(""));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3ia() {
		System.out.println("*****************\nTest case 3ia: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Ingredient"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3ib() {
		System.out.println("*****************\nTest case 3ib: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Ingredient Option"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3ra() {
		System.out.println("*****************\nTest case 3ra: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Recipe"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3rb() {
		System.out.println("*****************\nTest case 3rb: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Recipe Option"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase3d() {
		System.out.println("*****************\nTest case 3d: Each list can display their items properly");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu"));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase4a() {
		System.out
				.println("*****************\nTest case 4a: Check cancel method works properly with string parameters ");
		String input = "hello";
		System.out.println("Input: " + input);
		boolean cancel = QUBKitchen.checkCancel(input);
		System.out.println(cancel);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase4b() {
		System.out
				.println("*****************\nTest case 4b: Check cancel method works properly with string parameters ");
		String input = "cancel";
		System.out.println("Input: " + input);
		boolean cancel = QUBKitchen.checkCancel(input);
		System.out.println(cancel);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase5a() {
		System.out.println("*****************\nTest case 5a: Check cancel method works properly with int parameters ");
		int input = 123;
		System.out.println("Input: " + input);
		boolean cancel = QUBKitchen.checkCancel(input);
		System.out.println(cancel);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase5b() {
		System.out.println("*****************\nTest case 5b: Check cancel method works properly with int parameters ");
		int input = -1;
		System.out.println("Input: " + input);
		boolean cancel = QUBKitchen.checkCancel(input);
		System.out.println(cancel);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase6a() {
		System.out.println("*****************\nTest case 6a: Select item method works and returns valid indexes ");
		int index = QUBKitchen.selectItem("Available Day", "Enter desired item");
		System.out.println(index + " --> Should be one less than user input");
		System.out.println("End of test case\n*****************");

	}

	public static void testCase6b() {
		System.out.println("*****************\nTest case 6b: Select item method works and returns valid indexes ");
		QUBKitchen.allIngredients.clear();
		int index = QUBKitchen.selectItem("Ingredient", "Enter desired item");
		System.out.println(index);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase7i() {
		System.out.println("*****************\nTest case 7i: Access method for adding new items ");
		QUBKitchen.addItem("Ingredient");
		System.out.println("End of test case\n*****************");
	}

	public static void testCase7r() {
		System.out.println("*****************\nTest case 7r: Access method for adding new items ");
		QUBKitchen.addItem("Recipe");
		System.out.println("End of test case\n*****************");
	}

	public static void testCase7d() {
		System.out.println("*****************\nTest case 7d: Access method for adding new items ");
		QUBKitchen.addItem("Daily Menu");
		System.out.println("End of test case\n*****************");
	}

	public static void testCase8i() {
		System.out.println("*****************\nTest case 8i: Remove items from lists with a cascade delete ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		QUBKitchen.removeItem("Ingredient", 1);

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		System.out.println("End of test case\n*****************");
	}

	public static void testCase8r() {
		System.out.println("*****************\nTest case 8r: Remove items from lists with a cascade delete ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		QUBKitchen.removeItem("Recipe", 1);

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		System.out.println("End of test case\n*****************");
	}

	public static void testCase8d() {
		System.out.println("*****************\nTest case 8d: Remove items from lists with a cascade delete ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		QUBKitchen.removeItem("Daily Menu", 1);

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		System.out.println("End of test case\n*****************");
	}

	public static void testCase9i() {

		System.out.println("*****************\nTest case 9i: Removes all items from lists ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		boolean removed = QUBKitchen.removeAllItems("Ingredient");

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");
		System.out.println(removed);

		System.out.println("End of test case\n*****************");

	}

	public static void testCase9r() {

		System.out.println("*****************\nTest case 9r: Removes all items from lists ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		boolean removed = QUBKitchen.removeAllItems("Recipe");

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe") + "\n************************");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");
		System.out.println(removed);

		System.out.println("End of test case\n*****************");

	}

	public static void testCase9d() {

		System.out.println("*****************\nTest case 9d: Removes all items from lists ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");

		boolean removed = QUBKitchen.removeAllItems("Daily Menu");

		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu") + "\n************************");
		System.out.println(removed);

		System.out.println("End of test case\n*****************");

	}

	public static void testCase10ia() {
		System.out.println("*****************\nTest case 10ia: Displays details of a specified item ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase10ib() {
		System.out.println("*****************\nTest case 10ib: Displays details of a specified item ");
		QUBKitchen.removeAllItems("Ingredient");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase10ra() {
		System.out.println("*****************\nTest case 10ra: Displays details of a specified item ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase10rb() {
		System.out.println("*****************\nTest case 10rb: Displays details of a specified item ");
		QUBKitchen.removeAllItems("Recipe");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase10da() {
		System.out.println("*****************\nTest case 10da: Displays details of a specified item ");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase10db() {
		System.out.println("*****************\nTest case 10db: Displays details of a specified item ");
		QUBKitchen.removeAllItems("Daily Menu");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 2));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase11i() {
		System.out.println("*****************\nTest case 11i: Update an ingredient's name");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		QUBKitchen.updateIngredient(QUBKitchen.allIngredients, 0, 1, "Apple");
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase12i() {
		System.out.println("*****************\nTest case 12i: Update an ingredient's extra details");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		QUBKitchen.updateIngredient(QUBKitchen.allIngredients, 0, 2, "Yellow Bell");
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase13i() {
		System.out.println("*****************\nTest case 13i: Update an ingredient's Food Type ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		QUBKitchen.updateIngredient(QUBKitchen.allIngredients, 0, FoodType.COMP);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase14i() {
		System.out.println("*****************\nTest case 14i: Update an ingredient's calories per 100g ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		QUBKitchen.updateIngredient(QUBKitchen.allIngredients, 0, 72);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase15r() {
		System.out.println("*****************\nTest case 15r: Set a recipe's method");
		String method = "";
		System.out.println("Method before: " + method);
		method = QUBKitchen.setRecipeMethod();
		System.out.println("Method after: " + method);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase16r() {
		System.out.println("*****************\nTest case 16r: Update a recipe's name");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipe(0, "New name");
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase17r() {
		System.out.println("*****************\nTest case 17r: Update a recipe's method");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipe(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase18r() {
		System.out.println("*****************\nTest case 18: Update a recipe's number of portions");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipe(0, 30);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase19r() {
		System.out.println("*****************\nTest case 19: Update a recipe's ingredient");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipeIngredient(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase20ra() {
		System.out.println("*****************\nTest case 20ra: Update a recipe's ingredient's quantity");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipeIngredientQuantity(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase20rb() {
		System.out.println("*****************\nTest case 20rb: Update a recipe's ingredient's quantity");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipeIngredientQuantity(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase20rc() {
		System.out.println("*****************\nTest case 20rc: Update a recipe's ingredient's quantity");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.updateRecipeIngredientQuantity(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase21ra() {
		System.out.println("*****************\nTest case 21ra: Add an ingredient to a recipe");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.addRecipeIngredient(21);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase21rb() {
		System.out.println("*****************\nTest case 21rb: Add an ingredient to an existing recipe");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.addRecipeIngredient(21);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase22r() {
		System.out.println("*****************\nTest case 22r: Remove an ingredient from an existing recipe ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		QUBKitchen.removeRecipeIngredient(0);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Recipe", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase23a() {
		System.out.println("*****************\nTest case 23a: Set the available days for daily menu creation ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.availableDays);
		QUBKitchen.setAvailableDays();
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.availableDays);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase24d() {
		System.out.println("*****************\nTest case 24d: Update daily menu day of the week ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 0));
		QUBKitchen.updateDailyMenu(0, 1);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase25d() {
		Recipe[] newRecipes = { QUBKitchen.allRecipes.get(5), QUBKitchen.allRecipes.get(9),
				QUBKitchen.allRecipes.get(8) };
		System.out.println("*****************\nTest case 25d: Update a daily menu's recipes array");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 0));
		QUBKitchen.updateDailyMenu(0, newRecipes);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayItemDetails("Daily Menu", 0));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase26i() {
		System.out.println("*****************\nTest case 26i: Sort ingredients ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient"));
		QUBKitchen.allIngredients = QUBKitchen.sortIngredients(QUBKitchen.allIngredients);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Ingredient"));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase27r() {
		System.out.println("*****************\nTest case 27r: Sort recipes ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe"));
		QUBKitchen.allRecipes = QUBKitchen.sortRecipes(QUBKitchen.allRecipes);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Recipe"));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase28d() {
		System.out.println("*****************\nTest case 28d: Sort daily menus ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu"));
		QUBKitchen.allDailyMenus = QUBKitchen.sortDailyMenus(QUBKitchen.allDailyMenus);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Daily Menu"));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase29a() {
		System.out.println("*****************\nTest case 29a: Sort available days ");
		System.out.println("Data before: ");
		System.out.println(QUBKitchen.displayAllItems("Available Day"));
		QUBKitchen.availableDays = QUBKitchen.sortAvailableDays(QUBKitchen.availableDays);
		System.out.println("Data after: ");
		System.out.println(QUBKitchen.displayAllItems("Available Day"));
		System.out.println("End of test case\n*****************");

	}

	public static void testCase30i() {
		ArrayList<Ingredient> ingredientsFound = new ArrayList<>();
		System.out.println("*****************\nTest case 30i: Search for ingredients by name or part name ");
		System.out.println("Data before: ");
		System.out.println(ingredientsFound);
		ingredientsFound = QUBKitchen.searchForIngredient(QUBKitchen.allIngredients, "tom");
		System.out.println("Data after: ");
		System.out.println(ingredientsFound);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase31i() {
		ArrayList<Ingredient> ingredientsFound = new ArrayList<>();
		System.out.println("*****************\nTest case 31i: Search for ingredients by id");
		System.out.println("Data before: ");
		System.out.println(ingredientsFound);
		ingredientsFound = QUBKitchen.searchForIngredient(QUBKitchen.allIngredients, 36);
		System.out.println("Data after: ");
		System.out.println(ingredientsFound);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase32i() {
		ArrayList<Ingredient> ingredientsFound = new ArrayList<>();
		System.out.println("*****************\nTest case 32i: Search for ingredients by food type");
		System.out.println("Data before: ");
		System.out.println(ingredientsFound);
		ingredientsFound = QUBKitchen.searchForIngredient(QUBKitchen.allIngredients, FoodType.FANDV);
		System.out.println("Data after: ");
		System.out.println(ingredientsFound);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase33r() {
		ArrayList<Recipe> recipesFound = new ArrayList<>();
		System.out.println("*****************\nTest case 33r: Search for recipes by name or part name");
		System.out.println("Data before: ");
		System.out.println(recipesFound);
		recipesFound = QUBKitchen.searchForRecipe(QUBKitchen.allRecipes, "bean");
		System.out.println("Data after: ");
		System.out.println(recipesFound);
		System.out.println("End of test case\n*****************");

	}

	public static void testCase34r() {
		ArrayList<Recipe> recipesFound = new ArrayList<>();
		System.out.println("*****************\nTest case 34r: Search for recipes by id ");
		System.out.println("Data before: ");
		System.out.println(recipesFound);
		recipesFound = QUBKitchen.searchForRecipe(QUBKitchen.allRecipes, 1);
		System.out.println("Data after: ");
		System.out.println(recipesFound);
		System.out.println("End of test case\n*****************");

	}

	// MENU TESTING, where most error handling is dealt with

	public static void testCase35() {
		System.out.println(
				"*****************\nTest case 35: Testing the main method for each main menu option with different types of data to ensure it works and is error handled ");
		QUBKitchen.main(null);
		System.out.println("End of test case\n*****************");
		;
	}

	public static void testCase36() {
		System.out.println(
				"*****************\nTest case 36: Testing the manageIngredients method for each ingredients menu option with different types of data to ensure it works and is error handled for each method ");
		QUBKitchen.manageIngredients();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase37() {
		System.out.println(
				"*****************\nTest case 37: Testing the addIngredients method with different types of data to ensure it works and is error handled for adding new ingredients");
		QUBKitchen.addIngredient();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase38() {
		System.out.println(
				"*****************\nTest case 37: Testing the updateIngredientChoice method with different types of data to ensure it works and is error handled for updating ingredients and managing them");
		System.out.println("Data before:");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 1));
		QUBKitchen.updateIngredientChoice(QUBKitchen.allIngredients);
		System.out.println("Data after:");
		System.out.println(QUBKitchen.displayItemDetails("Ingredient", 1));
		System.out.println("End of test case\n*****************");
	}

	public static void testCase39() {
		System.out.println(
				"*****************\nTest case 39: Testing the manageRecipes method for each option with differnt types of data to ensure it works and is error handled for managing recipes");
		QUBKitchen.manageRecipes();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase40() {
		System.out.println(
				"*****************\nTest case 40: Testing the addRecipe method for different types of data to ensure it works and is error handled for adding new recipes");
		QUBKitchen.addRecipe();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase41() {
		System.out.println(
				"*****************\nTest case 41: Testing the updateRecipeChoice method for different types of data to ensure it works and is error handled for updating and managing recipes");
		QUBKitchen.updateRecipeChoice();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase42() {
		System.out.println(
				"*****************\nTest case 42: Testing the manageWeeklyMenu method for different types of data to ensure it works and is error handled for managing daily menus");
		QUBKitchen.manageWeeklyMenu();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase43() {
		System.out.println(
				"*****************\nTest case 43: Testing the addDailyMenu method for different types of data to ensure it works and is error handled for adding new menus, especially for ensuring the available days stays up to date too");
		QUBKitchen.addDailyMenu();
		System.out.println("End of test case\n*****************");
	}

	public static void testCase44() {
		System.out.println(
				"*****************\nTest case 44: Testing the updateDailyMenuChoice method for different types of data to ensure it works and is error handled for updating and managing daily menus");
		QUBKitchen.updateDailyMenuChoice();
		System.out.println("End of test case\n*****************");
	}

	// Test Cases for Ingredient Class

	public static void testCase45ia() {
		System.out.println("*****************\nTest case 45i: Ingredients' constructor");
		Ingredient ingredient = new Ingredient("Pepper", FoodType.FANDV, 53, "Tasty");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45ib() {
		System.out.println("*****************\nTest case 45i: Ingredients' constructor");
		Ingredient ingredient = new Ingredient(null, FoodType.FANDV, 53, "Tasty");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45ic() {
		System.out.println("*****************\nTest case 45i: Ingredients' constructor");
		Ingredient ingredient = new Ingredient("Pepper", FoodType.FANDV, -1, "Tasty");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45id() {
		System.out.println("*****************\nTest case 45i: Ingredients' constructor");
		Ingredient ingredient = new Ingredient("Pepper", FoodType.FANDV, 53, "");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");
	}

	static Ingredient ingredient = new Ingredient("Pepper", FoodType.FANDV, 53, "Tasty");

	public static void testCase46i() {
		System.out.println("*****************\nTest case 45i: Ingredient toString");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");

	}

	// Test Cases for Recipe Class

	public static void testCase45ra() {
		System.out.println("*****************\nTest case 45ra: Recipes' constructor");
		ArrayList<Ingredient> i = new ArrayList<Ingredient>(
				Arrays.asList(allIngredients.get(27), allIngredients.get(8)));
		ArrayList<Integer> iq = new ArrayList<Integer>(Arrays.asList(300, 150));
		Recipe recipe = new Recipe("Cheese sandwich", "Cook|Eat", 2, i, iq);
		System.out.println(recipe);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45rb() {
		System.out.println("*****************\nTest case 45ra: Recipes' constructor");
		ArrayList<Ingredient> i = new ArrayList<Ingredient>(
				Arrays.asList(allIngredients.get(27), allIngredients.get(8)));
		ArrayList<Integer> iq = new ArrayList<Integer>(Arrays.asList(300, 150));
		Recipe recipe = new Recipe("", "Cook|Eat", 2, i, iq);
		System.out.println(recipe);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45rc() {
		System.out.println("*****************\nTest case 45ra: Recipes' constructor");
		ArrayList<Ingredient> i = new ArrayList<Ingredient>(
				Arrays.asList(allIngredients.get(27), allIngredients.get(8)));
		ArrayList<Integer> iq = new ArrayList<Integer>(Arrays.asList(300, 150));
		Recipe recipe = new Recipe("Cheese sandwich", null, 2, i, iq);
		System.out.println(recipe);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase45rd() {
		System.out.println("*****************\nTest case 45ra: Recipes' constructor");
		ArrayList<Ingredient> i = new ArrayList<Ingredient>(
				Arrays.asList(allIngredients.get(27), allIngredients.get(8)));
		ArrayList<Integer> iq = new ArrayList<Integer>(Arrays.asList(300, 150));
		Recipe recipe = new Recipe("Cheese sandwich", "Cook|Eat", -5, i, iq);
		System.out.println(recipe);
		System.out.println("End of test case\n*****************");
	}

	static ArrayList<Ingredient> i = new ArrayList<Ingredient>(
			Arrays.asList(allIngredients.get(27), allIngredients.get(8)));
	static ArrayList<Integer> iq = new ArrayList<Integer>(Arrays.asList(300, 150));
	static Recipe recipe = new Recipe("Cheese sandwich", "Cook|Eat", 2, i, iq);

	public static void testCase46r() {
		System.out.println("*****************\nTest case 46r: Recipes' toString");
		System.out.println(ingredient);
		System.out.println("End of test case\n*****************");
	}

	// Test Cases for Daily Menu class
	public static void testCase45d() {
		System.out.println("*****************\nTest case 45d: Daily menus' constructor");
		Recipe[] r = { allRecipes.get(3), allRecipes.get(6), allRecipes.get(8) };
		DailyMenu dailyMenu = new DailyMenu("Monday", r);
		System.out.println(dailyMenu);
		System.out.println("End of test case\n*****************");
	}

	static Recipe[] r = { allRecipes.get(3), allRecipes.get(6), allRecipes.get(8) };
	static DailyMenu dailyMenu = new DailyMenu("Monday", r);

	public static void testCase46d() {
		System.out.println("*****************\nTest case 46d: Daily menus' toString");
		System.out.println(dailyMenu);
		System.out.println("End of test case\n*****************");

	}

	// Resources

	public static void testCase47i() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		System.out.println("*****************\nTest case 47i: Preload ingredients");
		System.out.println("Data before: ");
		System.out.println(ingredients);
		ingredients = Resources.addIngredients();
		System.out.println("Data after: ");
		System.out.println(ingredients);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase47r() {
		ArrayList<Recipe> recipes = new ArrayList<>();
		System.out.println("*****************\nTest case 47r: Preload recipes");
		System.out.println("Data before: ");
		System.out.println(recipes);
		recipes = Resources.addRecipes();
		System.out.println("Data after: ");
		System.out.println(recipes);
		System.out.println("End of test case\n*****************");
	}

	public static void testCase47d() {
		ArrayList<DailyMenu> dailyMenus = new ArrayList<>();
		System.out.println("*****************\nTest case 47d: Preload daily menus");
		System.out.println("Data before: ");
		System.out.println(dailyMenus);
		dailyMenus = Resources.addDailyMenus();
		System.out.println("Data after: ");
		System.out.println(dailyMenus);
		System.out.println("End of test case\n*****************");
	}
}
