package factories;

import products.Product;
import products.Smartphone;

public class SmartphoneFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new Smartphone(name, price, qty, weight);
    }
}
