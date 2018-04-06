package eu.daxiongmao.springtraining.recipe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CATEGORY")
public class Category implements Serializable {

    // ***** database specific (ID rely of the underlining database system) *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;


    /**
     * Recipe's categories.<br>
     * 1 recipe has many categories (== ManyToMany), 1 category has many recipes (== ManyToMany).<br>
     * Key points:
     * <ul>
     * <li>ManyToMany requires a <strong>join table</strong> in database</li>
     * <li><strong>INVERT</strong> side of the relationship! This is why there is the 'mappedBy'.
     * It will be the JOIN TABLE that store the link to between the 2 elements.
     * That join table is defined on the Recipe entity</li>
     * <li>Cascade: no cascade. every category change (DELETE, UPDATE) should not affect the associated recipes.</li>
     * </ul>
     */
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
