package com.passthehash.recipesmanager.repositories;

import com.passthehash.recipesmanager.models.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    /*@Transactional
    @Modifying
    @Query("update Person p set p.covidInfo = :covidInfo where p.id = :id")
    void setCovidInfo(@Param("covidInfo") String covidInfo, @Param("id") int id);*/

//    Person findByName(String name);
    Recipe findById(int id);
}
