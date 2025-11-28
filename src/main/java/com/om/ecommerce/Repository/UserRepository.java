package com.om.ecommerce.Repository;

import com.om.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findByEmail(String email);
}
