Ở trong bài tập này, hàm main giống như 1 report controller vậy. Nó tự quyết định loại Formatter và giao việc cho ReportService làm việc
với thằng Formatter đó. Như vậy ReportService chỉ biết mình làm việc với Formatter, không cần ôm luôn việc của formatter nữa.

Đúng với tiêu chí SIngle Responsible Principle và Open-Close Principle. 
Open-close được thể hiện ở chỗ: Ta có thể thêm nhiều loại Formatter nữa một cahs dễ dàng mà không cần thay đổi code của ReportService. CHỉ cần
thay đổi code ở Controller và viết thêm chính cái Formatter đó thôi.