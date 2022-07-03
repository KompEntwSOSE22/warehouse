package kbe.warehouse;

import kbe.warehouse.data.Fruit;
import kbe.warehouse.repository.FruitRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class CSVImporter{
    public CSVImporter(){};

    public void loadData(FruitRepository repo){
        Path pathToFile = Paths.get("fruits.csv");
        try(BufferedReader br = Files.newBufferedReader(pathToFile)){
            String line = br.readLine();
            line = br.readLine(); //skip first line with titles
            while(line!= null){
                String[] attributes = line.split(",");
                Fruit fruit = createFruit(attributes);
                repo.save(fruit);
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private Fruit createFruit(String[] meta){
        return new Fruit(meta[0], Integer.parseInt(meta[1]), Double.parseDouble(meta[2]), meta[3], meta[4], meta[5], meta[6], meta[7], Integer.parseInt(meta[8]), meta[9], meta[10]);
    }
}
