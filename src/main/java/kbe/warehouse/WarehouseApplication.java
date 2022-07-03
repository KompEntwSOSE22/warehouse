package kbe.warehouse;

import kbe.warehouse.data.Fruit;
import kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = { "kbe.warehouse.*" })
//@EntityScan(basePackages = { "kbe.warehouse.*" })
//@EnableJpaRepositories(basePackages = { "kbe.warehouse.*" })
public class WarehouseApplication {
	//static List<Fruit> fruits = new ArrayList<>(); //todos.md: replace with database
	@Autowired
	FruitRepository repo;

	CSVImporter csv;

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Bean
	InitializingBean load(){
		return() -> {
			csv = new CSVImporter();
			csv.loadData(repo);
		};
	}

	/*
	public void importCSV(String filename){
		Path pathToFile = Paths.get(filename);
		try(BufferedReader br = Files.newBufferedReader(pathToFile)){
			String line = br.readLine();
			line = br.readLine(); //skip first line with titles
			while(line!= null){
				String[] attributes = line.split(",");
				Fruit fruit = createFruit(attributes);
				//fruits.add(fruit); // TODO replace mit db
				repo.save(fruit);
				line = br.readLine();
			}
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

	private static Fruit createFruit(String[] meta){
		return new Fruit(meta[0], Integer.parseInt(meta[1]), Double.parseDouble(meta[2]), meta[3], meta[4], meta[5], meta[6], meta[7], Integer.parseInt(meta[8]), meta[9], meta[10]);
	} */
}
