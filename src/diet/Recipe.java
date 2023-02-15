package diet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Recipe implements NutritionalElement {
    private String recipeName;
    private Food food;
    private Map<String, Double> ingredients = new HashMap<>();


    public Recipe(String name, Food food) {
        this.recipeName = name;
        this.food = food;
        food.recipeList.add(this);
    }


    public Recipe(String name) {
        this.recipeName = name;
    }

    public Recipe addIngredient(String material, double quantity) {
        if (food.rawMaterialMap.get(material) != null) {
            ingredients.put(material, quantity);
        }
        return this;
    }

    @Override
    public String getName() {
        return recipeName;
    }

    @Override
    public double getCalories() {

        double totalRecipeCalories = 0;
        Map<String, NutritionalElement> rawMaterialMap = food.rawMaterialMap;
        for (String name : ingredients.keySet()) {
            NutritionalElement nutritionalElement = rawMaterialMap.get(name);
            double elementTotalCalory = nutritionalElement.getCalories();
            double percentage = ingredients.get(name);
            double calory = (elementTotalCalory * percentage) / 100;
            totalRecipeCalories += calory;
        }
        return totalRecipeCalories;
    }

    @Override
    public double getProteins() {
        double totalRecipeProteins=0;
        Map<String, NutritionalElement> rawMaterialMap = food.rawMaterialMap;
        for (String name: ingredients.keySet()) {
            NutritionalElement nutritionalElement = rawMaterialMap.get(name);
            double elementTotalProtein = nutritionalElement.getProteins();
            double quantity = ingredients.get(name);
            double protein = (elementTotalProtein*quantity)/100;
            totalRecipeProteins +=protein;

        }
        return totalRecipeProteins;
    }

    @Override
    public double getCarbs() {
        double totalRecipeCarbs = 0;
        Map<String, NutritionalElement> rawMaterialMap = food.rawMaterialMap;
        for (String s : ingredients.keySet()) {
            NutritionalElement nutritionalElement = rawMaterialMap.get(s);
            double elementTotalCarbs = nutritionalElement.getCarbs();
            double quantity = ingredients.get(s);
            double carb = (elementTotalCarbs*quantity)/100;
            totalRecipeCarbs+=carb;

        }
        return totalRecipeCarbs;
    }

    @Override
    public double getFat() {
        double totalRecipeFat = 0;   // to be continued
        return totalRecipeFat;
    }


    @Override
    public boolean per100g() {

        return true;
    }

}
