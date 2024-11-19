package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 50;

   public FixPriceProduct(String productName,int price ) {

       super(productName);

    }
        @Override
        public int getPrice () {
            return FIXED_PRICE;
        }

    @Override
    public boolean isSpecial() {
        return true;
    }

}