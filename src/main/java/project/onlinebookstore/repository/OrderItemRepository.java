package project.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.onlinebookstore.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
