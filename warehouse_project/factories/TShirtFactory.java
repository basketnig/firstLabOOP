package factories;

import products.Product;
import products.TShirt;

public class TShirtFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, int price, int qty, double weight) {
        return new TShirt(name, price, qty, weight);
    }
}
