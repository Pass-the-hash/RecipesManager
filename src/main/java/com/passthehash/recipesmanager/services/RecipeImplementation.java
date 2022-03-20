package com.passthehash.recipesmanager.services;

import com.passthehash.recipesmanager.models.Recipe;
import com.passthehash.recipesmanager.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeImplementation implements RecipeService{
    RecipeRepository repository;

    @Autowired
    public RecipeImplementation(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        //recipe.setId(getRandomNumber(1,999999999));
        repository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = repository.findAll();
        return recipes;
    }

    @Override
    public Recipe getRecipeById(int id) {
        return repository.findById(id);
    }

    @Query
    @Override
    public void updateRecipe(int id, Recipe recipe) {
        Recipe entity = repository.findById(id);
        if (recipe.getName() != null) entity.setName(recipe.getName());
        if (recipe.getPrice() != 0 ) entity.setPrice(recipe.getPrice());
        if (recipe.getType() != null) entity.setType(recipe.getType());
        repository.save(entity);

    }

    @Override
    public void deleteRecipe(int id) {
        repository.deleteById(id);
    }

    /*public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }*/
}
