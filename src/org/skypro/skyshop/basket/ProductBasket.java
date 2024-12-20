package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    Map<Product, Integer> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getProductName();
        int price = product.getPrice();

        basket.put(product, basket.getOrDefault(product, 0) + 1);
        System.out.println(productName + ": " + price);
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public void printBasket() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + " (Quantity: " + quantity + ")");
            sum += product.getPrice() * quantity;
        }
        System.out.println("Total: " + sum);
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deleted = new ArrayList<>();
        Iterator<Map.Entry<Product, Integer>> basketIterator = basket.entrySet().iterator();
        while (basketIterator.hasNext()) {
            Map.Entry<Product, Integer> entry = basketIterator.next();
            Product product = entry.getKey();
            if (product.getProductName().toLowerCase().replace(" ", "").contains(name.toLowerCase().replace(" ", ""))) {
                deleted.add(product);
                if (entry.getValue() > 1) {
                    basket.put(product, entry.getValue() - 1);
                } else {
                    basketIterator.remove();
                }
            }
        }
        if (deleted.isEmpty()) {
            System.out.println("No products matching the name found in the basket.");
        } else {
            System.out.println("Deleted products:");
            for (Product deletedProduct : deleted) {
                System.out.println(deletedProduct);
            }
        }
        return deleted;
    }
    public List<Product> removeProductsByName(String productName) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Map.Entry<Product, Integer>> basketIterator = basket.entrySet().iterator();
        while (basketIterator.hasNext()) {
            Map.Entry<Product, Integer> entry = basketIterator.next();
            Product product = entry.getKey();
            if (product.getProductName().equalsIgnoreCase(productName)) {
                removedProducts.add(product);
                if (entry.getValue() > 1) {
                    basket.put(product, entry.getValue() - 1);
                } else {
                    basketIterator.remove();
                }
            }
        }
        return removedProducts;
    }
}
