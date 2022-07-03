package kbe.warehouse;

import kbe.warehouse.repository.BasketRepository;
import kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "kbe.warehouse.*" })
public class WarehouseApplication {
	@Autowired
	FruitRepository fruitRepository;

	@Autowired
	BasketRepository basketRepository;

	CSVImporter csv;

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Bean
	InitializingBean load(){
		return() -> {
			csv = new CSVImporter(fruitRepository, basketRepository);
			csv.load("fruits");
			csv.load("baskets");
		};
	}
}
