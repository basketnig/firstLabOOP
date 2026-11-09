package factories;

import products.Product;
import products.Jacket;

public class JacketFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new Jacket(name, price, qty, weight);
    }
}
