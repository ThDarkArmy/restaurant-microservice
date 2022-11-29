package tda.darkarmy.restaurantsearchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.restaurantsearchservice.dto.FoodItemDto;
import tda.darkarmy.restaurantsearchservice.model.FoodItem;
import tda.darkarmy.restaurantsearchservice.service.FoodItemService;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/foodItem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return status(200).body(foodItemService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return status(200).body(foodItemService.findAll());
    }


    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody FoodItemDto foodItem){
        return status(201).body(foodItemService.create(foodItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody FoodItem foodItem){
        return status(200).body(foodItemService.update(foodItem, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return status(200).body(foodItemService.delete(id));
    }
}
