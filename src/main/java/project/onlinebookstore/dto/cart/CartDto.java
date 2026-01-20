package project.onlinebookstore.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {


    private Long id;
    private List<CartItemDto> items;  //sebetdeki mehsullar
    private Double totalPrice;

}
