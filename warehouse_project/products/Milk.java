package products;

public class Milk extends Food {
    public Milk(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private Milk(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new Milk(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}