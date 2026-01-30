package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import project.onlinebookstore.dto.order.OrderItemDto;
import project.onlinebookstore.dto.order.OrderItemRequestDto;
import project.onlinebookstore.entity.Order;
import project.onlinebookstore.entity.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto mapToDto(Order order);

    OrderItem mapToEntity(OrderItemRequestDto orderitemRequestDto);
}
