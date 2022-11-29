package tda.darkarmy.ordermanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tda.darkarmy.ordermanagementservice.VO.FoodItem;
import tda.darkarmy.ordermanagementservice.VO.OrderItemFoodItemVO;
import tda.darkarmy.ordermanagementservice.VO.OrderVO;
import tda.darkarmy.ordermanagementservice.dto.OrderDto;
import tda.darkarmy.ordermanagementservice.exception.ResourceNotFoundException;
import tda.darkarmy.ordermanagementservice.model.Order;
import tda.darkarmy.ordermanagementservice.model.OrderItem;
import tda.darkarmy.ordermanagementservice.repository.OrderItemRepository;
import tda.darkarmy.ordermanagementservice.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getById(Long id){
        return orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found"));
    }

    public OrderVO create(OrderDto orderDto){
        List<OrderItemFoodItemVO> orderItemFoodItemVOS = new ArrayList<>();
        Order order = new Order();
        Double totalPrice = 0d;
        List<OrderItem> orderItemList = new ArrayList<>();
        for(int i=0;i<orderDto.getOrderItemIds().size();i++){
            OrderItem orderItem = orderItemRepository.findById(orderDto.getOrderItemIds().get(i)).orElseThrow(()-> new ResourceNotFoundException("Order Item not found"));
            FoodItem foodItem = restTemplate.getForObject("http://RESTAURANT-SEARCH-SERVICE/foodItem/"+orderItem.getFoodItemId(), FoodItem.class);
            totalPrice+=foodItem.getPrice() * orderItem.getQuantity();
            orderItemList.add(orderItem);
            OrderItemFoodItemVO orderItemFoodItemVO = new OrderItemFoodItemVO();
            orderItemFoodItemVO.setFoodItem(foodItem);
            orderItemFoodItemVO.setQuantity(orderItem.getQuantity());
            orderItemFoodItemVO.setPrice(orderItem.getPrice());
            orderItemFoodItemVOS.add(orderItemFoodItemVO);
        }
        order.setTotalPrice(totalPrice);
        order.setPaymentType("COD");
        order.setOrderItems(orderItemList);

        order = orderRepository.save(order);

        OrderVO orderVO = new OrderVO();
        orderVO.setOrderItems(orderItemFoodItemVOS);
        orderVO.setId(order.getId());
        orderVO.setPaid(false);
        orderVO.setPaymentType(order.getPaymentType());
        orderVO.setTotalPrice(order.getTotalPrice());
        return orderVO;
    }

    public String cancelOrder(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found"));
        orderRepository.deleteById(id);
        return "Order cancelled successfully";
    }
}
