package products;

public class Bread extends Food {
    public Bread(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private Bread(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new Bread(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}
