package tda.darkarmy.restaurantsearchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.restaurantsearchservice.model.Restaurant;
import tda.darkarmy.restaurantsearchservice.service.RestaurantService;

import javax.validation.Valid;

import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return status(200).body(restaurantService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return status(200).body(restaurantService.findAll());
    }

    @GetMapping("/by-query")
    public ResponseEntity<?> findByQuery(@RequestParam Map<String,String> searchParams){
        return status(200).body(restaurantService.findByQuery(searchParams));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant restaurant){
        return status(201).body(restaurantService.create(restaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Restaurant restaurant){
        return status(200).body(restaurantService.update(restaurant, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return status(200).body(restaurantService.delete(id));
    }
}
