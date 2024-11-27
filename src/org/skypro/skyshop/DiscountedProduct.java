package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {

    private int basePrice; // Базовая цена
    private int discountPercentage; // Скидка в процентах

    public DiscountedProduct(String productName, int basePrice, int discountPercentage) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }
   @Override
    public int getPrice() {
        return basePrice - (basePrice * discountPercentage / 100);
    }
    @Override
    public boolean isSpecial() {
        return true; // Простой товар не является специальным
    }

    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }

    }


