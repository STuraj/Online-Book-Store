package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.cart.CartDto;
import project.onlinebookstore.dto.cart.CartItemRequestDto;
import project.onlinebookstore.service.CartService;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

        private final CartService cartService;

        @GetMapping("/{id}")
        public CartDto getCartById(@PathVariable Long id) {
            return cartService.getById(id);
        }

        @PostMapping("/{userId}/items")
        public CartDto addItemToCart(@PathVariable Long userId,
                                     @RequestBody CartItemRequestDto itemRequestDto) {
            return cartService.addItemToCart(userId, itemRequestDto);
        }
        @DeleteMapping("/cart/items/{cartItemId}")
        public CartDto removeItemFromCart(@PathVariable Long cartItemId) {
            return cartService.removeItemFromCart(cartItemId);
        }
}
