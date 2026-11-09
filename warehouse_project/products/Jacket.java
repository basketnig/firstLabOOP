package products;

public class Jacket extends Clothing {
    public Jacket(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private Jacket(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new Jacket(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}
