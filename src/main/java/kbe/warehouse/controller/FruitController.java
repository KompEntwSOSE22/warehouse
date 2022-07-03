package kbe.warehouse.controller;

import kbe.warehouse.data.Fruit;
import kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FruitController {
    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping("/")
    String hello(){
        return "Hello World";
    }

    /**
     * @return a list of all fruits in JSON
     */
    @GetMapping("/components")
    public List<Fruit> gets(){
        return fruitRepository.findAll();
    }

    /**
     * @param id id of fruit
     * @return the specific fruit
     */
    @GetMapping("/components/{id}")
    public Fruit getFruit(@PathVariable int id){
        return fruitRepository.findById(id).get();
    }
}
