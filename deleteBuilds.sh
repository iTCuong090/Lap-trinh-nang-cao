#!/bin/bash

# Thông báo bắt đầu quét
echo "--- Đang dọn dẹp các tệp tin và thư mục build Java... ---"

# 1. Xóa các thư mục build lớn (target của Maven, build của Gradle)
# Sử dụng -prune để không tìm kiếm bên trong thư mục đã bị xóa
find . -type d \( -name "target" -o -name "build" \) -prune -exec rm -rf {} +
echo "✔ Đã xóa các thư mục target/ và build/"

# 2. Xóa tất cả các file .class đơn lẻ trong toàn bộ thư mục con
# -type f: Chỉ tìm tệp tin (file)
# -name "*.class": Tìm các file có đuôi .class
find . -type f -name "*.class" -delete
echo "✔ Đã xóa tất cả các tệp .class"

echo "--- Hoàn tất! Không gian làm việc đã sạch sẽ. ---"