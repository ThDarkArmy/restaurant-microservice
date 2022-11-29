package tda.darkarmy.ordermanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tda.darkarmy.ordermanagementservice.VO.FoodItem;
import tda.darkarmy.ordermanagementservice.VO.OrderItemFoodItemVO;
import tda.darkarmy.ordermanagementservice.dto.OrderItemDto;
import tda.darkarmy.ordermanagementservice.exception.ResourceNotFoundException;
import tda.darkarmy.ordermanagementservice.model.OrderItem;
import tda.darkarmy.ordermanagementservice.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<OrderItem> getAll(){
        return orderItemRepository.findAll();
    }

    public OrderItem getById(Long id){
        return orderItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order Item not found"));
    }

    public OrderItemFoodItemVO create(OrderItemDto orderItemDto){
        OrderItem orderItem = new OrderItem();
        FoodItem foodItem = restTemplate.getForObject("http://RESTAURANT-SEARCH-SERVICE/foodItem/"+orderItemDto.getFoodItemId(), FoodItem.class);
        if(foodItem==null) throw new ResourceNotFoundException("Food Item not found");
        orderItem.setFoodItemId(orderItemDto.getFoodItemId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(foodItem.getPrice()*orderItemDto.getQuantity());
        OrderItem orderItem1 = orderItemRepository.save(orderItem);

        OrderItemFoodItemVO orderItemFoodItemVO = new OrderItemFoodItemVO();
        orderItemFoodItemVO.setFoodItem(foodItem);
        orderItemFoodItemVO.setQuantity(orderItem1.getQuantity());
        orderItemFoodItemVO.setPrice(orderItem1.getPrice());
        return orderItemFoodItemVO;
    }

    public OrderItem update(OrderItem orderItem, Long id){
        OrderItem orderItem1 = orderItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order item not found"));
        orderItem1.setQuantity(orderItem.getQuantity());
        return orderItemRepository.save(orderItem1);
    }

    public String delete(Long id){
        orderItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order item not found"));
        orderItemRepository.deleteById(id);
        return "Order item deleted successfully";
    }

}
