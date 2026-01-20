package project.onlinebookstore.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

        private Long id;
        private Long book_id;
        private String book_title;
        private String book_author;
        private Integer quantity;
        private Double price;

    }
