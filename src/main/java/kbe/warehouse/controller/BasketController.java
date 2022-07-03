package kbe.warehouse.controller;

import kbe.warehouse.data.Basket;
import kbe.warehouse.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BasketController {

    @Autowired
    BasketRepository basketRepo;

    @GetMapping("/products")
    public List<Basket> getProducts(){
        return basketRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Basket> getProduct(@PathVariable int id){
        return basketRepo.findById(id);
    }
}
