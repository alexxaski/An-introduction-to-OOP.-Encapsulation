package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.notFoundAndSedrch.Searchable;
import java.util.List;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        // Демонстрация работы с ProductBasket
        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("Apple", 50);
        Product product2 = new SimpleProduct("Banana", 30);
        Product product3 = new SimpleProduct("Apple", 50); // Дубликат для теста удаления

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        System.out.println("Сумма корзины: " + basket.calculateBasketCost());
        basket.printBasket();

        String productNameToRemove = "Apple";
        List<Product> removedProducts = basket.removeProductsByName(productNameToRemove);
        System.out.println("Удаленные продукты с именем '" + productNameToRemove + "':");
        for (Product removedProduct : removedProducts) {
            System.out.println(removedProduct);
        }

        System.out.println("Сумма корзины после удаления: " + basket.calculateBasketCost());
        basket.printBasket();

        // Демонстрация работы с SearchEngine
        SearchEngine searchEngine = new SearchEngine();


        String searchTerm = "Apple";

        List<Searchable> searchResults = searchEngine.search(searchTerm);
        System.out.println("Результаты поиска по запросу '" + searchTerm + "':");
        for (Searchable result : searchResults) {
            System.out.println(result.getObjectName());
        }

        List<Searchable> suitableResults = searchEngine.search("Apple");
        System.out.println("Подходящие результаты для запроса 'Apple':");
        for (Searchable result : suitableResults) {
            System.out.println(result.getObjectName());
        }
    }
}
