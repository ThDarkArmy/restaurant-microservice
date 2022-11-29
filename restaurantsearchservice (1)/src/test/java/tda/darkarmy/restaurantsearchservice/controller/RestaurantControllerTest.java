package tda.darkarmy.restaurantsearchservice.controller;

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
import tda.darkarmy.restaurantsearchservice.model.Restaurant;
import tda.darkarmy.restaurantsearchservice.repository.RestaurantRepository;
import tda.darkarmy.restaurantsearchservice.service.RestaurantService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class RestaurantControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private RestaurantRepository restaurantRepository;


    @InjectMocks
    private RestaurantController restaurantController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }



    @Test
    void findById() {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/restaurants/");

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void findAll() {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/restaurants/");

            mockMvc.perform(mockRequest).andExpect(status().is(200));

            return d;
        });
    }

    @Test
    void create() throws Exception {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        String content = objectWriter.writeValueAsString(restaurant);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/restaurants/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().is(201));

    }

    @Test
    void update() throws JsonProcessingException {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        String content = objectWriter.writeValueAsString(restaurant);

        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/restaurants/"+restaurant.getRestaurantId())
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
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/restaurants/"+restaurant.getRestaurantId());

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(200));

            return d;
        });
    }
}