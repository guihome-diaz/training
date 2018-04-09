package eu.daxiongmao.springtraining.recipe.dtos;


import java.io.Serializable;

/**
 * Cooking ingredient (database entity)
 *
 * @author John Tompson (spring guru, trainer)
 * @author Guillaume Diaz (student)
 */
public class IngredientDTO implements Serializable {

    private Long id;

    private String name;
    private Float amount;

    /**
     * Unit of measure.
     */
    private String measure;

    // ***** Relationships *****

    /**
     * Related recipe.<br>
     * Many ingredients can be use in 1 recipe
     */
    private RecipeDTO recipe;

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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }
}
