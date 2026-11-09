package factories;

import products.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(String name, int price, int quantity, double weight);
}
