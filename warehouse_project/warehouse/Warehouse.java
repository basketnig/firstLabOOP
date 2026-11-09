package warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import products.Product;
import attributes.Price;

public class Warehouse implements Iterable<Product>, Cloneable {
    private List<Product> products;
    private final int maxSize;

    public Warehouse(int maxSize) {
        if (maxSize <= 0) throw new IllegalArgumentException("Размер склада должен быть > 0");
        this.maxSize = maxSize;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (products.size() >= maxSize) throw new IllegalStateException("Склад переполнен");
        products.add(product);
    }

    public void removeById(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public void removeByIndex(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public Warehouse clone() {
        try {
            Warehouse cloned = (Warehouse) super.clone();
            cloned.products = new ArrayList<>();
            for (Product p : this.products) {
                cloned.products.add(p.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public Iterator<Product> iterator() {
        return new WarehouseIterator();
    }

    public Iterator<Product> filterByCategory(String category) {
        return new CategoryFilterIterator(category);
    }

    public Iterator<Product> filterByPrice(Price targetPrice) {
        return new PriceFilterIterator(targetPrice);
    }

    private class WarehouseIterator implements Iterator<Product> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() { return currentIndex < products.size(); }

        @Override
        public Product next() {
            if (!hasNext()) throw new NoSuchElementException();
            return products.get(currentIndex++);
        }
    }

    private class CategoryFilterIterator implements Iterator<Product> {
        private int index = 0;
        private String category;

        public CategoryFilterIterator(String category) {
            this.category = category;
            advanceToNextValid();
        }

        private void advanceToNextValid() {
            while (index < products.size() && !products.get(index).getCategory().equals(category)) {
                index++;
            }
        }

        @Override
        public boolean hasNext() { return index < products.size(); }

        @Override
        public Product next() {
            if (!hasNext()) throw new NoSuchElementException();
            Product p = products.get(index);
            index++;
            advanceToNextValid();
            return p;
        }
    }

    private class PriceFilterIterator implements Iterator<Product> {
        private int index = 0;
        private Price targetPrice;

        public PriceFilterIterator(Price targetPrice) {
            this.targetPrice = targetPrice;
            advanceToNextValid();
        }

        private void advanceToNextValid() {
            while (index < products.size() && products.get(index).getPrice().getValue() != targetPrice.getValue()) {
                index++;
            }
        }

        @Override
        public boolean hasNext() { return index < products.size(); }

        @Override
        public Product next() {
            if (!hasNext()) throw new NoSuchElementException();
            Product p = products.get(index);
            index++;
            advanceToNextValid();
            return p;
        }
    }
}
