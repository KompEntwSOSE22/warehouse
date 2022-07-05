package kbe.warehouse.controller;

import kbe.warehouse.data.Basket;
import kbe.warehouse.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BasketController {
    @Autowired
    BasketRepository basketRepo;

    @GetMapping( value={"/products"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Basket> getProducts(){
        return basketRepo.findAll();
    }

    // TODO what if don't exist?
    @GetMapping( value={"/products/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Basket getProduct(@PathVariable int id){
        return basketRepo.findById(id).get();
    }
}
