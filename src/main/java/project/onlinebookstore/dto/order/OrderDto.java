package project.onlinebookstore.dto.order;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.onlinebookstore.enums.OrderStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


        private Long id;
        private Long userId;
        private Long orderId;
        private Long bookId;
        private Integer quantity;
        private Double totalPrice;
        private OrderStatus orderStatus;

        List<OrderItemDto> orderItemDto;

    }
