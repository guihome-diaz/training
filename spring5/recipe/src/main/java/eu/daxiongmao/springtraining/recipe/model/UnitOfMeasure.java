package eu.daxiongmao.springtraining.recipe.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * To represent units of measure.<br>
 * Having the units in a dedicated table means it is easier to maintain.
 * You can add / delete / change data without any deployment - unlike an ENUM.
 *
 * @author John Tompson (spring guru, trainer)
 * @author Guillaume Diaz (student)
 */
@Entity
@Table(name = "UNIT_MEASURE")
public class UnitOfMeasure implements Serializable {

    // ***** database specific (ID rely of the underlining database system) *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_MEASURE_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "UNIT", length = 100, nullable = false, unique = true)
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
