package tda.darkarmy.ordermanagementservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    private Boolean isPaid=false;
    private String paymentType;

    @OneToMany
    @JoinColumn(name="order_item")
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long id, Double totalPrice, Boolean isPaid, String paymentType, List<OrderItem> orderItems) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.isPaid = isPaid;
        this.paymentType = paymentType;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", isPaid=" + isPaid +
                ", paymentType='" + paymentType + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
