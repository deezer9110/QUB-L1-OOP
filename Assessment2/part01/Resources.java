package part01;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Preloads resources of ingredients, recipes and daily menus to QUBKitchen
 * 
 * @author Oliver Davis, 40403492 
 * @version V1.0
 */
public class Resources {

	/**
	 * Instantiates and adds all ingredients to pre-load them
	 * 
	 * @return allIngredients
	 */
	public static ArrayList<Ingredient> addIngredients() {

		// Ingredients instantiated
		Ingredient i1 = new Ingredient("Pepper", FoodType.FANDV, 52, "Red Bell");
		Ingredient i2 = new Ingredient("Spring Onion", FoodType.FANDV, 63, "Raw");
		Ingredient i3 = new Ingredient("Pasta", FoodType.COMP, 87, "Long");
		Ingredient i4 = new Ingredient("Tomato Passatta", FoodType.COMP, 83, "Tomato sauce");
		Ingredient i5 = new Ingredient("Apples", FoodType.FANDV, 52, "Tasty");
		Ingredient i6 = new Ingredient("Baked Beans", FoodType.COMP, 155, "Tasty");
		Ingredient i7 = new Ingredient("Butter", FoodType.DAIRY, 717, "Tasty");
		Ingredient i8 = new Ingredient("Celery", FoodType.FANDV, 8, "Tasty");
		Ingredient i9 = new Ingredient("Cheese", FoodType.DAIRY, 402, "Tasty");
		Ingredient i10 = new Ingredient("Eggs", FoodType.DAIRY, 155, "Tasty");
		Ingredient i11 = new Ingredient("Flour", FoodType.CEREAL, 364, "Tasty");
		Ingredient i12 = new Ingredient("Garlic", FoodType.FANDV, 111, "Tasty");
		Ingredient i13 = new Ingredient("Ground Beef", FoodType.PROTEIN, 332, "Tasty");
		Ingredient i14 = new Ingredient("Jam", FoodType.SUGAR, 278, "Tasty");
		Ingredient i15 = new Ingredient("Leeks", FoodType.FANDV, 61, "Tasty");
		Ingredient i16 = new Ingredient("Lettuce", FoodType.FANDV, 15, "Tasty");
		Ingredient i17 = new Ingredient("Milk", FoodType.DAIRY, 42, "Tasty");
		Ingredient i18 = new Ingredient("Olive Oil", FoodType.FAT, 884, "Tasty");
		Ingredient i19 = new Ingredient("Onion", FoodType.FANDV, 40, "Tasty");
		Ingredient i20 = new Ingredient("Penne Pasta", FoodType.COMP, 118, "Tasty");
		Ingredient i21 = new Ingredient("Pepper", FoodType.SANDH, 20, "Yellow Bell");
		Ingredient i22 = new Ingredient("Potatoes", FoodType.FANDV, 75, "Tasty");
		Ingredient i23 = new Ingredient("Salt", FoodType.ESSENTIAL, 0, "Tasty");
		Ingredient i24 = new Ingredient("Stock Cubes", FoodType.COMP, 438, "Tasty");
		Ingredient i25 = new Ingredient("Sugar", FoodType.SUGAR, 387, "Tasty");
		Ingredient i26 = new Ingredient("Tomatoes", FoodType.FANDV, 19, "Tasty");
		Ingredient i27 = new Ingredient("Water", FoodType.ESSENTIAL, 0, "Tasty");
		Ingredient i28 = new Ingredient("White Bread", FoodType.COMP, 265, "Tasty");
		Ingredient i29 = new Ingredient("Chicken", FoodType.PROTEIN, 146, "Tasty");
		Ingredient i30 = new Ingredient("Fries", FoodType.COMP, 105, "Tasty");
		Ingredient i31 = new Ingredient("Rice", FoodType.COMP, 400, "Tasty");
		Ingredient i32 = new Ingredient("Curry Sauce", FoodType.SANDH, 80, "Tasty");

		// Returns ingredients as list
		return new ArrayList<Ingredient>(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15,
				i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32));
	}

	/**
	 * Instantiates all recipes to pre-load them
	 * 
	 * @return allRecipes
	 */
	public static ArrayList<Recipe> addRecipes() {
		try {
			// Quantity lists
			ArrayList<Integer> r1Quantities = new ArrayList<Integer>();
			r1Quantities.add(400);
			r1Quantities.add(150);
			r1Quantities.add(300);
			r1Quantities.add(500);
			ArrayList<Integer> r2Quantities = new ArrayList<Integer>();
			r2Quantities.add(500);
			r2Quantities.add(300);
			ArrayList<Integer> r3Quantities = new ArrayList<Integer>();
			r3Quantities.add(400);
			r3Quantities.add(150);
			r3Quantities.add(300);
			ArrayList<Integer> r4Quantities = new ArrayList<Integer>();
			r4Quantities.add(400);
			r4Quantities.add(150);
			ArrayList<Integer> r5Quantities = new ArrayList<Integer>();
			r5Quantities.add(400);
			r5Quantities.add(150);
			r5Quantities.add(100);
			ArrayList<Integer> r6Quantities = new ArrayList<Integer>();
			r6Quantities.add(400);
			r6Quantities.add(600);
			r6Quantities.add(200);
			ArrayList<Integer> r7Quantities = new ArrayList<Integer>();
			r7Quantities.add(400);
			r7Quantities.add(500);
			r7Quantities.add(150);
			ArrayList<Integer> r8Quantities = new ArrayList<Integer>();
			r8Quantities.add(400);
			r8Quantities.add(150);
			r8Quantities.add(300);
			ArrayList<Integer> r9Quantities = new ArrayList<Integer>();
			r9Quantities.add(400);
			r9Quantities.add(200);
			ArrayList<Integer> r10Quantities = new ArrayList<Integer>();
			r10Quantities.add(400);
			r10Quantities.add(350);
			r10Quantities.add(500);

			// Ingredient lists
			ArrayList<Ingredient> r1Ingredients = new ArrayList<>();
			r1Ingredients.add(QUBKitchen.allIngredients.get(0));
			r1Ingredients.add(QUBKitchen.allIngredients.get(1));
			r1Ingredients.add(QUBKitchen.allIngredients.get(2));
			r1Ingredients.add(QUBKitchen.allIngredients.get(3));
			ArrayList<Ingredient> r2Ingredients = new ArrayList<>();
			r2Ingredients.add(QUBKitchen.allIngredients.get(5));
			r2Ingredients.add(QUBKitchen.allIngredients.get(27));
			ArrayList<Ingredient> r3Ingredients = new ArrayList<>();
			r3Ingredients.add(QUBKitchen.allIngredients.get(27));
			r3Ingredients.add(QUBKitchen.allIngredients.get(28));
			r3Ingredients.add(QUBKitchen.allIngredients.get(15));
			ArrayList<Ingredient> r4Ingredients = new ArrayList<>();
			r4Ingredients.add(QUBKitchen.allIngredients.get(29));
			r4Ingredients.add(QUBKitchen.allIngredients.get(28));
			ArrayList<Ingredient> r5Ingredients = new ArrayList<>();
			r5Ingredients.add(QUBKitchen.allIngredients.get(28));
			r5Ingredients.add(QUBKitchen.allIngredients.get(15));
			r5Ingredients.add(QUBKitchen.allIngredients.get(8));
			ArrayList<Ingredient> r6Ingredients = new ArrayList<>();
			r6Ingredients.add(QUBKitchen.allIngredients.get(12));
			r6Ingredients.add(QUBKitchen.allIngredients.get(21));
			r6Ingredients.add(QUBKitchen.allIngredients.get(8));
			ArrayList<Ingredient> r7Ingredients = new ArrayList<>();
			r7Ingredients.add(QUBKitchen.allIngredients.get(28));
			r7Ingredients.add(QUBKitchen.allIngredients.get(30));
			r7Ingredients.add(QUBKitchen.allIngredients.get(31));
			ArrayList<Ingredient> r8Ingredients = new ArrayList<>();
			r8Ingredients.add(QUBKitchen.allIngredients.get(12));
			r8Ingredients.add(QUBKitchen.allIngredients.get(27));
			r8Ingredients.add(QUBKitchen.allIngredients.get(15));
			ArrayList<Ingredient> r9Ingredients = new ArrayList<>();
			r9Ingredients.add(QUBKitchen.allIngredients.get(2));
			r9Ingredients.add(QUBKitchen.allIngredients.get(8));
			ArrayList<Ingredient> r10Ingredients = new ArrayList<>();
			r10Ingredients.add(QUBKitchen.allIngredients.get(12));
			r10Ingredients.add(QUBKitchen.allIngredients.get(0));
			r10Ingredients.add(QUBKitchen.allIngredients.get(1));

			// Recipes instantiated
			Recipe r1 = new Recipe("Tomato Pasta", "Cook|Eat", 2, r1Ingredients, r1Quantities);
			Recipe r2 = new Recipe("Beans on Toast", "cook food|eat", 2, r2Ingredients, r2Quantities);
			Recipe r3 = new Recipe("Chicken Sandwich", "cook food|eat", 3, r3Ingredients, r3Quantities);
			Recipe r4 = new Recipe("Dirty Fries", "cook food|eat", 1, r4Ingredients, r4Quantities);
			Recipe r5 = new Recipe("Chicken Caesar Salad", "cook food|eat", 5, r5Ingredients, r5Quantities);
			Recipe r6 = new Recipe("Shepherds Pie", "cook food|eat", 7, r6Ingredients, r6Quantities);
			Recipe r7 = new Recipe("Chicken Curry", "cook food|eat", 4, r7Ingredients, r7Quantities);
			Recipe r8 = new Recipe("Beef Burger", "cook food|eat", 3, r8Ingredients, r8Quantities);
			Recipe r9 = new Recipe("Mac'n'Cheese", "cook food|eat", 3, r9Ingredients, r9Quantities);
			Recipe r10 = new Recipe("Chilli Concarne", "cook food|eat", 2, r10Ingredients, r10Quantities);

			// Returns recipes as a list
			return new ArrayList<Recipe>(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Instantiates all daily menus to pre-load them
	 * 
	 * @return allDailyMenus
	 */
	public static ArrayList<DailyMenu> addDailyMenus() {
		// Recipes array
		Recipe[] d1Recipes = { QUBKitchen.allRecipes.get(0), QUBKitchen.allRecipes.get(1),
				QUBKitchen.allRecipes.get(3) };
		Recipe[] d2Recipes = { QUBKitchen.allRecipes.get(3), QUBKitchen.allRecipes.get(4),
				QUBKitchen.allRecipes.get(5) };
		Recipe[] d3Recipes = { QUBKitchen.allRecipes.get(6), QUBKitchen.allRecipes.get(7),
				QUBKitchen.allRecipes.get(8) };

		// Instantiates Daily Menus
		DailyMenu d1 = new DailyMenu("Monday", d1Recipes);
		DailyMenu d2 = new DailyMenu("Wednesday", d2Recipes);
		DailyMenu d3 = new DailyMenu("Thursday", d3Recipes);

		// Returns daily menus as list
		return new ArrayList<DailyMenu>(Arrays.asList(d1, d2, d3));
	}
}
