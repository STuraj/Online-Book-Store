package project.onlinebookstore.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String author;



        @Column(nullable = false)
        private Double price;

        @Column(nullable = false)
        private Integer quantity;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="category_id")
        Category category;

        @ManyToOne
        Order order;

        @ManyToOne
        Wishlist wishlist;

    }
