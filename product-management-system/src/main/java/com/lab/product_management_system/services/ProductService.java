package com.lab.product_management_system.services;

import com.lab.product_management_system.model.Category;
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

//    @Transactional
//    public Product createProduct(Product product) {
//        Category category = product.getCategory();
//        if (category != null && category.getId() == null) {
//            // Save the category first if it doesn't have an ID
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }
//        return productRepository.save(product);
//    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        productBinaryTree.add(savedProduct);
        return savedProduct;
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        Product updatedProduct = productRepository.save(product);
        productBinaryTree.add(updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        productBinaryTree.delete(id);
    }

    public boolean containsProduct(Long id) {
        return productBinaryTree.containsProduct(id);
    }

    public Product searchProduct(Long id) {
        return productBinaryTree.search(id);
    }
}

