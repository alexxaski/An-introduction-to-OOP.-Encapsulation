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
        basket.put(product, basket.getOrDefault(product, 0) + 1);
        System.out.println("Продукт " + product.getProductName() + " успешно добавлен в корзину.");
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста!");
            return;
        }
        int sum = calculateBasketCost();
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            System.out.println(entry.getKey() + " (Quantity: " + entry.getValue() + ")");
        }
        System.out.println("Итого: " + sum);
    }

    public List<Product> removeProductsByName(String searchCriteria) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Map.Entry<Product, Integer>> basketIterator = basket.entrySet().iterator();
        while (basketIterator.hasNext()) {
            Map.Entry<Product, Integer> entry = basketIterator.next();
            Product product = entry.getKey();
            if (product != null && product.getProductName().toLowerCase().replace(" ", "").contains(searchCriteria.toLowerCase().replace(" ", ""))) {
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
