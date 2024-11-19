package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {
       ProductBasket basket = new ProductBasket();

            basket.addProduct(new SimpleProduct("Молоко", 53));
            basket.addProduct(new SimpleProduct("Хлеб", 32));
            basket.addProduct(new SimpleProduct("Печенье", 29));
            basket.addProduct(new SimpleProduct("Сыр", 234));
            basket.addProduct(new SimpleProduct("Колбаса", 129));
        basket.countingSpecialItems();
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");
        basket.printBasket();

        basket.isThereProduct("Пиво");
        basket.isThereProduct("Молоко");

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей.");
        basket.isThereProduct("Сыр");

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new SimpleProduct("помидоры", 98));
        basket1.addProduct(new SimpleProduct("огурцы", 65));
        basket1.addProduct(new FixPriceProduct("лук", 42));
        basket1.addProduct(new DiscountedProduct("майонез", 120,10));
        basket1.addProduct(new SimpleProduct("соль", 32));
        basket1.countingSpecialItems();
        System.out.println("Общая стоимость корзины: " + basket1.calculateBasketCost() + " рублей.");

        basket1.addProduct(new SimpleProduct("салат", 112));

        basket1.clearBasket();

    }

    }
