package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.order.OrderDto;
import project.onlinebookstore.dto.order.OrderItemDto;
import project.onlinebookstore.dto.order.OrderRequestDto;
import project.onlinebookstore.entity.Order;
import project.onlinebookstore.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    //201 created
    public OrderDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.create(orderRequestDto);

    }
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);

    }

    @GetMapping("/user/{userId}")
    public List<OrderDto> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

    @GetMapping("/all")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
