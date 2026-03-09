public class Main {
    public static void main(String[] args) {
        Person p = new Person("Cường");
        p.setMe(p);
        System.out.println(p.getName());
        p = null;
    }
}

/*
1. Chỉ có 1 đối tượng Person tồn tại trên bộ nhớ.
2. Sau khi set p = null, đối tượng Person chưa bị xóa ngay khỏi bộ nhớ. GC có thuật toán để nhận diện được đối tượng mặc dù tự tham chiếu
đến chính nó nhưng không thể truy cập được nữa (không còn tham chiếu nào từ Stack tới nó nữa). GC sẽ chọn thời điểm thích hợp
và thông minh để loại bỏ Object rác này.
3. Đối tượng Person không thể được truy cập lại nữa, kể cả có biết/ ghi lại địa chỉ bộ nhớ của đối tượng Person trước khi set 
p = null, vì Java không có một phương thức hay cách nào để gán địa chỉ ô nhớ cho tham chiếu như các ngôn ngữ lập trình bậc thấp.
4. 
Trước khi set p = null:

STACK                          HEAP (vùng nhớ heap)
    +----------------+             +----------------------------------+
    |                |             |                                  |
    |  p: 0x101  ----|------------>|   [ Đối tượng Person @0x101 ]    |
    |                |             |  +----------------------------+  |
    +----------------+             |  | - name: "Cường"            |  |
                                   |  | - me: 0x101  --------------|--+
                                   |  +---------|------------------+  |
                                   |            | (tự tham chiếu)     |
                                   |            +---------------------+
                                   |                                  |
                                   +----------------------------------+

Sau khi set p = null:

STACK                          HEAP (vùng nhớ heap)
    +----------------+             +----------------------------------+
    |                |             |         (Đảo cô lập)             |
    |  p: null       |      X      |   [ Đối tượng Person @0x101 ]    |
    |                |    (Cắt)    |  +----------------------------+  |
    +----------------+             |  | - name: "Cường"            |  |
                                   |  | - me: 0x101  --------------|--+
                                   |  +---------|------------------+  |
                                   |            | (vẫn trỏ chính nó)  |
                                   |            +---------------------+
                                   |                                  |
                                   +----------------------------------+
                                     ^
                                     |
                          [ ĐỐI TƯỢNG RÁC - GC sẽ biết để dọn dẹp nó ]

 */