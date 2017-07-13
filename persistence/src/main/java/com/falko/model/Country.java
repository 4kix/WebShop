package com.falko.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfCountry;

    @NotNull
    @Column(unique = true)
    private String nameOfCountry;

    @OneToMany(mappedBy = "country")
    private List<Product> products;

    public int getIdOfCountry() {
        return idOfCountry;
    }

    public void setIdOfCountry(int idOfCountry) {
        this.idOfCountry = idOfCountry;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
