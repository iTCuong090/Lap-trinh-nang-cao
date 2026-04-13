Trong quá trình làm bài này, tôi đã chưa hiểu đề muốn chúng ta phải sử dụng mẫu thiết kế Factory Pattern.
Factory là một lớp cụ thể mà chỉ có nhiệm vụ chế tạo ra sản phẩm đặc biệt để ship về cho lớp khác sử dụng thôi.
Tôi đã mắc sai lầm như sau:
1. Tự tạo biến nhớ button và checkbox trong từng Factory window và Mac.
2. Hàm create thì gán biến nhớ của nó cho một nút mới.
3. Tôi phải tự viết thêm 1 hàm renderAll ở trong factory để gọi các nút bấm và checkbox render.
Hậu quả: khi tôi viết Macfactory, tôi đã phải copy-paste hoàn toàn WindowFactory dẫn đến việc mắc phải sai lầm DRY. Sau đó còn phải
đổi tên một đống biến nữa, rất lằng nhằng và mất thời gian.

Tuy nhiên tôi đã sửa lại: 
Factory chỉ có nhiệm vụ sản suất ra đối tượng để trả về thôi, còn chuyên môn render là của từng món hàng, từng sản phẩm. Việc Factory phải
quan tâm tới render sản phẩm là sai. Render hay không là nhiệm vụ của main (trong bài này.)

Tinh hoa cuối cùng của Abstract Factory là giúp Client (hàm main) tách biệt hoàn toàn khỏi các class cụ thể (WindowButton, MacButton). Nhờ gọi qua Interface (UIFactory, Button, Checkbox), main không còn phải bận tâm nó đang chạy trên hệ điều hành nào. Khi dự án mở rộng thêm các hệ điều hành mới trong tương lai, luồng xử lý chính của main sẽ không cần phải sửa đổi bất kỳ dòng logic nào."