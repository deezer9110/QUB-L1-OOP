package part01;

/**
 * Allows for different food types to be used within the ingredients class and
 * for QUBKitchen
 * 
 * @author Oliver Davis, 40403492
 * @version V1.0
 */
public enum FoodType {

	FANDV("Fruit & Veg"), COMP("Composite Food"), DAIRY("Dairy"), CEREAL("Cereal"), FAT("Fat"), SANDH("Spice & Herb"),
	ESSENTIAL("Essential Nutrient"), SUGAR("Sugar"), PROTEIN("Protein");

	private String info;

	private FoodType(String info) {
		this.info = info;
	}

	public String toString() {
		return info;
	}
}
