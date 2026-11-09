package products;

public class Laptop extends Electronics {
    public Laptop(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private Laptop(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new Laptop(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}