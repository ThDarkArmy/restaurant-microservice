package tda.darkarmy.restaurantsearchservice.controller;

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
import tda.darkarmy.restaurantsearchservice.model.FoodItem;
import tda.darkarmy.restaurantsearchservice.model.Restaurant;
import tda.darkarmy.restaurantsearchservice.repository.FoodItemRepository;
import tda.darkarmy.restaurantsearchservice.repository.RestaurantRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class FoodItemControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private FoodItemRepository foodItemRepository;

    @Mock
    private RestaurantRepository restaurantRepository;


    @InjectMocks
    private FoodItemController foodItemController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(foodItemController).build();
    }


    @Test
    void findById() {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        restaurant = restaurantRepository.save(restaurant);
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(1L);
        foodItem.setType("VEG");
        foodItem.setPrice(200d);
        foodItem.setImgUrl("some url");
        foodItem.setName("Pizza");
        foodItem.setRestaurant(restaurant);
        Mockito.when(foodItemRepository.save(foodItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/foodItem/"+foodItem.getFoodItemId());
            mockMvc.perform(mockRequest).andExpect(status().is(200));
            return d;
        });
    }

    @Test
    void findAll() {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        restaurant = restaurantRepository.save(restaurant);
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(1L);
        foodItem.setType("VEG");
        foodItem.setPrice(200d);
        foodItem.setImgUrl("some url");
        foodItem.setName("Pizza");
        foodItem.setRestaurant(restaurant);
        Mockito.when(foodItemRepository.save(foodItem)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/foodItem/");
            mockMvc.perform(mockRequest).andExpect(status().is(200));
            return d;
        });
    }

    @Test
    void create() throws Exception {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        restaurant = restaurantRepository.save(restaurant);
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(1L);
        foodItem.setType("VEG");
        foodItem.setPrice(200d);
        foodItem.setImgUrl("some url");
        foodItem.setName("Pizza");
        foodItem.setRestaurant(restaurant);

        String content = objectWriter.writeValueAsString(foodItem);

        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/foodItem/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(201));

            return d;
        });
    }


    @Test
    void update() throws Exception {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        restaurant = restaurantRepository.save(restaurant);
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(1L);
        foodItem.setType("VEG");
        foodItem.setPrice(200d);
        foodItem.setImgUrl("some url");
        foodItem.setName("Pizza");
        foodItem.setRestaurant(restaurant);

        String content = objectWriter.writeValueAsString(foodItem);

        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/foodItem/"+foodItem.getFoodItemId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(200));

            return d;
        });

    }

    @Test
    void delete() throws Exception {
        Restaurant restaurant = new Restaurant(1L, "delhi", "cuisine", 300D, 400D);
        restaurant = restaurantRepository.save(restaurant);
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(1L);
        foodItem.setType("VEG");
        foodItem.setPrice(200d);
        foodItem.setImgUrl("some url");
        foodItem.setName("Pizza");
        foodItem.setRestaurant(restaurant);

        String content = objectWriter.writeValueAsString(foodItem);

        Mockito.when(restaurantRepository.save(restaurant)).then(d-> {
            MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/foodItem/"+foodItem.getFoodItemId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(content);

            mockMvc.perform(mockRequest)
                    .andExpect(status().is(200));

            return d;
        });
    }
}