package tda.darkarmy.ordermanagementservice.VO;

public class OrderItemFoodItemVO {
    private FoodItem foodItem;
    private Double price;
    private Integer quantity;

    public OrderItemFoodItemVO() {
    }

    public OrderItemFoodItemVO(FoodItem foodItem, Double price, Integer quantity) {
        this.foodItem = foodItem;
        this.price = price;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemFoodItemVO{" +
                "foodItem=" + foodItem +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
