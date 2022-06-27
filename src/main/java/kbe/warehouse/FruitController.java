package kbe.warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {
    private List<Fruit> fruits = WarehouseApplication.fruits;

    @GetMapping("/")
    String hello(){
        return "Hello World";
    }

    /**
     * @return a list of all fruits in JSON
     */
    @GetMapping("/components")
    public List<Fruit> getFruits(){
        return fruits;
    }

    /**
     * @param id id of fruit
     * @return the specific fruit
     */
    @GetMapping("/components/{id}")
    public Fruit getFruit(@PathVariable int id){
        return fruits.get(id);
    }

    /*
    //TODO /products
    @GetMapping("/products")
    public List<Fruitbasket> getProducts(){
        return null;
    }

    //TODO /products/id
    @GetMapping("/products/{id}")
    public Fruitbasket getProduct(@PathVariable int id){
        return null
    } */
}
