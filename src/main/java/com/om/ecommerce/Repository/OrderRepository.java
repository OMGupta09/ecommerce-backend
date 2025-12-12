package com.om.ecommerce.Repository;

import com.om.ecommerce.entity.Order;
import com.om.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByUser(User user);
}
