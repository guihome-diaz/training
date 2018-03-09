package eu.daxiongmao.springtraining.spring5webapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Publisher implements Serializable {

    private static final long serialVersionUID = 20180309L;

    @Id
    @Column(name = "PUBLISHER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    public Publisher() {
    }

    public Publisher(final String name, final String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public boolean equals(final Object o) {
        // No business unique identifier: use technical ID instead
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        // No business unique identifier: use technical ID instead
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
