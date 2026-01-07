# THỰC HÀNH KIỂM THỬ PHẦN MỀM

## Thông tin sinh viên
- **Họ và tên**: Chu Mạnh Cường
- **Mã sinh viên**: BIT230065
- **Lớp**: 23IT6
- **SĐT**: 0962051934
- **Gmail**: cmcuongwork@gamil.com
## 📌 Giới thiệu
Repository này được sử dụng để lưu trữ **toàn bộ bài tập thực hành** của môn **Kiểm thử phần mềm**.  
Mục tiêu của các bài thực hành là giúp sinh viên:

- Làm quen và sử dụng thành thạo các **công cụ kiểm thử phổ biến**
- Thực hành **viết tài liệu kiểm thử**, báo cáo lỗi
- Vận dụng kiến thức vào **dự án nhóm**
- Tiếp cận các **công cụ kiểm thử hiện đại**, bao gồm các công cụ có tích hợp **mô hình ngôn ngữ lớn (LLM)**

Các bài thực hành **không bắt buộc bám sát lý thuyết từng chương**, tập trung vào kỹ năng thực tế.

---

## 🛠️ Các công cụ kiểm thử được sử dụng
Trong suốt học phần, sinh viên sẽ thực hành với các công cụ sau:

- **Kiểm thử đơn vị**: JUnit  
- **Kiểm thử tích hợp / API**: Postman  
- **Kiểm thử giao diện (UI Testing)**: Cypress / Playwright  
- **Kiểm thử hiệu năng**: JMeter / k6  
- **Kiểm thử an toàn**: OWASP ZAP Proxy  
- **Kiểm thử tĩnh mã nguồn**: SonarQube  
- **Quản lý lỗi & công việc**: GitHub Issues / Jira  
- **Tài liệu & báo cáo**: Test Plan, Test Case, Test Report  

Ngoài ra, nhóm sẽ **tự tìm hiểu và áp dụng ít nhất một công cụ kiểm thử có sử dụng mô hình ngôn ngữ lớn (LLM)** để cập nhật các xu hướng kiểm thử hiện đại.

------------------------------------------------

## 📅 BÀI THỰC HÀNH TUẦN 1  
### 🎯 Trải nghiệm và đánh giá chất lượng giao diện phần mềm

### 1. Mục tiêu
- Trải nghiệm trực tiếp chất lượng giao diện người dùng (UI/UX)
- Nhận biết các vấn đề liên quan đến:
  - Màu sắc
  - Độ tương phản
  - Khoảng cách
  - Khả năng quan sát và phân biệt
- Làm quen với tư duy **kiểm thử giao diện**

---

### 2. Công cụ sử dụng
- Website đánh giá UI/UX:  
  👉 https://cantunsee.space/

---

### 3. Kết quả đạt được
- **Tên bài test**: Can't Unsee  
- **Điểm số**: **7830**
- **Xếp hạng**: **Gold (Top 10%)**
- **Thời gian hoàn thành**: ~09 phút

📸 Ảnh chụp kết quả có kèm **dấu hiệu cá nhân (đăng nhập trình duyệt)** đã được lưu tại: Cantunsee.png
### 4. Nhận xét & đánh giá
- Bài test giúp rèn luyện khả năng phát hiện **lỗi giao diện nhỏ nhưng ảnh hưởng lớn đến trải nghiệm người dùng**
- Các lỗi thường gặp:
  - Sai lệch căn lề
  - Khoảng cách không đồng đều
  - Màu sắc khó phân biệt
- Công cụ đơn giản nhưng hiệu quả trong việc **nâng cao tư duy kiểm thử UI**

------------------------------------------------

## Bài tập thực hành kiểm thử với JUnit  
**Chủ đề**: Phân tích dữ liệu điểm số học sinh

---

### 🎯 1. Mục tiêu
- Biết cách viết **kiểm thử tự động (Unit Test)** bằng **JUnit**
- Áp dụng kiểm thử đơn vị cho các hàm xử lý dữ liệu
- Biết cách **khai thác AI tạo sinh** để hỗ trợ:
  - Viết mã nguồn
  - Gợi ý test case
  - Kiểm tra logic chương trình

---

### 📌 2. Mô tả bài toán
Xây dựng chương trình Java dùng để **phân tích danh sách điểm số học sinh**.

Chương trình gồm lớp `StudentAnalyzer` với hai chức năng chính:
- Đếm số học sinh đạt loại **Giỏi** (điểm ≥ 8.0)
- Tính **điểm trung bình hợp lệ** của danh sách điểm

#### Yêu cầu xử lý:
- Chỉ chấp nhận điểm trong khoảng **0 đến 10**
- Bỏ qua các điểm:
  - Nhỏ hơn 0
  - Lớn hơn 10
- Nếu danh sách rỗng → trả về **0**

---

### ⚙️ 3. Công cụ sử dụng
- **Ngôn ngữ lập trình**: Java  
- **IDE**: IntelliJ IDEA  
- **Kiểm thử đơn vị**: JUnit 5  
- **Quản lý mã nguồn**: GitHub  
- **Quản lý công việc**: GitHub Issues  

---

### 📂 4. Cấu trúc thư mục
unit-test/
├── pom.xml
├── src/
│ ├── main/java/analyzer/StudentAnalyzer.java
│ └── test/java/analyzer/StudentAnalyzerTest.java

### 🧩 5. Mô tả chức năng

#### 🔹 Hàm `countExcellentStudents()`
- Đếm số học sinh có điểm **≥ 8.0**
- Bỏ qua các điểm không hợp lệ
- Trả về `0` nếu danh sách rỗng

#### 🔹 Hàm `calculateValidAverage()`
- Tính điểm trung bình các điểm hợp lệ (0–10)
- Không tính điểm sai dữ liệu
- Trả về `0` nếu không có điểm hợp lệ

---

### 🧪 6. Kiểm thử với JUnit
Các test case được xây dựng theo các nhóm:

#### ✔ Trường hợp bình thường
- Danh sách có cả điểm hợp lệ và không hợp lệ
- Danh sách toàn bộ điểm hợp lệ

#### ✔ Trường hợp biên
- Danh sách rỗng
- Danh sách chỉ chứa điểm 0 hoặc 10

#### ✔ Trường hợp dữ liệu sai
- Có điểm < 0
- Có điểm > 10

➡️ Kết quả: **Tất cả các test case đều chạy thành công (PASS)**.

---

### ▶️ 7. Hướng dẫn chạy chương trình và kiểm thử

#### Cách 1: Chạy bằng IntelliJ IDEA
1. Mở project `unit-test`
2. Chuột phải vào lớp `StudentAnalyzerTest`
3. Chọn **Run 'StudentAnalyzerTest'**
4. Quan sát kết quả kiểm thử

#### Cách 2: Chạy bằng Maven
Mở Terminal trong IntelliJ IDEA và chạy:
```bash
mvn test
