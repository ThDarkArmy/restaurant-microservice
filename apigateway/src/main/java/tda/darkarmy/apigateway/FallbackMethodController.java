package tda.darkarmy.apigateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
public class FallbackMethodController {

    @GetMapping("/restaurantServiceFallback")
    public ResponseEntity<?> restaurantServiceFallbackMethod(){
        return status(500).body("Service is down");
    }
}
