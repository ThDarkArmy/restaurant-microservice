package tda.darkarmy.ordermanagementservice.dto;

import java.util.List;

public class OrderDto {
    private List<Long> orderItemIds;

    public OrderDto() {
    }

    public OrderDto(List<Long> orderItemIds) {
        this.orderItemIds = orderItemIds;
    }

    public List<Long> getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(List<Long> orderItemIds) {
        this.orderItemIds = orderItemIds;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderItemIds=" + orderItemIds +
                '}';
    }
}
