package products;

public abstract class Food extends Product {
    public Food(String name, int price, int qty, double w) { super(name, price, qty, w, "food"); }
    protected Food(int id, String name, int price, int qty, double w) { super(id, name, price, qty, w, "food"); }
}
