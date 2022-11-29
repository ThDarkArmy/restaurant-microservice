package tda.darkarmy.restaurantsearchservice.dto;

public class FoodItemDto {
    private String name;
    private String type;
    private String imgUrl;
    private Double price;
    private Long restaurantId;

    public FoodItemDto() {
    }

    public FoodItemDto(String name, String type, String imgUrl, Double price, Long restaurantId) {
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.price = price;
        this.restaurantId = restaurantId;
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "FoodItemDto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
