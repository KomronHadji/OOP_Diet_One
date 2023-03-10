package diet;

import java.util.*;

public class Menu implements NutritionalElement {
    Map<String, Double> menuRecipes = new HashMap<>();
    Map<String, NutritionalElement> recipesMap = new HashMap<>();
    Set<NutritionalElement> menuProducts = new HashSet<>();

    private String menuName;

    private Food food;


    public Menu(String name) {
        this.menuName = name;
    }

    public Menu(String name, Food food) {
        this.menuName = name;
        this.food = food;
    }


    public Menu addRecipe(String recipe, double quantity) {
        for (NutritionalElement element : food.recipeList) {
            if (element.getName().equals(recipe)) {
                menuRecipes.put(recipe, quantity);
                recipesMap.put(recipe, element);
            }
        }

        return this;
    }


    public Menu addProduct(String product) {
        for (NutritionalElement element : food.productList) {
            if (element.getName().equals(product)) {
                menuProducts.add(element);
            }
        }
        return this;
    }

    @Override
    public String getName() {
        return menuName;
    }

    @Override
    public double getCalories() {
        double totalRecipeCalories = 0;
        double productCalories = 0;
        for (NutritionalElement menuProduct : menuProducts) {
//            Set<NutritionalElement> product = food.productList;
            productCalories = menuProduct.getCalories();
        }
//        Map<String, NutritionalElement> recipes = recipesMap;
        for (String name : menuRecipes.keySet()) {
            NutritionalElement nutritionalElement = recipesMap.get(name);
            double recipeCalory = nutritionalElement.getCalories();
            double quantity = menuRecipes.get(name);
            totalRecipeCalories = (recipeCalory * quantity) / 100;

        }
        double totalMenuCalories = productCalories + totalRecipeCalories;
        return totalMenuCalories;
    }


    @Override
    public double getProteins() {
        double totalProductProteins = 0;
        double totalRecipeProteins = 0;
        for (NutritionalElement menuProduct : menuProducts) {
            totalProductProteins = menuProduct.getProteins();
        }
        for (String name : recipesMap.keySet()) {
            NutritionalElement nutritionalElement = recipesMap.get(name);
            double totalProtein = nutritionalElement.getProteins();
            double quantity = menuRecipes.get(name);
            totalRecipeProteins = (totalProtein * quantity) / 100;
        }


        double totalMenuProteins = totalProductProteins + totalRecipeProteins;

        return totalMenuProteins;
    }


    @Override
    public double getCarbs() {
        double totalProductCarbs = 0;
        double totalRecipeCarbs = 0;
        for (NutritionalElement menuProduct : menuProducts) {
            totalProductCarbs = menuProduct.getCarbs();
        }
        for (String s : recipesMap.keySet()) {
            NutritionalElement nutritionalElement = recipesMap.get(s);
            double RecipeCarb = nutritionalElement.getCarbs();
            double quantity = menuRecipes.get(s);
            totalRecipeCarbs = (RecipeCarb * quantity) / 100;
        }

        double totalMenuCarbs = totalProductCarbs + totalRecipeCarbs;

        return totalMenuCarbs;
    }


    @Override
    public double getFat() {
        double totalProductFat = 0;
        double totalRecipeFat = 0;
        for (NutritionalElement menuProduct : menuProducts) {
            totalProductFat  = menuProduct.getCarbs();
        }
        for (String s : recipesMap.keySet()) {
            NutritionalElement nutritionalElement = recipesMap.get(s);
            double RecipeFat = nutritionalElement.getFat();
            double quantity = menuRecipes.get(s);
            totalRecipeFat = (RecipeFat * quantity) / 100;
        }

        double totalMenuFat = totalProductFat + totalRecipeFat;

        return totalMenuFat;
    }


    @Override
    public boolean per100g() {

        return true;
    }
}
