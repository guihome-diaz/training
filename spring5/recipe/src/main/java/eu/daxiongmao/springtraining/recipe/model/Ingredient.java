package eu.daxiongmao.springtraining.recipe.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Cooking ingredient (database entity)
 *
 * @author John Tompson (spring guru, trainer)
 * @author Guillaume Diaz (student)
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {

    // ***** database specific (ID rely of the underlining database system) *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    private Float amount;


    /**
     * Unit of measure.
     * <ul>
     * <li><strong>OWNER</strong> side of the relationship! This is why I use the @JoinColumn.
     * The INGREDIENT table will have a column to store the UNIT id</li>
     * <li>Cascade: no cascade. ingredients changes must not affect the measure unit</li>
     * </ul>
     */
    @OneToOne
    @JoinColumn(name = "UNIT_MEASURE_ID", foreignKey = @ForeignKey(name = "FK_INGREDIENT_MEASURE"))
    private UnitOfMeasure measure;

    // ***** Relationships *****

    /**
     * Related recipe.<br>
     * Many ingredients can be use in 1 recipe (== ManyToOne).<br>
     * Key points:
     * <ul>
     * <li><strong>OWNER</strong> side of the relationship.
     * INGREDIENT table has a column for RECIPE_ID</li>
     * <li>Cascade: no cascade. The deletion of an ingredient should not delete the recipe.</li>
     * </ul>
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_INGREDIENT_RECIPE"))
    private Recipe recipe;

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

    public UnitOfMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(UnitOfMeasure measure) {
        this.measure = measure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
