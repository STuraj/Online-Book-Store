package project.onlinebookstore.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {

        private Long book_id;
        private Long user_id;
        private Integer quantity;

}
