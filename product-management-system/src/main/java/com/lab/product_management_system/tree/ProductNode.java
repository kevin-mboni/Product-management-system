package com.lab.product_management_system.tree;

import com.lab.product_management_system.model.Product;

public class ProductNode {
    private Product product;
    private ProductNode left;
    private ProductNode right;

    public ProductNode(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductNode getLeft() {
        return left;
    }

    public void setLeft(ProductNode left) {
        this.left = left;
    }

    public ProductNode getRight() {
        return right;
    }

    public void setRight(ProductNode right) {
        this.right = right;
    }
}
