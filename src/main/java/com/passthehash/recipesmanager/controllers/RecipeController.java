package com.passthehash.recipesmanager.controllers;

import com.passthehash.recipesmanager.models.Recipe;
import com.passthehash.recipesmanager.services.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    /*@Autowired
    CarrierService carrierService;*/

    @GetMapping("/recipes")
    @ResponseBody
    public List<Recipe> Recipes() {

        return recipeService.getRecipes();
    }

    @GetMapping("/recipes/{id}")
    @ResponseBody
    public Recipe ShowRecipe(@PathVariable("id") int id) {
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("/recipes/{id}")
    @ResponseBody
    public ResponseEntity<String> DeleteRecipe(@PathVariable("id") int id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<String>("DELETE Response", HttpStatus.ACCEPTED);
    }

    @PostMapping("/recipes")
    @ResponseBody
    public ResponseEntity<String> AddRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return new ResponseEntity<String>("POST Response", HttpStatus.ACCEPTED);
    }

    @PutMapping("/recipes/{id}")
    @ResponseBody
    public ResponseEntity<String> UpdateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return new ResponseEntity<String>("Update Response", HttpStatus.ACCEPTED);
    }

   /* @GetMapping("/carriers")
    @ResponseBody
    public Collection<Carrier> GetCarriers() {
        return carrierService.findAll();
    }
    @PutMapping("/carriers/{id}/approve")
    @ResponseBody
    public Carrier ApproveCarrier(@PathVariable("id")int id,@RequestBody Carrier carr) {
        Carrier carrier=carrierService.findById(id);
        carrier.setApproved(carr.isApproved());
        return carrierService.update(carrier);
    }*/
}
