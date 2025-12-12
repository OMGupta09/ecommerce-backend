package com.om.ecommerce.repository;

import com.om.ecommerce.entity.Cart;
import com.om.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart(Cart cart);
    void deleteByCart(Cart cart);
}
