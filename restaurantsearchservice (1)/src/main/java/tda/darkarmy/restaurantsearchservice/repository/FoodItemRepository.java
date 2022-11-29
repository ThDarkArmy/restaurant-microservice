package tda.darkarmy.restaurantsearchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.restaurantsearchservice.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
