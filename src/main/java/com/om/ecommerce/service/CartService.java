package com.om.ecommerce.service;

import com.om.ecommerce.Repository.CartRepository;
import com.om.ecommerce.Repository.ProductRepository;
import com.om.ecommerce.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepo;
    private final com.om.ecommerce.repository.CartItemRepository cartItemRepository
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
}
