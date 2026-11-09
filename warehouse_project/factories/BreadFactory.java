package factories;

import products.Product;
import products.Bread;

public class BreadFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new Bread(name, price, qty, weight);
    }
}
