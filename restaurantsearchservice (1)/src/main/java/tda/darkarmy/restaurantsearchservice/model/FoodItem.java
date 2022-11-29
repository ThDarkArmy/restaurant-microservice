package tda.darkarmy.restaurantsearchservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties("restaurant")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodItemId;
    private String name;
    private String type;
    private String imgUrl;
    private Double price;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public FoodItem() {
    }

    public FoodItem(Long foodItemId, String name, String type, String imgUrl, Double price) {
        this.foodItemId = foodItemId;
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public FoodItem(Long foodItemId, String name, String type, String imgUrl, Double price, Long quantity, Restaurant restaurant) {
        this.foodItemId = foodItemId;
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.price = price;
        this.quantity = quantity;
        this.restaurant = restaurant;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "foodItemId=" + foodItemId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", restaurant=" + restaurant +
                '}';
    }
}
