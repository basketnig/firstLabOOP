
import attributes.Price;
import products.Product;
import factories.*;
import warehouse.Warehouse;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("сценарий 1");
            Warehouse mainWarehouse = new Warehouse(20);

            ProductFactory phoneFactory = new SmartphoneFactory();
            ProductFactory milkFactory = new MilkFactory();
            ProductFactory laptopFactory = new LaptopFactory();
            ProductFactory tShirtFactory = new TShirtFactory();
            ProductFactory jacketFactory = new JacketFactory();
            ProductFactory breadFactory = new BreadFactory();

            mainWarehouse.addProduct(phoneFactory.createProduct("iPhone 17", 100000, 15, 0.2));
            mainWarehouse.addProduct(milkFactory.createProduct("Молоко 3.2%", 70, 100, 1.0));
            mainWarehouse.addProduct(laptopFactory.createProduct("MacBook Air", 120000, 5, 1.2));
            mainWarehouse.addProduct(tShirtFactory.createProduct("Футболка Nike", 2500, 20, 0.15));
            mainWarehouse.addProduct(jacketFactory.createProduct("Кожанка HD", 20000, 10, 1.5));
            mainWarehouse.addProduct(breadFactory.createProduct("Батон Нарезной", 50, 100, 0.4));
            mainWarehouse.addProduct(tShirtFactory.createProduct("Футболка Diesel", 3000, 8, 0.2));

            for (Product p : mainWarehouse) {
                System.out.println(p);
            }

            System.out.println("\nсценарий 2");
            Warehouse secondWarehouse = mainWarehouse.clone();

            Product phoneInCopy = secondWarehouse.findById(1);
            if (phoneInCopy != null) {
                phoneInCopy.setPrice(new Price(80000));
                phoneInCopy.changeQuantity(-5);
            }

            Product shirtInCopy = secondWarehouse.findById(4);
            if (shirtInCopy != null) {
                shirtInCopy.changeQuantity(10);
            }

            Product breadInCopy = secondWarehouse.findById(6);
            if (breadInCopy != null) {
                breadInCopy.setPrice(new Price(60));
            }

            System.out.println("Оригинал (iPhone): " + mainWarehouse.findById(1));
            System.out.println("Копия (iPhone): " + secondWarehouse.findById(1));
            System.out.println("Оригинал (Футболка): " + mainWarehouse.findById(4));
            System.out.println("Копия (Футболка): " + secondWarehouse.findById(4));
            System.out.println("Оригинал (Батон): " + mainWarehouse.findById(6));
            System.out.println("Копия (Батон): " + secondWarehouse.findById(6));

            System.out.println("\nсценарий 3");
            System.out.println("Поиск категории 'clothing':");
            Iterator<Product> clothingIterator = mainWarehouse.filterByCategory("clothing");
            while (clothingIterator.hasNext()) {
                System.out.println("Найден: " + clothingIterator.next().getName());
            }

            System.out.println("\nПоиск товаров с ценой 100000 руб:");
            Iterator<Product> priceIterator = mainWarehouse.filterByPrice(new Price(100000));
            while (priceIterator.hasNext()) {
                System.out.println("Найден: " + priceIterator.next().getName());
            }

            System.out.println("\nНаличие на главном складе:");
            for (Product p : mainWarehouse) {
                System.out.println(p.getName());
            }

            System.out.println("\nУдаление молока (ID 2) и товара по индексу 0 (iPhone)");
            mainWarehouse.removeById(2);
            mainWarehouse.removeByIndex(0);

            System.out.println("Остаток на главном складе:");
            for (Product p : mainWarehouse) {
                System.out.println(p.getName());
            }

            System.out.println("\nсценарий 4");
            Product laptop = laptopFactory.createProduct("MacBook Pro", 150000, 2, 1.5);
            mainWarehouse.addProduct(laptop);

            laptop.transferTo(secondWarehouse);
            mainWarehouse.removeById(laptop.getId());

            System.out.println("\nНаличие на главном складе:");
            for (Product p : mainWarehouse) {
                System.out.println(p.getName());
            }

            System.out.println("\nНаличие на скопированном складе:");
            for (Product p : secondWarehouse) {
                System.out.println(p.getName());
            }

            System.out.println("\nСкопировочный склад содержит MacBook Pro: " + (secondWarehouse.findById(laptop.getId()) != null));
            System.out.println("Главный склад не содержит MacBook Pro: " + (mainWarehouse.findById(laptop.getId()) == null));

        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

        System.out.println("\nперехват исключений\n");

        try {
            System.out.print("создание товара с ценой < 0\n");
            ProductFactory factory = new SmartphoneFactory();
            Product invalidProduct = factory.createProduct("Б", -500, 1, 0.1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }

        try {
            System.out.print("переполнение склада\n");
            Warehouse tinyWarehouse = new Warehouse(1);
            ProductFactory factory = new SmartphoneFactory();
            tinyWarehouse.addProduct(factory.createProduct("тел 1", 100, 1, 0.1));
            tinyWarehouse.addProduct(factory.createProduct("тел 2", 100, 1, 0.1));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage() + "\n");
        }

        try {
            System.out.print("удаление товара по несуществующему индексу\n");
            Warehouse w = new Warehouse(5);
            w.removeByIndex(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + "\n");
        }

        try {
            System.out.print("убираем больше товаров чем есть\n");
            ProductFactory factory = new LaptopFactory();
            Product laptop = factory.createProduct("Ноутбук", 50000, 3, 2.0);
            laptop.changeQuantity(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
}