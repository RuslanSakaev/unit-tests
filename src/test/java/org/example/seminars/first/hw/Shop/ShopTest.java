package org.example.seminars.first.hw.Shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {


    /*
    *Задание 2. (необязательное) *
    Мы хотим улучшить функциональность нашего интернет-магазина. Ваша задача - добавить два новых метода в класс Shop:
    Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
    Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
    Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
    Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
    Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
     */

    private Shop shop;
    private List<Product> products;
    private Product product;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
        products = new ArrayList<>();

        // Добавляем продукты для тестирования
        products.add(new Product("ProductA", 10));
        products.add(new Product("ProductB", 15));
        products.add(new Product("ProductC", 5));
        products.add(new Product("ProductD", 20));

        shop.setProducts(products);

        product = new Product("NullProduct", 0);
        product.setNullProduct(null);

    }

    @Test
    public void testShopStoresCorrectProducts() {
        assertNotNull(shop);
        List<Product> storedProducts = shop.getProducts();
        assertNotNull(storedProducts);
        assertEquals(products.size(), storedProducts.size());

        for (Product product : products) {
            assertTrue(storedProducts.contains(product));
        }

        assertNull(product.getNullProduct());
    }

    @Test
    public void testGetMostExpensiveProduct() {
        Product mostExpensive = shop.getMostExpensiveProduct();
        assertNotNull(mostExpensive);
        assertEquals("ProductD", mostExpensive.getTitle());
        assertEquals(Integer.valueOf(20), mostExpensive.getCost());
    }

    @Test
    public void testSortProductsByPrice() {
        List<Product> sortedProducts = shop.sortProductsByPrice();

        for (int i = 0; i < sortedProducts.size() - 1; i++) {
            assertTrue(sortedProducts.get(i).getCost() <= sortedProducts.get(i + 1).getCost());
        }
    }
}