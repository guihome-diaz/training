package eu.daxiongmao.springtraining.recipe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Cooking recipe (database entity)
 * @author John Tompson (spring guru, trainer)
 * @author Guillaume Diaz (student)
 */
@Entity(name = "RECIPE")
public class Recipe implements Serializable {

    // ***** database specific (ID rely of the underlining database system) *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
    private Long id;

    // ***** mandatory attributes *****
    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "DIRECTIONS", length = 5000, nullable = false)
    private String directions;

    @Column(name = "PREP_TIME", nullable = false)
    private Integer preparationTime;

    @Column(name = "COOKING_TIME", nullable = false)
    private Integer cookingTime;

    @Column(name = "SERVINGS", nullable = false)
    private Integer nbOfServings;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "DIFFICULTY", length = 10)
    private Difficulty difficulty;

    // ***** optional stuff *****

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "URL")
    private String url;

    /**
     * Binary content.<br>
     * This can be saved in database with:
     * <ul>
     * <li>CLOB: character large objects (big text). Default JPA max value is 255</li>
     * <li>BLOB: binary / file content. this is NOT recommended!
     * Better save the file on disk and put in DB a reference to it.</li>
     * </ul>
     * In Java the "@lob" annotation will automatically cast in CLOB or BLOB
     */
    @Lob
    @Column(name = "IMAGE")
    private Byte[] image;

    // ***** Relationships *****

    /**
     * Recipe's notes.<br>
     * 1 recipe can have some notes ; 1 note always belong to a recipe.<br>
     * Key points:
     * <ul>
     * <li><strong>OWNER</strong> side of the relationship! This is why I use the @JoinColumn.
     * The RECIPE table will have a column to store the reference to a note</li>
     * <li>Cascade: every recipe change (update, delete, etc.) will affect the corresponding note.</li>
     * </ul>
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "NOTE_ID")
    private Notes note;

    /**
     * Recipe's ingredients.<br>
     * 1 recipe has many ingredients (== OneToMany).<br>
     * Key points:
     * <ul>
     * <li><strong>INVERT</strong> side of the relationship! This is why there is the 'mappedBy'.
     * It will be the INGREDIENT table that store the link to RECIPE_ID</li>
     * <li>Cascade: every recipe change (update, delete, etc.) will affect the associated ingredients.</li>
     * </ul>
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<Ingredient> ingredients = new HashSet<>();


    /**
     * Recipe's categories.<br>
     * 1 recipe has many categories (== ManyToMany), 1 category has many recipes (== ManyToMany).<br>
     * Key points:
     * <ul>
     * <li>ManyToMany requires a <strong>join table</strong> in database</li>
     * <li><strong>OWNER</strong> side of the relationship! This is why I use the @JoinColumn.
     * Note that the JoinColumn creates the JOIN TABLE<br>
     * <i>Convention</i>: the join table name should start with the OWNERSHIP entity name
     * </li>
     * <li>Cascade: no cascade. every recipe change (DELETE, UPDATE) should not affect the associated categories.</li>
     * </ul>
     */
    @ManyToMany
    @JoinTable(
            name = "RECIPE_CATEGORY",
            joinColumns = @JoinColumn(name = "RECIPE_ID", referencedColumnName = "RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
        // default constructor required for JPA
    }

    public Recipe(String name, String directions, Integer preparationTime, Integer cookingTime, Integer nbOfServings, Difficulty difficulty) {
        this.name = name;
        this.directions = directions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.nbOfServings = nbOfServings;
        this.difficulty = difficulty;
    }

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

    public Notes getNote() {
        return note;
    }

    public void setNote(Notes note) {
        this.note = note;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
