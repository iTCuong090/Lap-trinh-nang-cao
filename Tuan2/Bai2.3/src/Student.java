public class Student {
    private final String id;
    private String name;
    private String email;
    private double gpa;

    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gpa = gpa;
    }

    public Student(String id, String name) {
        this(id, name, "No Email", 0.0);
    }

    public Student() {
        this(null, null, null, 0.0);
    }

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }

    public void setGpa(double amount) {
        if (amount >= 0 && amount <= 4) {
            this.gpa = amount;
        }
        else {
            System.out.println("Lỗi: GPA phải >= 0 và <=4.");
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public double getGpa() {
        return this.gpa;
    }
}