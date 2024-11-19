package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket;
    private int counter;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(Product product) {
        if (counter >= basket.length) {
            throw new IndexOutOfBoundsException("Невозможно добавить продукт");
        }
        String productName = product.getProductName();
        int price = product.getPrice();
        basket[counter++] = product;
        System.out.println(productName + ": " + price);
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
                //System.out.println("Итого: " + calculateBasketCost());

            }
        }
        return sum;
    }

    public void printBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                sum += product.getPrice();
            } else if (counter == 0) {
                System.out.println("Корзина пуста!");
                break;
            }
        }
        System.out.println("Итого: " + sum);
    }

    public boolean isThereProduct(String productName) {
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
        Arrays.fill(basket, null);
    }

    public void countingSpecialItems() {
        int specialCount = 0;
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        for (Product product : basket) {
            if (product != null && product.isSpecial() ) {
                System.out.println(product.getProductName() + ": " + product.getPrice() + " (Специальный товар)");
            } else {
                System.out.println(product);
            }
        }
        System.out.println("Специальных товаров: " + specialCount);
        if (specialCount == 0) {
            System.out.println("Специальных товаров нет");
        }
        if (counter == 0) {
            System.out.println("Корзина пуста!");
        }
    }

}




