package com.lab.product_management_system.services;

import com.lab.product_management_system.model.Product;
import com.lab.product_management_system.repository.ProductRepository;
import com.lab.product_management_system.tree.ProductBinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductBinaryTree productBinaryTree = new ProductBinaryTree();

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        productBinaryTree.add(savedProduct);
        return savedProduct;
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        Product updatedProduct = productRepository.save(product);
        productBinaryTree.add(updatedProduct);
        return updatedProduct;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        productBinaryTree.delete(id);
    }

    public boolean containsProduct(Long id) {
        return productBinaryTree.containsProduct(id);
    }
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public Product searchProduct(Long id) {
        return productBinaryTree.search(id);
    }


}
