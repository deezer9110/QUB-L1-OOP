package part01;

import java.util.ArrayList;

/**
 * Allows for creation of recipes and uses ingredients
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 */
public class Recipe {

	private int id; // Recipe ID
	private String name; // Recipe name
	private String method; // Recipe method
	private int howManyPortions; // Recipe amount of portions
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(); // Recipe Ingredient list
	private ArrayList<Integer> ingredientQuantities = new ArrayList<Integer>(); // Recipe Ingredient quantities list
	static private int nextId = 1;

	/**
	 * Constructor for Recipes
	 * 
	 * @param name
	 * @param method
	 * @param howManyPortions
	 * @param ingredients
	 * @param ingredientQuantities
	 */
	public Recipe(String name, String method, int howManyPortions, ArrayList<Ingredient> ingredients,
			ArrayList<Integer> ingredientQuantities) {
		setId(nextId);
		setName(name);
		setMethod(method);
		setHowManyPortions(howManyPortions);
		setIngredients(ingredients);
		setIngredientQuantities(ingredientQuantities);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		nextId++;
	}

	public ArrayList<Integer> getIngredientQuantities() {
		return ingredientQuantities;
	}

	public void setIngredientQuantities(ArrayList<Integer> ingredientQuantities) {
		this.ingredientQuantities = ingredientQuantities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) { // Ensures they aren't empty or null
			this.name = name;
		} else {
			this.name = "Unknown name";
		}
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		if (method != null && !method.trim().isEmpty()) { // Ensures they aren't empty or null
			this.method = method;
		} else {
			this.method = "Unavailable";
		}
	}

	public int getHowManyPortions() {
		return howManyPortions;
	}

	public void setHowManyPortions(int howManyPortions) {
		if (howManyPortions > 0) { // Ensures they are over 0
			this.howManyPortions = howManyPortions;
		} else {
			this.howManyPortions = 1;
		}
	}

	public double getCalories() {
		double total = 0;
		for (int i = 0; i < getIngredients().size() && i < getIngredientQuantities().size(); i++) {
			total += ((double) getIngredients().get(i).getCaloriesPer100g() / 100
					* (double) getIngredientQuantities().get(i));
		}
		return total;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String toString() {
		String result = "";
		result += "Id: " + getId();
		result += "\nName: " + getName();
		result += "\n" + getHowManyPortions() + " portions";
		result += "\nCalories: " + getCalories() + ", " + (getCalories() / getHowManyPortions()) + " per portion\n";
		for (int i = 0; i < getIngredients().size(); i++) {
			result += "\nIngredient " + (i + 1) + ":\n" + getIngredients().get(i).toString();
			result += "\nAmount: " + getIngredientQuantities().get(i) + "g\n";
		}
		result += "\nMethod: \n";
		String[] methodSteps = getMethod().split("\\|");
		for (int i = 0; i < methodSteps.length; i++) {
			result += "\nStep " + (i + 1) + " " + methodSteps[i];
		}
		return result;
	}

}
