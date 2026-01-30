package project.onlinebookstore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.order.OrderDto;
import project.onlinebookstore.dto.order.OrderItemDto;
import project.onlinebookstore.dto.order.OrderRequestDto;
import project.onlinebookstore.entity.Order;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.OrderItemMapper;
import project.onlinebookstore.mapper.OrderMapper;
import project.onlinebookstore.repository.CartRepository;
import project.onlinebookstore.repository.OrderItemRepository;
import project.onlinebookstore.repository.OrderRepository;
import project.onlinebookstore.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;


    public Order getById(Long orderId) {

return orderRepository.findById(orderId)
       .orElseThrow(()-> new NotFoundException("Order not found"));

    }

    @Transactional
    public OrderDto create(OrderRequestDto orderRequestDto) {

    }

    public List<OrderDto> getOrdersByUser(Long userId) {

    }

    public OrderDto getCancelOrder(Long id) {
return  null;
    }

    public List<OrderItemDto> getAllOrders() {
       // return orderRepository.findAll();


    }
}
