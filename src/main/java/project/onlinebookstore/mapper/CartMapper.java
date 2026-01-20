package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import project.onlinebookstore.dto.cart.CartDto;
import project.onlinebookstore.dto.cart.CartRequestDto;
import project.onlinebookstore.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto mapToDto(Cart cart);

    Cart mapToEntity(CartRequestDto cartRequestDto);
}
