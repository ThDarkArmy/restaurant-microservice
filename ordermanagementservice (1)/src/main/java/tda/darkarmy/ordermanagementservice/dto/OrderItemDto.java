package tda.darkarmy.ordermanagementservice.dto;

public class OrderItemDto {
    private Long foodItemId;
    private Integer quantity;

    public OrderItemDto() {
    }

    public OrderItemDto(Long foodItemId, Integer quantity) {
        this.foodItemId = foodItemId;
        this.quantity = quantity;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "foodItemId=" + foodItemId +
                ", quantity=" + quantity +
                '}';
    }
}
