package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.onlinebookstore.dto.user.UserDto;
import project.onlinebookstore.dto.user.UserRequestDto;
import project.onlinebookstore.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "wishlist", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(UserRequestDto userRequestDto);

    UserDto toDto(User save);
}
