package eu.daxiongmao.springtraining.recipe.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Additional notes related to a recipe.
 *
 * @author John Tompson (Spring Guru)
 * @author Guillaume Diaz (student)
 */
@Entity
@Table(name = "RECIPE_NOTES")
public class Notes implements Serializable {

    // ***** database specific (ID rely of the underlining database system) *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTE_ID", updatable = false, nullable = false)
    private Long id;

    /**
     * Long String.<br>
     * We can save long values in database with:
     * <ul>
     * <li>CLOB: character large objects (big text). Default JPA max value is 255</li>
     * <li>BLOB: binary / file content. this is NOT recommended!
     * Better save the file on disk and put in DB a reference to it.</li>
     * </ul>
     * In Java the "@lob" annotation will automatically cast in CLOB or BLOB
     */
    @Lob
    @Column(name = "NOTES", nullable = false)
    private String recipeNotes;

    // ***** Relationships *****

    /**
     * Related recipe.<br>
     * 1 recipe can have some notes ; 1 note always belong to a recipe.<br>
     * Key points:
     * <ul>
     * <li><strong>INVERT</strong> side of the relationship. This is why we used the 'mappedBy':
     * the NOTE_ID will be stored in the RECIPE table</li>
     * <li>Cascade: no cascade. You can change the note, only the content (attribute value) will be use by Recipe object</li>
     * </ul>
     */
    @OneToOne(mappedBy = "note", fetch = FetchType.EAGER)
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
