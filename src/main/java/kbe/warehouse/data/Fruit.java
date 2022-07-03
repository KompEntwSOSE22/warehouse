package kbe.warehouse.data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fruit{

    private String name;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    private double price;

    private String weight;

    private String coo;

    private String season;

    private String species;

    private String color;

    private int kcal;

    private String vitamins;

    private String minerals;

    // don't want to see the relation
    @JsonIgnore
    @ManyToMany(mappedBy = "containedFruits")
    private List<Basket> inBaskets = new ArrayList<>();

    protected Fruit(){}

    public Fruit(String name, int id, double price, String weight, String coo, String season, String species, String color, int kcal, String vitamins, String minerals){
        this.name = name;
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.coo = coo; // Country of Origin
        this.season = season;
        this.species = species;
        this.color = color;
        this.kcal = kcal;
        this.vitamins = vitamins;
        this.minerals = minerals;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public String getCoo() {
        return coo;
    }

    public String getSeason() {
        return season;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public int getKcal() {
        return kcal;
    }

    public String getVitamins() {
        return vitamins;
    }

    public String getMinerals() {
        return minerals;
    }

    public List<Basket> getInBaskets() {
        return inBaskets;
    }
}
