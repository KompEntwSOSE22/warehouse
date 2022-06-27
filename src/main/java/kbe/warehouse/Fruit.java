package kbe.warehouse;

public class Fruit {
    private final String name;

    private final int id;

    private final double price;

    private final String weight;

    private final String coo;

    private final String season;

    private final String species;

    private final String color;

    private final int kcal;

    private final String vitamins;

    private final String minerals;

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
    public double getId() {
        return price;
    }

    public String getName() {
        return weight;
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
}
