package attributes;

public class Quantity {
    private int value;

    public Quantity(int value) { setValue(value); }

    public int getValue() { return value; }

    public void setValue(int value) {
        if (value < 0) throw new IllegalArgumentException("Количество не может быть отрицательным");
        this.value = value;
    }

    public void change(int delta) {
        if (this.value + delta < 0) throw new IllegalArgumentException("Остаток не может стать отрицательным");
        this.value += delta;
    }
}
