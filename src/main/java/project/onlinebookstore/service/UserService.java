package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.user.UserDto;
import project.onlinebookstore.dto.user.UserRequestDto;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.exception.BusinessException;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.UserMapper;
import project.onlinebookstore.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto create(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new BusinessException("Email already exists");
        }
        User user = userMapper.toEntity(userRequestDto);


        return userMapper.toDto(userRepository.save(user));
    }

        public User getById (Long id){
            return userRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("User not found"));
        }


        public User getByEmail (String email){
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new NotFoundException("User not found"));

        }
        public void delete (Long id){
            User user = getById(id);
            userRepository.delete(user);
        }


    }

