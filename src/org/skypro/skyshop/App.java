package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Молоко", 53));
        basket.addProduct(new Product("Хлеб", 32));
        basket.addProduct(new Product("Печенье", 29));
        basket.addProduct(new Product("Сыр", 234));
        basket.addProduct(new Product("Колбаса", 129));

        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();

        basket.isThereProduct("Пиво");
        basket.isThereProduct("Молоко");

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей.");
        basket.isThereProduct("Сыр");

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new Product("помидоры", 98));
        basket1.addProduct(new Product("огурцы", 65));
        basket1.addProduct(new Product("лук", 42));
        basket1.addProduct(new Product("майонез", 120));
        basket1.addProduct(new Product("соль", 32));

        System.out.println("Общая стоимость корзины: " + basket1.calculateBasketCost() + " рублей.");

        basket1.addProduct(new Product("салат", 112));


        basket1.clearBasket();
    }
}