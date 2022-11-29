package tda.darkarmy.ordermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ordermanagementservice.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
