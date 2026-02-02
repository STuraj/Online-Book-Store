package project.onlinebookstore.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemRequestDto {

    private Long book_id;
    private Integer quantity;


}
