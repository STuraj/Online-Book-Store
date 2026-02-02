package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.wishlist.WishlistDto;
import project.onlinebookstore.dto.wishlist.WishlistRequestDto;
import project.onlinebookstore.entity.Book;
import project.onlinebookstore.entity.User;
import project.onlinebookstore.entity.Wishlist;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.WishlistMapper;
import project.onlinebookstore.repository.BookRepository;
import project.onlinebookstore.repository.UserRepository;
import project.onlinebookstore.repository.WishlistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final WishlistMapper wishlistMapper;

    public WishlistDto addWishlist(Long userId, Long bookId) {
        if (wishlistRepository.existsByUserIdAndBookId(userId, bookId)) {
            throw new RuntimeException("Book already in wishlist");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setBook(book);

        Wishlist savedWishlist = wishlistRepository.save(wishlist);

        return WishlistMapper.toDto(savedWishlist);
    }

    public void removeFromWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    public List<WishlistDto> getUserWishlist(Long userId) {
        return wishlistRepository.findByUserId(userId)
                .stream()
                .map(WishlistMapper::toDto)
                .toList();
    }
}

