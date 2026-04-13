Tại sao phải dùng Abstract Factory method mà không viết các app EmailNotify và SMSNotify rời rạc?
Vì để tái sử dụng code.
Giả sử hàm notifyUser rất phức tạp, có 10 bước thực hiện trước khi đẩy thông báo tới cho user thông qua các kênh email và sms.
Nếu viết 2 class rời rạc, mỗi khi muốn sửa 10 bước đó lại phải sửa ở 2 vị trí là app email và app sms.
Nếu như viết như này, việc gửi msg như nào là do app con quyết định, 10 bước thực hiện đó chỉ cần quản lý ở abstract class cha là đủ.

Sau này muốn thêm các app như ZaloNotify, vv thì chỉ cần để zalo extends cái NotificationApp sau đó ghi đè hàm createNotification để tạo ra
notification kiểu Zalo là được.
