package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

class SimpleProduct extends Product {
  private int price;

     public SimpleProduct(String productName, int price) {
         super(productName);
         this.price = price;
     }
     @Override
     public int getPrice() {
         return price;
     }
    @Override
    public boolean isSpecial() {
        return false;
    }
}
