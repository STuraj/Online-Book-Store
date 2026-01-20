package project.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.onlinebookstore.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
