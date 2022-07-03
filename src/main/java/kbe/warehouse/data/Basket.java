package kbe.warehouse.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "containedFruits",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns =@JoinColumn(name ="fruit_id"))
    private List<Fruit> containedFruits = new ArrayList<>();

    protected Basket(){}

    public Basket(String name, int id, List<Fruit> fruits){
        this.id = id;
        this.name = name;
        this.containedFruits = fruits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Fruit> getContainedComponents() {
        return containedFruits;
    }
}
