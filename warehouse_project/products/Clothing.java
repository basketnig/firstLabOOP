package products;

public abstract class Clothing extends Product {
    public Clothing(String name, int price, int qty, double w) { super(name, price, qty, w, "clothing"); }
    protected Clothing(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w, "clothing"); }
}
