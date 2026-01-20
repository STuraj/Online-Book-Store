package project.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.onlinebookstore.dto.wishlist.WishlistDto;
import project.onlinebookstore.dto.wishlist.WishlistRequestDto;
import project.onlinebookstore.entity.Wishlist;
import project.onlinebookstore.exception.NotFoundException;
import project.onlinebookstore.mapper.WishlistMapper;
import project.onlinebookstore.repository.BookRepository;
import project.onlinebookstore.repository.WishlistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

        private final WishlistRepository wishlistRepository;
        private final WishlistMapper wishlistMapper;
        private final BookRepository bookRepository;

        public WishlistDto getWishlistById(Long id) {
            Wishlist wishlist = wishlistRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Wishlist not found with id:" + id));
            return wishlistMapper.mapToDto(wishlist);
        }

        public List<WishlistDto> getAll() {
            return wishlistRepository.findAll()
                    .stream()
                    .map(wishlistMapper::mapToDto)
                    .toList();

        }

        public WishlistDto addWishlist(WishlistRequestDto wishlistRequestDto) {
            Wishlist wishlist = wishlistMapper.mapToEntity(wishlistRequestDto);
            Wishlist wishlistSaved = wishlistRepository.save(wishlist);
            return wishlistMapper.mapToDto(wishlistSaved);

        }
}
