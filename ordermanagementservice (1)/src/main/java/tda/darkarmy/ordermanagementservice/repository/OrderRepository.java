package tda.darkarmy.ordermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ordermanagementservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
