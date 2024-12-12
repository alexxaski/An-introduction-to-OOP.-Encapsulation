package org.skypro.skyshop.product;
import org.skypro.skyshop.Searchable;

  public abstract class Product implements Searchable{
    public final String productName ;
   //protected    int price;
    public Product(String productName/*, int price*/ ){
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException
                    ("Название продукта не может быть пустым или содержать только пробелы.");
        }
        this.productName = productName;
      //  this.price = price;
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
    @Override
    public String getSearchTerm() {
        return productName;
    }
    @Override
    public String getContentType() {
        return "PRODUCT";
    }
    @Override
    public String getObjectName() {
        return productName;
    }
}
