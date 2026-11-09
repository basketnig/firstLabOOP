package products;

public class TShirt extends Clothing {
    public TShirt(String name, int price, int qty, double w) { super(name, price, qty, w); }
    private TShirt(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w); }

    @Override
    public Product clone() {
        return new TShirt(getId(), getName(), getPrice().getValue(), getQuantity().getValue(), getWeight().getValue());
    }
}
