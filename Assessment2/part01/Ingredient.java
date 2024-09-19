package part01;

/**
 * Ingredient class for ingredient objects
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 * 
 */
public class Ingredient {

	private int id; // Ingredient ID
	private String name; // Ingredient name
	private FoodType foodType; // Ingredient Food Type
	private int caloriesPer100g; // Ingredient Calories per 100g
	private String extraDetails; // Ingredient extra details
	private static int nextId = 1; // Ingredient nextID

	/**
	 * Constructs ingredient
	 * 
	 * @param name            - Ingredient name
	 * @param foodType        - Ingredient food type
	 * @param caloriesPer100g - Ingredient calories per 100g
	 * @param extraDetails    - Ingredient extra details
	 */
	public Ingredient(String name, FoodType foodType, int caloriesPer100g, String extraDetails) {
		setId(nextId);
		setName(name);
		setFoodType(foodType);
		setCaloriesPer100g(caloriesPer100g);
		setExtraDetails(extraDetails);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		nextId++;
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

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public int getCaloriesPer100g() {
		return caloriesPer100g;
	}

	public void setCaloriesPer100g(int caloriesPer100g) {
		if (caloriesPer100g > 0) { // Ensures it's over 0
			this.caloriesPer100g = caloriesPer100g;
		} else {
			this.caloriesPer100g = 1;
		}
	}

	public String getExtraDetails() {
		return extraDetails;
	}

	public void setExtraDetails(String extraDetails) {
		if (extraDetails != null && !extraDetails.trim().isEmpty()) { // Ensures they aren't empty or null
			this.extraDetails = extraDetails;
		} else {
			this.extraDetails = "No extra details";
		}
	}

	public String toString() {
		String result = "Id: " + getId();
		result += "\nName: " + getName();
		result += "\nFood Type: " + getFoodType();
		result += "\nCalories per 100g: " + getCaloriesPer100g();
		result += "\nExtra Details: " + getExtraDetails();

		return result;
	}
}
