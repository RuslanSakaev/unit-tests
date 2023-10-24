package seminars.first.hw.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;
    private static final Product nullProduct = new Product("No Product", 0);


    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return nullProduct;
        }

        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensive.getCost()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }

}