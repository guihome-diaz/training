package eu.daxiongmao.springtraining.recipe.model;

/**
 * Cooking recipe (database entity)
 * @author John Tompson (spring guru, trainer)
 * @author Guillaume Diaz (student)
 */
public class Recipe {

    // ***** database specific *****
    private Integer id;

    // ***** mandatory attributes *****
    private String name;
    private String description;
    private String directions;
    private Integer preparationTime;
    private Integer cookingTime;
    private Integer nbOfServings;
    private Difficulty difficulty,

    // ***** optional stuff *****
    private String source;
    private String url;
    private Byte[] image;
}
