package project.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.onlinebookstore.dto.order.OrderItemDto;
import project.onlinebookstore.entity.Order;
import project.onlinebookstore.enums.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //user-e gore butun sifarisleri tapmaq
    List<Order> findByUserId(Long userId);

    //statusa gore tapmaq

    List<Order> findByOrderStatus(OrderStatus orderStatus);



}
