package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.dao.ProductDAO;
import com.pucmm.finaltemasespeciales.database.entity.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    ProductDAO dao;

    public ProductRepositoryImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAll();
    }

    @Override
    public Product findProductById(String codigo) {
        return dao.findById(codigo);
    }

    @Override
    public void insertProduct(Product product) {
        dao.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        dao.update(product);
    }

    @Override
    public void deleteProduct(Product product) {
        dao.delete(product);
    }
}
