-- #####################################
--  Initial DB data-set for Spring JDBC
-- #####################################
-- ** This is a SPRING feature **
-- This script will only be executed if the 'DDL-AUTO' property is set to 'create' or 'create-drop'
--

-- !! You must NOT use Hibernate 'import.sql' with Spring JDBC generators 'data.sql' or 'schema*.sql'. It is either HIBERNATE or SPRING, not both !!

-- Script properties
-- Author: Guillaume Diaz
-- Version: 1.0 -2018-04-06
--

INSERT INTO category (name) VALUES ('American');
INSERT INTO category (name) VALUES ('Italian');
INSERT INTO category (name) VALUES ('Mexican');
INSERT INTO category (name) VALUES ('French');
INSERT INTO category (name) VALUES ('Chinese');


INSERT INTO unit_measure (unit) VALUES ('Teaspoon');
INSERT INTO unit_measure (unit) VALUES ('Tablespoon');
INSERT INTO unit_measure (unit) VALUES ('Dash');
-- INSERT INTO unit_measure (unit) VALUES ('Fruits');
-- INSERT INTO unit_measure (unit) VALUES ('Vegetables');
INSERT INTO unit_measure (unit) VALUES ('Cup');
INSERT INTO unit_measure (unit) VALUES ('Pinch');
INSERT INTO unit_measure (unit) VALUES ('Ounce');
INSERT INTO unit_measure (unit) VALUES ('Liter');
INSERT INTO unit_measure (unit) VALUES ('Gram');

INSERT INTO recipe(name, servings, prep_time, cooking_time, difficulty, source, url, directions)
    VALUES ('How to Make Perfect Guacamole Recipe', 4, 10, 0, 'EASY', 'Simply Recipes', 'https://www.simplyrecipes.com/recipes/perfect_guacamole/',
            '<p>Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.</p><p><span class="section-title">Method</span></p><ul><li><span class="bullet number">1)</span> Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.</li><li><span class="bullet number">2)</span> Mash with a fork: Using a fork, roughly mash the avocado. (Do not overdo it! The guacamole should be a little chunky.)</li><li><span class="bullet number">3)</span> Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness. Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.</li><li><span class="bullet number">4)</span> Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve. Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.</li> </ul> <p><span class="section-title">Variations</span></p><p>For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados. Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole). The simplest version of guacamole is just mashed avocados with salt. Do not let the lack of availability of other ingredients stop you from making guacamole. To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great. For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!</p>');

INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('ripe avocados', 2, 1, null);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('Kosher salt', 0.5, 1, 1);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('fresh lime juice or lemon juice', 1, 1, 2);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('minced red onion or thinly sliced green onion', 2, 1, 2);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('serrano chiles, stems and seeds removed, minced', 2, 1, null);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('cilantro (leaves and tender stems), finely chopped', 2, 1, 2);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('freshly grated black pepper', 1, 1, 3);
INSERT INTO ingredient (name, amount, recipe_id, unit_measure_id) VALUES ('ripe tomato, seeds and pulp removed, chopped', 0.5, 1, null);