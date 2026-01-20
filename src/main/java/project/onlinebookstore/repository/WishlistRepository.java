package project.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.onlinebookstore.entity.Wishlist;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Long> {

}
