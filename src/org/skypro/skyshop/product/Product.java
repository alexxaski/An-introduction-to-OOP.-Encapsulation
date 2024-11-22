package org.skypro.skyshop.product;

public abstract class Product {
    public final String productName ;
   protected    int price;

    public Product(String productName, int price ){
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }
    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return productName + '=' + getPrice() ;
    }

}
