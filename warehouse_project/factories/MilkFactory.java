package factories;

import products.Product;
import products.Milk;

public class MilkFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new Milk(name, price, qty, weight);
    }
}
