package attributes;

public class Weight {
    private double value;

    public Weight(double value) { setValue(value); }

    public double getValue() { return value; }

    public void setValue(double value) {
        if (value < 0) throw new IllegalArgumentException("Вес не может быть отрицательным");
        this.value = value;
    }
}
