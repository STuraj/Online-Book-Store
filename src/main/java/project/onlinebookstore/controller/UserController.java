package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

private final UserService userService;

@GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
    return userService.getById(id);
}

@DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id){
    userService.delete(id);
        }


}
