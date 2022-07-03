package kbe.warehouse;

import kbe.warehouse.data.Basket;
import kbe.warehouse.data.Fruit;
import kbe.warehouse.repository.BasketRepository;
import kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVImporter{
    FruitRepository fruitRepository;
    BasketRepository basketRepository;

    public CSVImporter(FruitRepository fruit, BasketRepository basket){
        this.fruitRepository = fruit;
        this.basketRepository = basket;
    };

    public void load(String path){
        Path pathToFile = Paths.get(path+".csv");
        try(BufferedReader br = Files.newBufferedReader(pathToFile)){
            String line = br.readLine();
            line = br.readLine(); //skip first line with titles
            while(line!= null){
                String[] attributes = line.split(",");
                if(path.equals("fruits")){
                   createFruit(attributes);
                } else {
                   createBasket(attributes);
                }
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private void createFruit(String[] meta){
        Fruit fruit = new Fruit(meta[0], Integer.parseInt(meta[1]), Double.parseDouble(meta[2]), meta[3], meta[4], meta[5], meta[6], meta[7], Integer.parseInt(meta[8]), meta[9], meta[10]);
        fruitRepository.save(fruit);
    }

    private void createBasket(String[] meta){
        String[] fruits = meta[2].replaceAll("\\s","").split("-"); //remove whitespaces before splitting
        List<Fruit> list = new ArrayList<>();

       for (int i=0; i < fruits.length; i++){
           Fruit fruit = fruitRepository.findByName(fruits[i]);
           list.add(fruit);
        }

       Basket basket = new Basket(meta[0],Integer.parseInt(meta[1]), list);
       basketRepository.save(basket);
    }


}
