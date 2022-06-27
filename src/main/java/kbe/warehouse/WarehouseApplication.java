package kbe.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WarehouseApplication {
	static List<Fruit> fruits = new ArrayList<>(); //TODO: replace with database

	public static void main(String[] args) {
		fruits = importCSV("fruits.csv");
		SpringApplication.run(WarehouseApplication.class, args);
	}
	public static List<Fruit> importCSV(String filename){
		Path pathToFile = Paths.get(filename);
		try(BufferedReader br = Files.newBufferedReader(pathToFile)){
			String line = br.readLine();
			line = br.readLine(); //skip first line with titles
			while(line!= null){
				String[] attributes = line.split(",");
				Fruit fruit = createFruit(attributes);
				fruits.add(fruit); //TODO: replace with database
				line = br.readLine();
			}
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		return fruits;
	}

	private static Fruit createFruit(String[] meta){
		return new Fruit(meta[0], Integer.parseInt(meta[1]), Double.parseDouble(meta[2]), meta[3], meta[4], meta[5], meta[6], meta[7], Integer.parseInt(meta[8]), meta[9], meta[10]);
	}
}
