package project.onlinebookstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.onlinebookstore.enums.Role;

import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String email;




        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Wishlist> wishlist;

        @Enumerated(EnumType.STRING)
        Role role;
}
