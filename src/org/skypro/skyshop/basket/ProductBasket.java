package org.skypro.skyshop.basket;

import org.skypro.skyshop.notFoundAndSedrch.BestResultNotFound;
import org.skypro.skyshop.notFoundAndSedrch.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductBasket {
    private List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
        basket.add(product);
        System.out.println(product);
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (Product product : basket) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста!");
            return;
        }
        int sum = 0;
        for (Product product : basket) {
            System.out.println(product);
            sum += product.getPrice();
        }
        System.out.println("Итого: " + sum);
    }

    public boolean containsProduct(String productName) {
        for (Product product : basket) {
            if (product != null && productName.equalsIgnoreCase(product.getProductName())) {
                System.out.println("Этот товар есть в корзине");
                return true;
            }
        }
        System.out.println("Этого нет в корзине");
        return false;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        basket.clear();
    }

    public void countingSpecialItems() {
        int specialCount = 0;
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                specialCount++;
                System.out.println(product.getProductName() + ": " + product.getPrice() + " (Специальный товар)");
            } else {
                System.out.println(product);
            }
        }
        System.out.println("Специальных товаров: " + specialCount);
        if (specialCount == 0) {
            System.out.println("Специальных товаров нет");
        }
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста!");
        }
    }

    public Searchable findMostSuitableItem(String search) throws BestResultNotFound {
        Searchable mostSuitable = null;
        int maxCount = 0;

        Stack<Searchable> searchEngine = new Stack<>();
        for (Product product : basket) {
            if (product instanceof Searchable) {
                searchEngine.add((Searchable) product);
            }
        }

        for (Searchable searchable : searchEngine) {
            String searchTerm = searchable.getSearchTerm();
            int count = 0;
            int fromIndex = 0;

            while ((fromIndex = searchTerm.indexOf(search, fromIndex)) != -1) {
                count++;
                fromIndex += search.length();
            }

            if (count > maxCount) {
                maxCount = count;
                mostSuitable = searchable;
            }
        }

        if (mostSuitable == null) {
            throw new BestResultNotFound("Нет подходящего объекта для поискового запроса: " + search);
        }
        return mostSuitable;
    }
    public List<Product> removeProductsByName(String productName) {
        List<Product> removedProducts = new ArrayList<>();
        basket.removeIf(product -> {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                removedProducts.add(product);
                return true;
            }
            return false;
        });
        return removedProducts;
    }

}
