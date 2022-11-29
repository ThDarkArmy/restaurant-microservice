package tda.darkarmy.ordermanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.ordermanagementservice.dto.OrderItemDto;
import tda.darkarmy.ordermanagementservice.model.OrderItem;
import tda.darkarmy.ordermanagementservice.service.OrderItemService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return status(200).body(orderItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return status(200).body(orderItemService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody OrderItemDto orderItemDto){
        return status(200).body(orderItemService.create(orderItemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody OrderItem orderItem){
        return status(200).body(orderItemService.update(orderItem, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return status(200).body(orderItemService.delete(id));
    }
}
