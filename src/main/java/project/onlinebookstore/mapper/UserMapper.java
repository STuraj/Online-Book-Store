package project.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import project.onlinebookstore.dto.user.UserDto;
import project.onlinebookstore.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

        UserDto userToDto(User user);

        User mapToEntity(UserDto userDto);
}
