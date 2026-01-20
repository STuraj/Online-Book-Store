package project.onlinebookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false,  unique = true)
        private String cardNumber;

        @Column(nullable = false)
        private String cardHolderName;

        @Column(nullable = false)
        private LocalDate expireDate;
        private String cvv;
}
