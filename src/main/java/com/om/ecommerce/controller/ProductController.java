package com.om.ecommerce.controller;

import com.om.ecommerce.entity.Product;
import com.om.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service=service;
    }

    //CREATE
    @GetMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }


    // READ ONE
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.delete(id);
        return "Product deleted successfully";
    }
}
