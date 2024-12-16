package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        try {
            Product invalidProduct = new SimpleProduct("", -5); // Создание продукта с неправильными данными
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            Product invalidProduct = new DiscountedProduct("Apple", 50, 120); // Создание продукта с неправильными данными
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            //  найти наиболее подходящий товар в корзине
            Searchable mostSuitableItem = basket.findMostSuitableItem("searchQuery");
            System.out.println("Наиболее подходящий товар: " + mostSuitableItem.getObjectName());
        } catch (BestResultNotFound e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

    }
}
// Исправил согласно замечаниям.
