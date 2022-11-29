package tda.darkarmy.ordermanagementservice.VO;

import java.util.List;

public class OrderVO {
    private List<OrderItemFoodItemVO> orderItems;
    private Long id;
    private Double totalPrice;
    private Boolean isPaid=false;
    private String paymentType;

    public OrderVO() {
    }

    public OrderVO(List<OrderItemFoodItemVO> orderItems, Long id, Double totalPrice, Boolean isPaid, String paymentType) {
        this.orderItems = orderItems;
        this.id = id;
        this.totalPrice = totalPrice;
        this.isPaid = isPaid;
        this.paymentType = paymentType;
    }

    public List<OrderItemFoodItemVO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemFoodItemVO> orderItems) {
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

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderItems=" + orderItems +
                ", id=" + id +
                ", totalPrice=" + totalPrice +
                ", isPaid=" + isPaid +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
