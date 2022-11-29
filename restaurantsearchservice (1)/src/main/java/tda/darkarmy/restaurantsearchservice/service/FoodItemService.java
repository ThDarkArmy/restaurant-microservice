package tda.darkarmy.restaurantsearchservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.restaurantsearchservice.dto.FoodItemDto;
import tda.darkarmy.restaurantsearchservice.exception.ResourceNotFoundException;
import tda.darkarmy.restaurantsearchservice.model.FoodItem;
import tda.darkarmy.restaurantsearchservice.model.Restaurant;
import tda.darkarmy.restaurantsearchservice.repository.FoodItemRepository;
import tda.darkarmy.restaurantsearchservice.repository.RestaurantRepository;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public FoodItem findById(Long id){
        return foodItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FoodItem not found"));
    }

    public List<FoodItem> findAll(){
        return foodItemRepository.findAll();
    }

    public FoodItem create(FoodItemDto foodItemDto){
        Restaurant restaurant = restaurantRepository.findById(foodItemDto.getRestaurantId()).orElseThrow(()-> new ResourceNotFoundException("Restaurant not found"));
        FoodItem foodItem = new FoodItem();
        foodItem.setImgUrl(foodItemDto.getImgUrl());
        foodItem.setName(foodItemDto.getName());
        foodItem.setPrice(foodItemDto.getPrice());
        foodItem.setType(foodItemDto.getType());
        foodItem.setRestaurant(restaurant);
        return foodItemRepository.save(foodItem);
    }

    public FoodItem update(FoodItem foodItem, Long id){
        FoodItem foodItem1 = foodItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("FoodItem not found"));
        foodItem.setFoodItemId(id);
        foodItem.setRestaurant(foodItem1.getRestaurant());
        return foodItemRepository.save(foodItem);
    }

    public String delete(Long id){
        foodItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("FoodItem not found"));
        foodItemRepository.deleteById(id);
        return "FoodItem deleted successfully";
    }
}
