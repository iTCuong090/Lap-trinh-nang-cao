#!/bin/bash

# Vô hiệu hóa History Expansion để dùng được dấu ! trong chuỗi
set +H

# ==========================================================
# CẤU HÌNH HIỂN THỊ 
# ==========================================================
# 1. Chỉnh Code Page sang UTF-8 và ẩn thông báo
chcp.com 65001 > /dev/null 2>&1

# 2. Thiết lập biến môi trường UTF-8
export LANG="en_US.UTF-8"
export LC_ALL="en_US.UTF-8"

# ==========================================================
# THIẾT LẬP ĐƯỜNG DẪN
# ==========================================================
SRC_DIR="src"
BUILD_DIR="build"

# Clean: Dọn dẹp build cũ mà không báo lỗi nếu thư mục trống
if [ -d "$BUILD_DIR" ]; then
    rm -rf "$BUILD_DIR"/*
else
    mkdir -p "$BUILD_DIR"
fi

# 3. Biên dịch (Hỗ trợ tiếng Việt)
# Dùng 2> /dev/null nếu muốn silent hoàn toàn, nhưng nên để hiện lỗi biên dịch nếu có
find "$SRC_DIR" -name "*.java" > sources.txt

if [ ! -s sources.txt ]; then
    echo "Không tìm thấy file .java nào trong src!"
    rm -f sources.txt
    read -n 1 -s -r -p ""
    exit 1
fi

javac -encoding UTF-8 -d "$BUILD_DIR" @sources.txt
if [ $? -ne 0 ]; then
    echo "Lỗi biên dịch!"
    rm -f sources.txt
    read -n 1 -s -r -p ""
    exit 1
fi
rm -f sources.txt

# 4. Tìm các class có hàm main
mapfile -t MAIN_CLASSES < <(grep -rl "public static void main" "$SRC_DIR" | sed "s|^$SRC_DIR/||; s|\.java$||; s|/|.|g" | sed "s|^\.||")
COUNT=${#MAIN_CLASSES[@]}

if [ "$COUNT" -eq 0 ]; then
    echo "Không tìm thấy hàm main nào trong src!"
    read -n 1 -s -r -p ""
    exit 1
elif [ "$COUNT" -eq 1 ]; then
    SELECTED_CLASS=${MAIN_CLASSES[0]}
else
    echo "Tìm thấy nhiều class!, vui lòng chọn class để chạy (Tìm thấy $COUNT file): "
    for i in "${!MAIN_CLASSES[@]}"; do
        echo "   $((i+1)). ${MAIN_CLASSES[$i]}"
    done
    while true; do
        read -p "Chọn số (1-$COUNT): " CHOICE
        if [[ "$CHOICE" =~ ^[0-9]+$ ]] && [ "$CHOICE" -ge 1 ] && [ "$CHOICE" -le "$COUNT" ]; then
            SELECTED_CLASS=${MAIN_CLASSES[$((CHOICE-1))]}
            break
        fi
    done
fi

# 5. Thực thi (Silent hơn bằng cách không in dòng "Đang khởi chạy")
java -Dfile.encoding=UTF-8 -Dconsole.encoding=UTF-8 -cp "$BUILD_DIR" "$SELECTED_CLASS"

# 6. Tạm dừng để xem kết quả (Pause hoàn toàn silent)
read -n 1 -s -r -p ""