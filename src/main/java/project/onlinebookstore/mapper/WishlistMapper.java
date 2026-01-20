package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import project.onlinebookstore.dto.wishlist.WishlistDto;
import project.onlinebookstore.dto.wishlist.WishlistRequestDto;
import project.onlinebookstore.entity.Wishlist;

@Mapper(componentModel = "spring")
public interface WishlistMapper {

        WishlistDto mapToDto(Wishlist wishlist);

        Wishlist mapToEntity(WishlistRequestDto wishlistRequestDto);
}
