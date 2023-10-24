package seminars.first.hw.Shop;

public class Product {
    private Product nullProduct;
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, Integer cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product getNullProduct() {
        return nullProduct;
    }

    public void setNullProduct(Product product) {
        this.nullProduct = product;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}