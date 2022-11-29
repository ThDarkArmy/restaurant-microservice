package tda.darkarmy.restaurantsearchservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String name;
    private String location;
    private String cuisine;
    private Double distance;
    private Double budget;

    @OneToMany(mappedBy = "restaurant")
    private List<FoodItem> foodItem;
    public Restaurant() {
    }

    public Restaurant(Long restaurantId, String location, String cuisine, Double distance, Double budget) {
        this.restaurantId = restaurantId;
        this.location = location;
        this.cuisine = cuisine;
        this.distance = distance;
        this.budget = budget;
    }

    public Restaurant(Long restaurantId, String name, String location, String cuisine, Double distance, Double budget, List<FoodItem> foodItem) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.distance = distance;
        this.budget = budget;
        this.foodItem = foodItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodItem> getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(List<FoodItem> foodItem) {
        this.foodItem = foodItem;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", distance=" + distance +
                ", budget=" + budget +
                ", foodItem=" + foodItem +
                '}';
    }
}
