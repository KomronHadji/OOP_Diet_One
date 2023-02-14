package diet;

import java.util.*;

public class Menu implements NutritionalElement {
    Map<NutritionalElement, Double> menuRecipes = new HashMap<>();
    Set<NutritionalElement> menuProducts = new HashSet<>();
    private String name;
    private double calories;
    private double proteins;
    private double carbs;
    private double fat;
    private Food food;


    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, Food food) {
        this.name = name;
        this.food = food;
    }

    public Menu(String name, double calories, double proteins, double carbs, double fat) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fat = fat;
    }


    public Menu addRecipe(String recipe, double quantity) {
        for (NutritionalElement element : food.recipeList) {
            if (element.getName() == recipe) {
                menuRecipes.put(element, quantity);
            }
        }

        return this;
    }


    public Menu addProduct(String product) {
        for (NutritionalElement element : food.productList) {
            if (element.getName() == product) {
                menuProducts.add(element);
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
