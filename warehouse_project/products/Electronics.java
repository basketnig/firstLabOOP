package products;

public abstract class Electronics extends Product {
    public Electronics(String name, int price, int qty, double w) { super(name, price, qty, w, "electronics"); }
    protected Electronics(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w, "electronics"); }
}