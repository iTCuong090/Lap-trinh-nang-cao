# Lập trình nâng cao - VNU-UET

Chào mừng đến với repository của tôi! Đây là nơi lưu trữ toàn bộ quá trình học tập, thực hành và làm bài tập môn **Lập trình nâng cao (Advanced Programming)** tại Trường Đại học Công nghệ, Đại học Quốc gia Hà Nội (VNU-UET).

## Thông tin sinh viên
- **Họ và tên:** Tạ Hữu Cường
- **Mã sinh viên:** 25020053
- **Trường:** VNU-UET (Đại học Công nghệ - ĐHQGHN)

## Cấu trúc dự án
Dự án được tổ chức gọn gàng theo từng tuần học, bao gồm các thư mục bài tập và đề bài học liệu tương ứng:

```text
Lap-trinh-nang-cao
 ┣ 📂 Đề_bài/                 # Nơi lưu trữ file học liệu từ môn học (Java & OOP, Đa hình, Lớp trừu tượng...)
 ┣ 📂 Tuan1/                  # Thư mục chứa các bài tập Tuần 1
 ┃ ┣ 📂 Bai1.1/               # Cấu trúc của từng bài tập con
 ┃ ┃ ┣ 📂 src/                # Mã nguồn Java (.java) của bài
 ┃ ┃ ┗ 📜 run.sh              # Script hỗ trợ biên dịch và chạy code tự động
 ┃ ┣ 📂 Bai1.2/
 ┃ ┗ ...
 ┣ 📂 Tuan2/                  # Thư mục chứa các bài tập Tuần 2
 ┣ 📂 Tuan3/                  # Thư mục chứa các bài tập Tuần 3
 ┣ 📂 Tuan4/                  # Thư mục chứa các bài tập Tuần 4
 ┣ 📂 HelloWorld/             # Chương trình đầu tiên vỡ lòng với Java
 ┣ 📜 README.md               # File giới thiệu dự án bạn đang đọc
 ┣ 📜 deleteBuilds.sh         # Script dọn dẹp các tệp tin .class và thư mục build/ sau khi chạy
 ┣ 📜 open-git-bash-here.bat  # Công cụ mở nhanh Git Bash ngay tại thư mục hiện tại (Windows)
 ┗ 📜 .gitignore              # Cấu hình bỏ qua các tệp tin không cần thiết đưa lên Git
```

## Hướng dẫn cách biên dịch và chạy bài tập từng bài bằng Terminal

Để tiện lợi và không cần phải mở toàn bộ các IDE nặng nề (như IntelliJ hay Eclipse) mỗi khi xem lại cấu trúc code bài cũ, dự án đã thiết lập quy trình để có thể **chạy trực tiếp bằng Terminal**. Cụ thể là thông qua công cụ bash shell.

**Môi trường yêu cầu:** Giả định bạn đang sử dụng Windows, hãy thiết lập và cài đặt [Git Bash](https://gitforwindows.org/) trước khi thao tác.

### Các bước thực hiện:

1. **Mở Terminal tại thư mục chứa bài tập:** Bạn có thể đi tới thư mục gốc của repository, nhấn đúp chuột vào tập tin `open-git-bash-here.bat` để nhanh chóng gọi cửa sổ Git Bash. 
2. **Di chuyển vào thư mục bài tập nào bạn cần chạy:**
   Ví dụ, để chạy và xem kết quả giải Bài 1.1 trong Tuần 1, sử dụng lệnh:
   ```bash
   cd Tuan1/Bai1.1
   ```
3. **Thực thi script `run.sh` để bắt đầu tự động biên dịch và chạy:**
   ```bash
   ./run.sh
   # hoặc: bash run.sh
   ```

### Sự tiện ích của `run.sh`:
- **Tự động tìm kiếm mã nguồn:** Script tự đi vào mục `src/`, gom các file `.java` lại để chuẩn bị đóng gói.
- **Tự động tạo không gian Build:** Mã nguồn sau khi bị dịch thành `.class` sẽ nằm ngăn nắp trong một thư mục tên là `build/` tự tạo ra, để không lẫn với mã nguồn `src/`.
- **Hỗ trợ Tiếng Việt 100% trên Windows:** Cấu hình chuẩn lại Encoding UTF-8 (`chcp.com 65001`), hiển thị chính xác mọi lỗi cũng như kết quả Terminal in ra của Tiếng Việt.
- **Phát hiện class `main` thông minh:** Script sẽ quét thư mục `src`. Nếu có đúng 1 hàm `public static void main`, nó sẽ chạy ngay lập tức. Nếu có NHIỀU file chứa hàm `main` khác nhau, nó sẽ liệt kê danh sách trên Terminal để bạn **gõ một con số chọn class** bạn muốn!

## Dọn dẹp Workspace
Quá trình build và chạy liên tục sẽ sinh ra rất nhiều file `.class` hoặc các thư mục `build/` sinh rác bộ nhớ ổ cứng. Đây cũng là một nhược điểm nếu như bạn muốn zip nhanh thư mục dự án này để nộp bài hoặc chia sẻ mà không muốn kèm rác biên dịch:

**Giải pháp:** 
Khi đứng ở Terminal tại **thư mục gốc của repository**, chạy lệnh sau:
```bash
./deleteBuilds.sh
```
Script sẽ lướt nhanh toàn bộ dự án này, tìm kiếm sâu bên trong và dọn dẹp không để lại các thư mục `build/`, `target/` cũng như toàn bộ các tập con `.class` đang trôi nổi!

---
*Hy vọng Repository nhỏ này là một hành trang tốt cho bất cứ ai tham khảo về môn học hoặc tiếp lửa cho những đam mê đối tượng Lập trình OOP bằng Java. Chúc bạn có một ngày làm việc tuyệt vời! *
