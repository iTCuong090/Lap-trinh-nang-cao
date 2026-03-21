public interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable {
    private String id;
    private String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;  
    }

    public void setName(String name) {
        this.name = name;
    }

    //Không cần Implement getPaymentAmount() tại Abstract class Staff vì class Abstract được phép nợ Interfaces để cho lớp con trả.
}

class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours*hourlyRate;
    }
}

class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    @Override
    public double getPaymentAmount() {
        return quantity*pricePerItem;
    }

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getName() {
        return itemName;
    }
}