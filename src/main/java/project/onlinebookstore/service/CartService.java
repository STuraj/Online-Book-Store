//package project.onlinebookstore.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import project.onlinebookstore.dto.cart.CartDto;
//import project.onlinebookstore.dto.cart.CartItemRequestDto;
//import project.onlinebookstore.entity.Cart;
//import project.onlinebookstore.exception.NotFoundException;
//import project.onlinebookstore.mapper.CartMapper;
//import project.onlinebookstore.repository.CartItemRepository;
//import project.onlinebookstore.repository.CartRepository;
//
//@Service
//@RequiredArgsConstructor
//public class CartService {
//
//        private final CartRepository cartRepository;
//        private final CartMapper cartMapper;
//        private final CartItemRepository cartItemRepository;
//
//        public CartDto getById(long id) {
//            Cart cart = cartRepository.findById(id)
//                    .orElseThrow(() -> new NotFoundException("Cart not found"));
//            return cartMapper.mapToDto(cart);
//        }
//
//        public CartDto addItemToCart(Long userId, CartItemRequestDto itemRequestDto) {
//            Cart cart = cartMapper.mapToEntity();
//            Cart cartSaved = cartRepository.save(cart);
//            return cartMapper.mapToDto(cartSaved);
//        }
//
//        public CartDto removeItemFromCart(Long cartItemId) {
//            Cart cart = cartMapper.mapToEntity(cartItemId);
//            Cart cartRemove = cartRepository.delete(cart);
//            return cartMapper.mapToDto(cartRemove);
//        }
//}
