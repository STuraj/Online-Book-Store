package project.onlinebookstore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.cart.CartDto;
import project.onlinebookstore.dto.cart.CartItemRequestDto;
import project.onlinebookstore.entity.Book;
import project.onlinebookstore.entity.Cart;
import project.onlinebookstore.entity.CartItem;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.CartMapper;
import project.onlinebookstore.repository.BookRepository;
import project.onlinebookstore.repository.CartItemRepository;
import project.onlinebookstore.repository.CartRepository;
import project.onlinebookstore.repository.UserRepository;


import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class CartService {

        private final CartRepository cartRepository;
        private final CartMapper cartMapper;
        private final CartItemRepository cartItemRepository;
        private final BookRepository bookRepository;
        private final UserRepository userRepository;


        public CartDto getById(long id) {
            
            Cart cart = cartRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Cart not found"));
            return cartMapper.mapToDto(cart);
        }
@Transactional
        public CartDto addItemToCart(Long userId, CartItemRequestDto itemRequestDto) {
            //user-e gore sebeti tapmaq veya yenisin yaratmaq
            Cart cart = cartRepository.findByUser_Id(userId)
                    .orElseGet(() -> createNewCart(userId));

            // Kitab mocuddurmu
            Book book = bookRepository.findById(itemRequestDto.getBook_id())
                    .orElseThrow(() -> new NotFoundException("Book not found"));

            // Sebetde bu kitab artiq varmi
            CartItem cartItem = cartItemRepository.findByCart_IdAndBook_Id(cart.getId(),
                    book.getId())
                    .orElse(null);

            if (cartItem!=null){
                //varsa quantity artir

                cartItem.setQuantity(cartItem.getQuantity() + itemRequestDto.getQuantity());
            }else {
                //yoxdursa yeni cartItem yarat

                cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setBook(book);
                cartItem.setQuantity(itemRequestDto.getQuantity());
                cart.getCartItems().add(cartItem);
               
            }
            cartItemRepository.save(cartItem);
            //umumi qiymeti yeniden hesablamaq
            updateCartTotalPrice(cart);

            Cart savedCart = cartRepository.save(cart);
            return cartMapper.mapToDto(savedCart);

        }

    public CartDto removeItemFromCart(Long cartItemId) {
            CartItem cartItem = cartItemRepository.findById(cartItemId)
                    .orElseThrow(()-> new NotFoundException("Cart item  not found"));
            Cart cart = cartItem.getCart();
            cart.getCartItems().remove(cartItem);
            cartItemRepository.delete(cartItem);

            //item cixarilsa umumi qiymetin yeniden hesablanmsi
        updateCartTotalPrice(cart);
        Cart savedCart = cartRepository.save(cart);

         return cartMapper.mapToDto(cart);

        }

       private Cart createNewCart(Long userId) {

            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new NotFoundException("User not found!"));
            Cart cart = new Cart();
           cart.setUser(user);
           cart.setTotalPrice(0.0);
           cart.setCartItems(new ArrayList<>());
           return cartRepository.save(cart);
    }

    private void updateCartTotalPrice(Cart cart) {
            double totalPrice = cart.getCartItems().stream()
                            .mapToDouble(cartItem -> cartItem.getBook().getPrice() * cartItem.getQuantity())
                                    .sum();
            cart.setTotalPrice(totalPrice);

    }
}
