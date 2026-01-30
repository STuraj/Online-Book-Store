package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import project.onlinebookstore.dto.order.OrderDto;
import project.onlinebookstore.dto.order.OrderRequestDto;
import project.onlinebookstore.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto mapToDto(Order order);

    Order mapToEntity(OrderRequestDto orderRequestDto);
}
