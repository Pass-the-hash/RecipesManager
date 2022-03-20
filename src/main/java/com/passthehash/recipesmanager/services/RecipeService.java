package com.passthehash.recipesmanager.services;

import com.passthehash.recipesmanager.models.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);
    List<Recipe> getRecipes();
    Recipe getRecipeById(int id);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(int id);
}
