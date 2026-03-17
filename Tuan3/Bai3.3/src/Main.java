public class Main {
    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5, 5)); // (A)
        //System.out.println(m.sum(5.5, 5.5)); // (B) -> Dòng này có lỗi không?
    }
}

//Dòng A chạy ra 20 vì m là đối tượng lớp AdvanceMath, phương thức sum trong đó bị ghi đè thành a+b+10=5+5+10=20.
//
//Khi bỏ comment dòng B, biên dịch bị lỗi. Lí do là vì Overload là đa hình trong lúc biên dịch. Còn Override là đa hình trong lúc chạy.
//Tức là Override sẽ được thực thi trong quá trình chạy chương trình, dựa vào điều kiện class hiện tại của đối tượng. 
//Trong trường hợp trên, tham chiếu m được khai báo kiểu MathUtils nhưng lại tham chiếu tới 1 đối tượng thuộc lớp con là 
//AdvanceMath. Vì AdvanceMath là lớp con của MathUtils nên không báo lỗi biên dịch.
//Khi chạy thực tế, trình biên dịch nhìn thấy tham chiếu m trỏ vào đối tượng lớp AdvanceMath nên gọi method được override.
//Khi biên dịch, trình biên dịch nhìn vào kiểu tham chiếu của m để quyết định hàm gọi nó. m là MathUtils, mà lớp này không có hàm
//sum nào nhận vào 2 số thực để overload dẫn đến lỗi kiểu dữ liệu, gây lỗi biên dịch.

//Tóm lại:
//Override: Java "hỏi object thực tế" khi chạy → override kế thừa

//Overload: Java "nhìn reference type" khi biên dịch → Không thấy hàm nào phù hợp -> Lỗi.