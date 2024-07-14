package com.lab.product_management_system.tree;

import com.lab.product_management_system.model.Product;

public class ProductBinaryTree {
    private ProductNode root;

    public void add(Product product) {
        root = addRecursive(root, product);
    }

    private ProductNode addRecursive(ProductNode current, Product product) {
        if (current == null) {
            return new ProductNode(product);
        }

        if (product.getId() < current.getProduct().getId()) {
            current.setLeft(addRecursive(current.getLeft(), product));
        } else if (product.getId() > current.getProduct().getId()) {
            current.setRight(addRecursive(current.getRight(), product));
        } else {
            return current;
        }

        return current;
    }

    public boolean containsProduct(Long id) {
        return containsNodeRecursive(root, id);
    }

    private boolean containsNodeRecursive(ProductNode current, Long id) {
        if (current == null) {
            return false;
        }

        if (id.equals(current.getProduct().getId())) {
            return true;
        }

        return id < current.getProduct().getId()
                ? containsNodeRecursive(current.getLeft(), id)
                : containsNodeRecursive(current.getRight(), id);
    }

    public void delete(Long id) {
        root = deleteRecursive(root, id);
    }

    private ProductNode deleteRecursive(ProductNode current, Long id) {
        if (current == null) {
            return null;
        }

        if (id.equals(current.getProduct().getId())) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            Long smallestValue = findSmallestValue(current.getRight());
            current.getProduct().setId(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (id < current.getProduct().getId()) {
            current.setLeft(deleteRecursive(current.getLeft(), id));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), id));
        return current;
    }

    private Long findSmallestValue(ProductNode root) {
        return root.getLeft() == null ? root.getProduct().getId() : findSmallestValue(root.getLeft());
    }

    public Product search(Long id) {
        return searchRecursive(root, id);
    }

    private Product searchRecursive(ProductNode current, Long id) {
        if (current == null) {
            return null;
        }

        if (id.equals(current.getProduct().getId())) {
            return current.getProduct();
        }

        return id < current.getProduct().getId()
                ? searchRecursive(current.getLeft(), id)
                : searchRecursive(current.getRight(), id);
    }
}
