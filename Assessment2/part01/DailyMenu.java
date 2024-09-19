package part01;

/**
 * Allows for creation of daily menus to decide what recipes are used on each
 * day of the week
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 */
public class DailyMenu {

	String dayOfTheWeek; // Daily Menu day of the week
	Recipe[] recipes = new Recipe[3]; // Daily Menu array of recipes

	/**
	 * Constructor for Daily Menus
	 * 
	 * @param dayOfTheWeek
	 * @param recipes
	 */
	public DailyMenu(String dayOfTheWeek, Recipe[] recipes) {
		setDayOfTheWeek(dayOfTheWeek);
		setRecipes(recipes);
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public Recipe[] getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe[] recipes) {
		this.recipes = recipes;
	}

	public String toString() {
		String result = "Day of the Week: " + getDayOfTheWeek();
		for (int i = 0; i < getRecipes().length; i++) {
			if (getRecipes()[i] != null) {
				result += "\nRecipe " + (i + 1) + ":\n" + getRecipes()[i] + "\n";
			}
		}
		return result;
	}

}
