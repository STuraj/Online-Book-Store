package project.onlinebookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book books;

        @ManyToOne
        @JoinColumn(name = "cart_id")
        private Cart cart;

        private Integer quantity;

    }
