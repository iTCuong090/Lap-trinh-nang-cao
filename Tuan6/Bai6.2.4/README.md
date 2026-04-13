ISP:
Interface Segregation Principle: Chia nhỏ Interfacte, không để class phải Implement những thứ mà nó có thể không cần.

DIP:
Class cha không gọi class con và cũng không cần biết cụ thể về class con, cả 2 phụ thuộc vào abstraction.

Ví dụ trong bài: Chia nhỏ ra 2 interface là Audio Playable và Video Playable (ISP).

Việc sử dụng Interface trừu tượng làm biến ở trong MediaPlayer chính là DIP, class cha phụ thuộc vào abstraction thay vì 1 class con cụ thể nào.
