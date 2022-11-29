package tda.darkarmy.ordermanagementservice.VO;

public class FoodItem {
    private Long foodItemId;
    private String name;
    private String type;
    private String imgUrl;
    private Double price;
    private Long quantity;

    public FoodItem() {
    }

    public FoodItem(Long foodItemId, String name, String type, String imgUrl, Double price, Long quantity) {
        this.foodItemId = foodItemId;
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.price = price;
        this.quantity = quantity;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodItemVo{" +
                "foodItemId=" + foodItemId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
