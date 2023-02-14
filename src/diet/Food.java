package diet;

import java.util.*;

public class Food {

    Set<NutritionalElement> rawMaterialSet = new TreeSet<>(new sortByNameComparator());
    Map<String, NutritionalElement> rawMaterialMap = new HashMap<>();
    Map<String, NutritionalElement> productsMap = new HashMap<>();
    Set<NutritionalElement> productList = new TreeSet<>(new sortByNameComparator());

    List<NutritionalElement> recipeList = new ArrayList<>();
    Set<NutritionalElement> recipeListSet = new TreeSet<>();
    Map<String, NutritionalElement> menuMap = new HashMap<>();
    Set<NutritionalElement> menuList = new TreeSet<>(new sortByNameComparator());

    public Food() {
    }

    public void defineRawMaterial(String name,
                                  double calories,
                                  double proteins,
                                  double carbs,
                                  double fat) {
        RawMaterial rawMaterial = new RawMaterial(name, calories, proteins, carbs, fat);
        rawMaterialSet.add(rawMaterial);
        rawMaterialMap.put(name, rawMaterial);

    }

    public Collection<NutritionalElement> rawMaterials() {
        return rawMaterialSet;
    }


    public NutritionalElement getRawMaterial(String name) {
        if (rawMaterialMap != null && rawMaterialMap.size() > 0) {
            for (NutritionalElement rawMaterial : rawMaterialSet) {
                if (rawMaterial.getName().equals(name)) return rawMaterial;
            }
        }

        return null;
    }


    public void defineProduct(String name,
                              double calories,
                              double proteins,
                              double carbs,
                              double fat) {
        Product product = new Product(name, calories, proteins, carbs, fat);
        productList.add(product);
    }


    public Collection<NutritionalElement> products() {
        return productList;
    }


    public NutritionalElement getProduct(String name) {
        for (NutritionalElement element : productList) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public Recipe createRecipe(String name) {
        Recipe recipe = new Recipe(name);
        recipeList.add(recipe);
        recipeListSet.add(recipe);
        return recipe;
    }

    public Collection<NutritionalElement> recipes() {
        return recipeList;
    }


    public NutritionalElement getRecipe(String name) {
        for (NutritionalElement element : recipeList) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public Menu createMenu(String name) {
        Menu menu = new Menu(name);
        menuList.add(menu);
        return menu;
    }

    private static class sortByNameComparator implements Comparator<NutritionalElement> {
        @Override
        public int compare(NutritionalElement o1, NutritionalElement o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
