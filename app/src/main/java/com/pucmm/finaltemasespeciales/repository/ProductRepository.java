package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product findProductById(String codigo);

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
