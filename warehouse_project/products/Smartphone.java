package products;

public class Smartphone extends Electronics {
    public Smartphone(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private Smartphone(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new Smartphone(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}
