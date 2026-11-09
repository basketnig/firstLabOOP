package factories;

import products.Product;
import products.Laptop;

public class LaptopFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new Laptop(name, price, qty, weight);
    }
}
