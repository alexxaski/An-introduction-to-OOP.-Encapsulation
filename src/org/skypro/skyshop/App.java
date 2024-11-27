package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Product;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class App {



    public static void main(String[] args) {
     /*   ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Молоко", 53));
        basket.addProduct(new SimpleProduct("Хлеб", 32));
        basket.addProduct(new SimpleProduct("Печенье", 29));
        basket.addProduct(new SimpleProduct("Сыр", 234));
        basket.addProduct(new SimpleProduct("Колбаса", 129));
        //basket.countingSpecialItems();
        System.out.println("Общая стоимость корзины: " + basket.calculateBasketCost() + " рублей");

        basket.containsProduct("Пиво");
        basket.containsProduct("Молоко");
        basket.clearBasket();

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(new SimpleProduct("помидоры", 98));
        basket1.addProduct(new SimpleProduct("огурцы", 65));
        basket1.addProduct(new FixPriceProduct("лук"));
        basket1.addProduct(new DiscountedProduct("майонез", 120, 10));
        basket1.addProduct(new SimpleProduct("соль", 32));

        basket1.countingSpecialItems();
        System.out.println("Общая стоимость корзины: " + basket1.calculateBasketCost() + " рублей.");


        basket1.clearBasket();

        basket1.addProduct(new SimpleProduct("салат", 112));
*/

        Product product1 = new SimpleProduct("Milk",1);
        Product product2 = new SimpleProduct("Bread",2);
        Product product3 = new SimpleProduct("Cheese",3);

        Article article1 = new Article("New Recipe", "Delicious dish recipe");
        Article article2 = new Article("Healthy Eating", "Tips for a healthy diet");

        Stack<Searchable> searchEngine = new Stack<>();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        Searchable[] searchResults = searchEngine.toArray(new Searchable[0]);
        System.out.println("Search Results:");
        System.out.println(Arrays.toString(searchResults));
/*Нужна помощь и прям с объяснениями , работают не все выводы
и такое чувство ,что че то я не понял от слова совсем.
 */
    }
}