package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.onlinebookstore.entity.Role;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.repository.RoleRepository;
import project.onlinebookstore.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password, String roleName) {

            if (userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Username already exists");
        }

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found" +  roleName));
User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));
    user.setRole(project.onlinebookstore.enums.Role.ROLE_USER);
    return userRepository.save(user);
    }
}