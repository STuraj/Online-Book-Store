package project.onlinebookstore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.order.OrderDto;
import project.onlinebookstore.dto.order.OrderItemDto;
import project.onlinebookstore.dto.order.OrderItemRequestDto;
import project.onlinebookstore.dto.order.OrderRequestDto;
import project.onlinebookstore.entity.Book;
import project.onlinebookstore.entity.Order;
import project.onlinebookstore.entity.OrderItem;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.enums.OrderStatus;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    @Transactional
    public OrderDto create(OrderRequestDto orderRequestDto) {

        //user yoxlamaq
        User user = userRepository.findById(orderRequestDto.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        //order yaratmaq
        Order order = new Order();
        order.setUser(user);
        order.setOrderStatus(OrderStatus.CREATED);
        List<OrderItem> items = new ArrayList<>();
        double totalPrice = 0;

        //order items
        for (OrderItemRequestDto itemRequestDto : orderRequestDto.getItems()) {
            Book book = bookRepository.findById(itemRequestDto.getBookId())
                    .orElseThrow(() -> new NotFoundException("Book not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(itemRequestDto.getQuantity());
            orderItem.setPrice(book.getPrice());
            orderItem.setOrder(order);
            totalPrice += book.getPrice() * itemRequestDto.getQuantity();
            items.add(orderItem);
        }
        order.setOrderItems(items);
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
        return mapToDto(order);
    }


    public OrderDto getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found"));
        return mapToDto(order);

    }

    public List<OrderDto> getOrdersByUser(Long userId) {
        return orderRepository.findById(userId)
                .stream()
                .map(this::mapToDto)
                .toList();

    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found"));
        if (order.getOrderStatus() == (OrderStatus.SHIPPED)) {
            throw new RuntimeException("Order can not be canceled");
        }
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();


    }

    private OrderDto mapToDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getOrderStatus(),
                order.getTotalPrice());


    }
}
