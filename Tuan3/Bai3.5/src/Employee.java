public abstract class Employee {
    private String name;
    private String dob;
    private String id;

    public double getSalary() {
        return 0; //Employee nói chung thì không có lương.
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    @Override
    public double getSalary() {
        return baseSalary + (bonus - penalty);
    }

    public FullTimeEmployee(String name,double baseSalary, double bonus, double penalty) {
        super.setName(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
}

class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    @Override
    public double getSalary() {
        return workingHours*hourlyRate;
    }

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super.setName(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
}