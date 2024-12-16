package org.skypro.skyshop.basket;
import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.product.Product;
import java.util.Stack;

public class ProductBasket {
    private Product[] basket;
    private int counter;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(Product product) {
        if (counter >= basket.length) {
            throw new IndexOutOfBoundsException("Невозможно добавить продукт");
        }
        basket[counter++] = product;
        System.out.println(product);
    }

    public int calculateBasketCost() {
        int sum = 0;
        for (int i = 0; i < counter; i++) {
            sum += basket[i].getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (counter == 0) {
            System.out.println("Корзина пуста!");
            return;
        }
        int sum = 0;
        for (int i = 0; i < counter; i++) {
            System.out.println(basket[i]);
            sum += basket[i].getPrice();
        }
        System.out.println("Итого: " + sum);
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < counter; i++) {
            if (basket[i] != null && productName.equalsIgnoreCase(basket[i].getProductName())) {
                System.out.println("Этот товар есть в корзине");
                return true;
            }
        }
        System.out.println("Этого нет в корзине");
        return false;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины!");
        basket = new Product[basket.length];
    }

    public void countingSpecialItems() {
        int specialCount = 0;
        for (int i = 0; i < counter; i++) {
            if (basket[i] != null && basket[i].isSpecial()) {
                specialCount++;
                System.out.println(basket[i].getProductName() + ": " + basket[i].getPrice() + " (Специальный товар)");
            } else {
                System.out.println(basket[i]);
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

    public Searchable findMostSuitableItem(String search) throws BestResultNotFound {
        Searchable mostSuitable = null;
        int maxCount = 0;

        Stack<Searchable> searchEngine = new Stack<>();
        for (Product product : basket) {
            if (product != null) {
                searchEngine.add(product);
            }
        }

        for (Searchable searchable : searchEngine) {
            String searchTerm = searchable.getSearchTerm();
            int count = 0;
            int fromIndex = 0;

            while ((fromIndex = searchTerm.indexOf(search, fromIndex)) != -1) {
                count++;
                fromIndex += search.length();
            }

            if (count > maxCount) {
                maxCount = count;
                mostSuitable = searchable;
            }
        }

        if (mostSuitable == null) {
            throw new BestResultNotFound("Нет подходящего объекта для поискового запроса: " + search);
        }
        return mostSuitable;
    }
}
