public class Employee {
    protected String name;
    protected double baseSalary;

    public double calculateBonus() {
        return 0.1*baseSalary;
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
}

class Developer extends Employee {
    protected int overtimeHours;
    protected static final int OVERTIME_BONUS = 200000;

    @Override
    public double calculateBonus() {
        return 0.1*baseSalary+(overtimeHours*OVERTIME_BONUS);
    }

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
}

class Tester extends Employee {
    protected int bugsFound;
    protected static final int BUGSFOUND_REWARD = 50000;

    @Override
    public double calculateBonus() {
        return 0.1*baseSalary+(bugsFound*BUGSFOUND_REWARD);
    }

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }
}