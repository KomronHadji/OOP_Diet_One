package diet;

import java.util.HashMap;
import java.util.Map;

public class Recipe implements NutritionalElement {
	private String name;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	private Food food;
	private Map<NutritionalElement, Double> ingredients = new HashMap<>();


	public Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	public Recipe(String name, double calories, double proteins, double carbs, double fat) {
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
	}

	public Recipe(String name) {
		this.name = name;
	}

	public Recipe	 addIngredient(String material, double quantity) {

		for (NutritionalElement rawMaterial : food.rawMaterialSet) {
			if (rawMaterial.getName()==material){
				ingredients.put(rawMaterial, quantity);
			}
		}
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories;
	}

	@Override
	public double getProteins() {
		return proteins;
	}

	@Override
	public double getCarbs() {
		return carbs;
	}

	@Override
	public double getFat() {
		return fat;
	}


	@Override
	public boolean per100g() {

		return true;
	}

}
