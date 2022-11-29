package tda.darkarmy.restaurantsearchservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.restaurantsearchservice.exception.ResourceNotFoundException;
import tda.darkarmy.restaurantsearchservice.model.Restaurant;
import tda.darkarmy.restaurantsearchservice.repository.RestaurantRepository;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant findById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
    }

    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    public Restaurant create(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public  Restaurant update(Restaurant restaurant, Long id){
        restaurantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Restaurant not found"));
        restaurant.setRestaurantId(id);
        return restaurantRepository.save(restaurant);
    }

    public String delete(Long id){
        restaurantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Restaurant not found"));
        restaurantRepository.deleteById(id);
        return "Restaurant deleted successfully";
    }

    public List<Restaurant> findByQuery(Map<String, String> searchParams) {
        if(searchParams.containsKey("name")){
            return restaurantRepository.findByName(searchParams.get("name"));
        }else if(searchParams.containsKey("location")){
            return restaurantRepository.findByLocation(searchParams.get("location"));
        }else if(searchParams.containsKey("cuisine")){
            return restaurantRepository.findByCuisine(searchParams.get("location"));
        }else if(searchParams.containsKey("distance")){
            return restaurantRepository.findByDistance(Double.parseDouble(searchParams.get("distance")));
        }else if(searchParams.containsKey("budget")){
            return restaurantRepository.findByBudget(Double.parseDouble(searchParams.get("budget")));
        }else{
            return restaurantRepository.findAll();
        }
    }
}
