package tda.darkarmy.ordermanagementservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tda.darkarmy.ordermanagementservice.VO.FoodItem;
import tda.darkarmy.ordermanagementservice.model.OrderItem;
import tda.darkarmy.ordermanagementservice.repository.OrderItemRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class OrderItemControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private OrderItemRepository orderItemRepository;


    @InjectMocks
    private OrderItemController orderItemController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderItemController).build();
    }

    @Test
    void getAll() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        Mockito.when(orderItemRepository.save(orderItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/orderItem/");

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void getById() {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        orderItem = orderItemRepository.save(orderItem);
        OrderItem finalOrderItem = orderItem;
        Mockito.when(orderItemRepository.save(orderItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/orderItem/"+ finalOrderItem.getId());

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void create() throws Exception {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );

        String content = objectWriter.writeValueAsString(orderItem);
        Mockito.when(orderItemRepository.save(orderItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/orderItem/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(201));

            return d;
        });
    }

    @Test
    void update() throws JsonProcessingException {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        String content = objectWriter.writeValueAsString(orderItem);
        Mockito.when(orderItemRepository.save(orderItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/orderItem/"+orderItem.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void delete() throws JsonProcessingException {
        OrderItem orderItem = new OrderItem(1l, 6l, 20, 200d );
        String content = objectWriter.writeValueAsString(orderItem);
        Mockito.when(orderItemRepository.save(orderItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/orderItem/"+orderItem.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(200));

            return d;
        });
    }
}