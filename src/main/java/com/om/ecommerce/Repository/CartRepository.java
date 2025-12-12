package com.om.ecommerce.Repository;

import com.om.ecommerce.entity.Cart;
import com.om.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findByUser(User user);
}
