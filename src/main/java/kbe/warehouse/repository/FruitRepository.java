package kbe.warehouse.repository;

import kbe.warehouse.data.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT f FROM Fruit f WHERE f.name = :name")
    Fruit findByName(@Param("name") String name);
}
