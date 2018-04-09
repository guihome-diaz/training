package eu.daxiongmao.springtraining.recipe.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryDTO implements Serializable {

    private Long id;

    private String name;

    /**
     * Recipe's categories
     */
    private Set<RecipeDTO> recipes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeDTO> recipes) {
        this.recipes = recipes;
    }
}
