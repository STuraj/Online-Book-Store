package project.onlinebookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public enum Roles{
        ROLE_USER,
        ROLE_ADMIN

    }
}
