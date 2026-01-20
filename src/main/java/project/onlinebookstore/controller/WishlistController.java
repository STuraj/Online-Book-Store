package project.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.onlinebookstore.dto.wishlist.WishlistDto;
import project.onlinebookstore.dto.wishlist.WishlistRequestDto;
import project.onlinebookstore.service.WishlistService;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

            private final WishlistService wishlistService;

        @GetMapping("/{id}")
        public WishlistDto getWishlistById(@PathVariable Long id) {
            return wishlistService.getWishlistById(id);
        }

        @GetMapping("/all")
        public List<WishlistDto> getAll() {
            return wishlistService.getAll();

        }
        @PostMapping("/add")
        public WishlistDto addWishlist(@RequestBody WishlistRequestDto wishlistRequestDto) {
            return wishlistService.addWishlist(wishlistRequestDto);
        }
}
