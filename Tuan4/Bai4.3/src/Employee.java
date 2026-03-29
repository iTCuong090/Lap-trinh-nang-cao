interface IWorkable {
    void work();
}

public abstract class Employee implements IWorkable {
    public final String id, name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();

    //Không cần Implements work() vì Employee là abstract.
}

class OfficeWorker extends Employee {
    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }

    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }
}

class Technician extends Employee {
    protected int overtimeHours;
    protected static int OVERTIME_BONUS = 20000;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    } 

    @Override
    public double calculatePay() {
        return baseSalary+overtimeHours*OVERTIME_BONUS;
    }

    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}