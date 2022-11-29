package tda.darkarmy.restaurantsearchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.restaurantsearchservice.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByCuisine(String cuisine);
    List<Restaurant> findByDistance(Double distance);
    List<Restaurant> findByBudget(Double budget);
}
