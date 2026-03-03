public class Employee {
    private String name;
    private MyDate birthday;
    
    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(Employee other) {
        //this.name = other.name;                    LỖI: Shallow Copy!.
        //this.birthday = other.birthday;
        this.name = other.name;
        this.birthday = new MyDate(other.birthday.getDay(),other.birthday.getMonth(),other.birthday.getYear());

    }
    @Override
    public String toString() {
        return "Nhân viên: " + name + " | Ngày sinh: " + birthday;
    }
}