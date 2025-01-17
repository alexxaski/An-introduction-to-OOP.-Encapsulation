package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        return basket.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста!");
            return;
        }
        int totalCost = calculateBasketCost();
        basket.forEach((product, quantity) -> System.out.println(product + " (Quantity: " + quantity + ")"));
        System.out.println("Итого: " + totalCost);
    }

    public List<Product> removeProductsByName(String searchCriteria) {
        List<Product> removedProducts = new ArrayList<>();
        basket.entrySet().removeIf(entry -> {
            Product product = entry.getKey();
            if (product != null && product.getProductName().toLowerCase().replace(" ", "").contains(searchCriteria.toLowerCase().replace(" ", ""))) {
                removedProducts.add(product);
                return true;
            }
            return false;
        });

        return removedProducts;
    }
}
