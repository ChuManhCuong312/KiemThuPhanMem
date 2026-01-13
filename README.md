# THỰC HÀNH KIỂM THỬ PHẦN MỀM

## 1. Thông tin sinh viên
- Họ và tên: Chu Mạnh Cường  
- Mã sinh viên: BIT230065  
- Lớp: 23IT6  
- Số điện thoại: 0962051934  
- Email: cmcuongwork@gamil.com  

---

## 2. Giới thiệu
Repository này được sử dụng để lưu trữ **toàn bộ bài tập thực hành** của môn **Kiểm thử phần mềm**.

Mục tiêu của các bài thực hành bao gồm:
- Làm quen và sử dụng các **công cụ kiểm thử phần mềm phổ biến**
- Thực hành **viết tài liệu kiểm thử** và **báo cáo lỗi**
- Vận dụng kiến thức kiểm thử vào **bài tập cá nhân và dự án nhóm**
- Tiếp cận các **xu hướng kiểm thử hiện đại**, bao gồm việc ứng dụng **mô hình ngôn ngữ lớn (LLM)** trong kiểm thử

---

## 3. Các công cụ kiểm thử được sử dụng
Trong suốt học phần, sinh viên thực hành với các công cụ sau:

3.1. Kiểm thử đơn vị: JUnit  
3.2. Kiểm thử tích hợp / API: Postman  
3.3. Kiểm thử giao diện người dùng: Cypress, Playwright  
3.4. Kiểm thử hiệu năng: JMeter, k6  
3.5. Kiểm thử an toàn: OWASP ZAP Proxy  
3.6. Kiểm thử tĩnh mã nguồn: SonarQube  
3.7. Quản lý lỗi và công việc: GitHub Issues, Jira  
3.8. Tài liệu và báo cáo: Test Plan, Test Case, Test Report  

---

## 4. Bài thực hành tuần 1  
### 4.1. Trải nghiệm và đánh giá chất lượng giao diện phần mềm

#### 4.1.1. Mục tiêu
- Trải nghiệm chất lượng giao diện người dùng (UI/UX)
- Nhận diện các vấn đề liên quan đến:
  - Màu sắc
  - Độ tương phản
  - Khoảng cách
  - Khả năng quan sát và phân biệt
- Làm quen với tư duy **kiểm thử giao diện**

#### 4.1.2. Công cụ sử dụng
- Website đánh giá UI/UX: https://cantunsee.space/

#### 4.1.3. Kết quả đạt được
- Tên bài test: Can't Unsee  
- Điểm số: 7830  
- Xếp hạng: Gold (Top 10%)  
- Thời gian hoàn thành: khoảng 09 phút  

Ảnh chụp kết quả có kèm dấu hiệu cá nhân (đăng nhập trình duyệt) được lưu trong file `Cantunsee.png`.

#### 4.1.4. Nhận xét và đánh giá
- Bài test giúp rèn luyện khả năng phát hiện **các lỗi giao diện nhỏ nhưng ảnh hưởng lớn đến trải nghiệm người dùng**
- Một số lỗi thường gặp:
  - Sai lệch căn lề
  - Khoảng cách giữa các thành phần không đồng đều
  - Màu sắc khó phân biệt
- Công cụ có giao diện đơn giản nhưng mang lại hiệu quả cao trong việc **nâng cao tư duy kiểm thử UI**

---

## 5. Bài tập thực hành kiểm thử với JUnit  
### 5.1. Chủ đề: Phân tích dữ liệu điểm số học sinh

#### 5.1.1. Mục tiêu
- Nắm được cách viết **kiểm thử tự động (Unit Test)** bằng **JUnit**
- Áp dụng kiểm thử đơn vị cho các hàm xử lý dữ liệu
- Biết cách khai thác **AI tạo sinh** để:
  - Hỗ trợ viết mã nguồn
  - Gợi ý test case
  - Kiểm tra và phân tích logic chương trình

#### 5.1.2. Mô tả bài toán
Xây dựng chương trình Java dùng để **phân tích danh sách điểm số học sinh**.

Chương trình gồm lớp `StudentAnalyzer` với hai chức năng chính:
- Đếm số học sinh đạt loại **Giỏi** (điểm ≥ 8.0)
- Tính **điểm trung bình hợp lệ** của danh sách điểm

Yêu cầu xử lý dữ liệu:
- Chỉ chấp nhận điểm trong khoảng từ 0 đến 10
- Bỏ qua các điểm:
  - Nhỏ hơn 0
  - Lớn hơn 10
- Nếu danh sách rỗng, kết quả trả về là 0

#### 5.1.3. Công cụ sử dụng
- Ngôn ngữ lập trình: Java  
- IDE: IntelliJ IDEA  
- Thư viện kiểm thử: JUnit 5  
- Quản lý mã nguồn: GitHub  
- Quản lý công việc: GitHub Issues  

#### 5.1.4. Cấu trúc thư mục
/unit-test/
/├── pom.xml
/├── src/
/│ ├── main/java/analyzer/StudentAnalyzer.java
/│ └── test/java/analyzer/StudentAnalyzerTest.java


#### 5.1.5. Mô tả chức năng

5.1.5.1. Hàm `countExcellentStudents()`  
- Đếm số học sinh có điểm ≥ 8.0  
- Bỏ qua các điểm không hợp lệ  
- Trả về 0 nếu danh sách rỗng  

5.1.5.2. Hàm `calculateValidAverage()`  
- Tính điểm trung bình của các điểm hợp lệ (0–10)  
- Không tính các điểm sai dữ liệu  
- Trả về 0 nếu không có điểm hợp lệ  

#### 5.1.6. Kiểm thử với JUnit
Các test case được xây dựng theo các nhóm sau:

- Trường hợp bình thường:
  - Danh sách có cả điểm hợp lệ và không hợp lệ
  - Danh sách chỉ gồm các điểm hợp lệ
- Trường hợp biên:
  - Danh sách rỗng
  - Danh sách chỉ chứa điểm 0 hoặc 10
- Trường hợp dữ liệu sai:
  - Có điểm nhỏ hơn 0
  - Có điểm lớn hơn 10

Kết quả: **Tất cả các test case đều chạy thành công (PASS)**.

#### 5.1.7. Hướng dẫn chạy chương trình và kiểm thử

Cách 1: Chạy bằng IntelliJ IDEA  
1. Mở project `unit-test`  
2. Chuột phải vào lớp `StudentAnalyzerTest`  
3. Chọn `Run 'StudentAnalyzerTest'`  
4. Quan sát kết quả kiểm thử  

Cách 2: Chạy bằng Maven  
Mở Terminal trong IntelliJ IDEA và chạy:
```bash
mvn test
