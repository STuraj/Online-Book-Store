package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.wishlist.WishlistDto;
import project.onlinebookstore.dto.wishlist.WishlistRequestDto;
import project.onlinebookstore.entity.Book;
import project.onlinebookstore.service.WishlistService;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;


    @PostMapping("/{userId}/{bookId}")
    public WishlistDto addWishlist(@PathVariable Long userId, @PathVariable Long bookId) {
        wishlistService.addWishlist(userId, bookId);
return wishlistService.addWishlist(userId, bookId);
    }

        @GetMapping("/{userId}")
        public List<WishlistDto> getUserWishlist(@PathVariable Long userId) {
            return wishlistService.getUserWishlist(userId);
        }

        @DeleteMapping("/wishlistId")
    public void removeFromWishlist(@PathVariable Long wishlistId) {
wishlistService.removeFromWishlist(wishlistId);

        }
}
