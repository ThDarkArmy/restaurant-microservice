package tda.darkarmy.ordermanagementservice.model;


import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodItemId;
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Long id, Long foodItemId, Integer quantity, Double price) {
        this.id = id;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", foodItemId=" + foodItemId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
