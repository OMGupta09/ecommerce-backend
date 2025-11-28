package com.om.ecommerce.service;

import com.om.ecommerce.entity.Product;
import com.om.ecommerce.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo=repo;
    }

    //CREATE
    public Product addProduct(Product product){
        return repo.save(product);
    }

    //READ ALL
    public List<Product> getAll(){
        return repo.findAll();
    }

    //READ ONE
    public Product getById(int id){
        return repo.findById(id).orElse(null);
    }

    //DELETE
    public void delete(int id){
        repo.deleteById(id);
    }
}
