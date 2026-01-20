package project.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.onlinebookstore.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
