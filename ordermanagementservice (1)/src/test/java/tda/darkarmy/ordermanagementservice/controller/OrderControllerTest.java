package tda.darkarmy.ordermanagementservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tda.darkarmy.ordermanagementservice.model.Order;
import tda.darkarmy.ordermanagementservice.model.OrderItem;
import tda.darkarmy.ordermanagementservice.repository.OrderItemRepository;
import tda.darkarmy.ordermanagementservice.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class OrderControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private OrderRepository orderRepository;


    @InjectMocks
    private OrderController orderController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void getAll() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        Order order = new Order(1L, 2000d, false, "COD", orderItemList);

        Mockito.when(orderRepository.save(order)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/orders/");

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void getById() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        Order order = new Order(1L, 2000d, false, "COD", orderItemList);

        Mockito.when(orderRepository.save(order)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/orders/"+order.getId());

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void create() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        Order order = new Order(1L, 2000d, false, "COD", orderItemList);

        Mockito.when(orderRepository.save(order)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/orders/");

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void cancelOrder() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        Order order = new Order(1L, 2000d, false, "COD", orderItemList);

        Mockito.when(orderRepository.save(order)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/orders/"+order.getId());

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }
}