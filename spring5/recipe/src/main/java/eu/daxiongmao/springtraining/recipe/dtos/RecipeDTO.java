package eu.daxiongmao.springtraining.recipe.dtos;

import eu.daxiongmao.springtraining.recipe.model.Difficulty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Cooking recipe DTO.
 * @author Guillaume Diaz (student)
 */
public class RecipeDTO implements Serializable {

    private Long id;

    // ***** mandatory attributes *****
    private String name;

    private String directions;

    private Integer preparationTime;

    private Integer cookingTime;

    private Integer nbOfServings;

    private Difficulty difficulty;

    // ***** optional stuff *****

    private String source;

    private String url;

    /**
     * Binary content.
     */
    private Byte[] image;

    // ***** Relationships *****

    /**
     * Recipe's notes (optional).
     */
    private String notes;

    /**
     * Recipe's ingredients.<br>
     * 1 recipe has many ingredients
     */
    private Set<IngredientDTO> ingredients = new HashSet<>();

    /**
     * Recipe's categories.<br>
     * 1 recipe has many categories (== ManyToMany), 1 category has many recipes
     */
    private Set<CategoryDTO> categories = new HashSet<>();

    public RecipeDTO() {
        // default constructor required for JPA
    }

    public RecipeDTO(String name, String directions, Integer preparationTime, Integer cookingTime, Integer nbOfServings, Difficulty difficulty) {
        this.name = name;
        this.directions = directions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.nbOfServings = nbOfServings;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getNbOfServings() {
        return nbOfServings;
    }

    public void setNbOfServings(Integer nbOfServings) {
        this.nbOfServings = nbOfServings;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
