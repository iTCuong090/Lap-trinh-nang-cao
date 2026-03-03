/*
public class BankAccount {
 private String accountNumber;
 private String ownerName;
 private double balance = 0.0;
 public void openAccount(String accNum, String owner) {
 this.accountNumber = accNum;
 this.ownerName = owner;
 }
 public void deposit(double amount) {
 this.balance += amount;
 }
 public boolean withdraw(double amount) {
 if (this.balance >= amount) {
 this.balance -= amount;
 return true;
 }
 return false;
 }
 public static void main(String[] args) {
 BankAccount myAccount = new BankAccount();
 myAccount.openAccount("101202303", "Nguyen Van A");
 myAccount.deposit(500.0);
 myAccount.withdraw(150.0);
 }
}

Trạng thái: 
 private String accountNumber;
 private String ownerName;
 private double balance = 0.0;

Hành vi:
 public void openAccount(String accNum, String owner) {
 this.accountNumber = accNum;
 this.ownerName = owner;
 }
 public void deposit(double amount) {
 this.balance += amount;
 }
 public boolean withdraw(double amount) {
 if (this.balance >= amount) {
 this.balance -= amount;
 return true;
 }
 return false;
 }

Định danh: 
 myAccount


*/

/*
public class SmartFan {
 private String brand = "Xiaomi";
 private boolean isPowerOn = false;
 private int speedLevel = 0; // Mức từ 1 đến 3
 public void turnOn() {
 this.isPowerOn = true;
 }
 public void turnOff() {
 this.isPowerOn = false;
 this.speedLevel = 0;
 }
 public void setSpeed(int newSpeed) {
 // Chỉ đổi tốc độ nếu quạt đang bật
 if (this.isPowerOn == true) {
 this.speedLevel = newSpeed;
 }
 }
 public static void main(String[] args) {
 SmartFan livingRoomFan = new SmartFan();
 livingRoomFan.turnOn();
 livingRoomFan.setSpeed(2);
 SmartFan bedroomFan = new SmartFan();
 bedroomFan.setSpeed(3);
 bedroomFan.turnOn();
 }
}

Trạng thái:
 private String brand = "Xiaomi";
 private boolean isPowerOn = false;
 private int speedLevel = 0; // Mức từ 1 đến 3
Hành vi:
 public void turnOn() {
 this.isPowerOn = true;
 }
 public void turnOff() {
 this.isPowerOn = false;
 this.speedLevel = 0;
 }
 public void setSpeed(int newSpeed) {
 // Chỉ đổi tốc độ nếu quạt đang bật
 if (this.isPowerOn == true) {
 this.speedLevel = newSpeed;
 }
 }
Định danh:
 SmartFan 
 livingRoomFan
*/