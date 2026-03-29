import java.util.ArrayList;
import java.util.List;

public abstract class Storage<T extends Product> {
    protected ArrayList<T> storage;

    public Storage() {
        storage = new ArrayList<T>();
    }

    public void add(T thing) {
        storage.add(thing);
    }

    public void remove(T thing) {
        storage.remove(thing);
    }

    public abstract void check();
}

abstract class Product {
    protected String id, name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Food extends Product {
    protected String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }
}

class Electric extends Product {
    protected int warrantyMonths;

    public Electric(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }
}

class FoodStorage extends Storage<Food> {

    @Override
    public void check() {
        for (Food x: storage) {
            System.out.println(x.name+" - "+x.expiryDate);
        }
    }
}

class ElectricStorage extends Storage<Electric> {

    @Override
    public void check() {
        for (Electric x: storage) {
            System.out.println(x.name+" - "+x.warrantyMonths+" tháng bảo hành");
        }
    }
}