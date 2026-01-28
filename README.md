<img width="1514" height="945" alt="summary3" src="https://github.com/user-attachments/assets/b1c2e282-456c-4695-8386-684405d3eb40" /># THỰC HÀNH KIỂM THỬ PHẦN MỀM

## 1. Thông tin sinh viên
- Họ và tên: Chu Mạnh Cường  
- Mã sinh viên: BIT230065  
- Lớp: 23IT6  
- Số điện thoại: 0962051934  
- Email: cmcuongwork@gmail.com  

---

## 2. Giới thiệu
Kho lưu trữ (Repository) này được sử dụng để lưu trữ **toàn bộ bài tập thực hành** của môn **Kiểm thử phần mềm**.

Mục tiêu của các bài thực hành bao gồm:
- Làm quen và sử dụng các **công cụ kiểm thử phần mềm phổ biến**
- Thực hành **viết tài liệu kiểm thử** và **báo cáo lỗi**
- Vận dụng kiến thức kiểm thử vào **bài tập cá nhân và dự án nhóm**
- Tiếp cận các **xu hướng kiểm thử hiện đại**, bao gồm việc ứng dụng **mô hình ngôn ngữ lớn (LLM)** trong kiểm thử

---

## 3. Các công cụ kiểm thử được sử dụng
3.1. Kiểm thử đơn vị: JUnit  
3.2. Kiểm thử tích hợp / API: Postman  
3.3. Kiểm thử giao diện người dùng: Cypress, Playwright  
3.4. Kiểm thử hiệu năng: JMeter, k6  
3.5. Kiểm thử an toàn: OWASP ZAP Proxy  
3.6. Kiểm thử tĩnh mã nguồn: SonarQube  
3.7. Quản lý lỗi và công việc: GitHub Issues, Jira  
3.8. Tài liệu và báo cáo: kế hoạch kiểm thử (test plan), trường hợp kiểm thử (test case), báo cáo kiểm thử (test report)  

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
- Trang Web đánh giá UI/UX: https://cantunsee.space/

#### 4.1.3. Kết quả đạt được
- Tên bài kiểm tratra: Can't Unsee  
- Điểm số: 7330  
- Xếp hạng: Gold (Top 10%)  
- Thời gian hoàn thành: khoảng 09 phút  

Ảnh chụp kết quả có kèm dấu hiệu cá nhân (đăng nhập trình duyệt) được lưu trong tài liệu `Cantunsee.png`.
<img width="1918" height="1199" alt="image" src="https://github.com/user-attachments/assets/0d320156-09e6-47d6-bd82-7db9f94247ed" />


#### 4.1.4. Nhận xét và đánh giá
- Bài kiểm tra giúp rèn luyện khả năng phát hiện **các lỗi giao diện nhỏ nhưng ảnh hưởng lớn đến trải nghiệm người dùng**
- Một số lỗi thường gặp:
  - Sai lệch căn lề
  - Khoảng cách giữa các thành phần không đồng đều
  - Màu sắc khó phân biệt
- Công cụ có giao diện đơn giản nhưng mang lại hiệu quả cao trong việc **nâng cao tư duy kiểm thử UI**

---

## 5. Bài tập thực hành kiểm thử với JUnit  
### 5.1. Chủ đề: Phân tích dữ liệu điểm số học sinh

#### 5.1.1. Mục tiêu
- Nắm được cách viết **kiểm thử tự động (unit ttest)** bằng **JUnit**
- Áp dụng kiểm thử đơn vị cho các hàm xử lý dữ liệu
- Biết cách khai thác **AI tạo sinh** để:
  - Hỗ trợ viết mã nguồn
  - Gợi ý trường hợp kiểm thử (test case)
  - Kiểm tra và phân tích logic chương trình

#### 5.1.2. Mô tả bài toán
Xây dựng chương trình Java dùng để **phân tích danh sách điểm số học sinh**.

Chương trình gồm lớp `StudentAnalyzer` với hai chức năng chính:
- Đếm số học sinh đạt loại **Giỏi** (điểm ≥ 8.0)
- Tính **điểm trung bình hợp lệ** của danh sách điểm

Yêu cầu xử lý dữ liệu:
- Chỉ chấp nhận điểm trong khoảng từ 0 đến 10.
- Bỏ qua các điểm:
  - Nhỏ hơn 0.
  - Lớn hơn 10.
  - Giá trị null.
- Nếu danh sách rỗng hoặc null, kết quả trả về là 0.

#### 5.1.3. Công cụ sử dụng
- Ngôn ngữ lập trình: Java  
- IDE: IntelliJ IDEA  
- Thư viện kiểm thử: JUnit 5  
- Quản lý mã nguồn: GitHub  
- Quản lý công việc: GitHub Issues  

#### 5.1.4. Cấu trúc thư mục
```
/unit-test/
/├── pom.xml
/├── src/
/│ ├── main/java/analyzer/StudentAnalyzer.java
/│ └── test/java/analyzer/StudentAnalyzerTest.java
```

#### 5.1.5. Mô tả chức năng

5.1.5.1. Hàm `countExcellentStudents()`  
- Đếm số học sinh có điểm ≥ 8.0  
- Bỏ qua các điểm không hợp lệ (<0, >10, null) 
- Trả về 0 nếu danh sách rỗng hoặc null.

5.1.5.2. Hàm `calculateValidAverage()`  
- Tính điểm trung bình của các điểm hợp lệ (0–10)  
- Không tính các điểm sai dữ liệu (<0, >10, null)
- Trả về 0 nếu không có điểm hợp lệ  

#### 5.1.6. Kiểm thử với JUnit
Các trường hợp kiểm thử (test case) được xây dựng theo các nhóm sau:

- Kiểm thử hộp đen (Black-box Testing):
  - RP (Phân vùng tương đương):
    - Danh sách chỉ gồm các điểm hợp lệ
    - Danh sách chỉ có điểm không hợp lệ
    - Danh sách trộn hợp lệ – không hợp lệ – null
    - Danh sách rỗng
    - Danh sách null
  - BVA (Giá trị biên):
    - Điểm = 0
    - Điểm = 8.0
    - Điểm = 10
    - Điểm < 0
    - Điểm > 10
  - DT (Bảng quyết định):
    - Tất cả điểm đều hợp lệ.
    - Tất cả điểm đều giỏi.
    - Không có điểm giỏi.
    - Trộn: hợp lệ + không hợp lệ + null.
  
- Kiểm thử hộp trắng (White-box Testing)
  - CFG (Control Flow Graph):
    - Bao phủ nhánh:
    - scores == null
    - scores.isEmpty()
    - score == null
    - score < 0 || score > 10
    - score >= 8
    - validCount == 0
  - DFG (Data Flow Graph):
    - Kiểm tra luồng dữ liệu của:
    - Biến count trong countExcellentStudents()
    - Biến sum và validCount trong calculateValidAverage()

Các nhóm test case chính:

- Trường hợp bình thường:
  - Danh sách có cả điểm hợp lệ và không hợp lệ
  - Danh sách chỉ gồm các điểm hợp lệ
  - Danh sách trộn hợp lệ, không hợp lệ và null
- Trường hợp biên:
  - Danh sách rỗng.
  - Danh sách chỉ chứa điểm 0.
  - Danh sách chỉ chứa điểm 10.
  - Điểm đúng bằng 8.0.
- Trường hợp dữ liệu sai
  - Có điểm nhỏ hơn 0.
  - Có điểm lớn hơn 10.
  - Danh sách chỉ chứa giá trị null.
**Kết quả**: Tất cả các test case đều chạy thành công.

#### 5.1.7. Hướng dẫn chạy chương trình vàán `unit-test`  
2. Chuột phải vào lớp `StudentAnalyzerTest`  
3. Chọn `Run 'StudentAnalyzerTest'`  
4. Quan sát kết quả kiểm thử  

Cách 2: Chạy bằng Maven  
Mở Terminal trong IntelliJ IDEA và chạy:
```bash
mvn test
```

#### 5.1.8. Đo độ bao phủ kiểm thử (Code Coverage)

Để đánh giá mức độ bao phủ của các test case đối với mã nguồn, em đã sử dụng công cụ JaCoCo tích hợp trong Maven.

**Công cụ sử dụng:**
- JaCoCo Maven Plugin
- JUnit 5

**Kết quả đo lường:**

| Thành phần | Độ bao phủ |
|-----------|-----------|
| Instruction Coverage | 100% |
| Branch Coverage | 100% |
| Line Coverage | 100% |
| Method Coverage | 100% |
| Class Coverage | 100% |

Báo cáo JaCoCo sau khi chạy kiểm thử:
<img width="1354" height="159" alt="Screenshot 2026-01-19 172609" src="https://github.com/user-attachments/assets/35fcc53a-f2ef-4662-8589-4014e898a16a" />

**Nhận xét:**
- Toàn bộ các dòng lệnh và nhánh điều kiện trong lớp StudentAnalyzer đều đã được kiểm thử.
- Các test case bao phủ cả:
  - Kiểm thử hộp đen (RP, BVA, DT).
  - Kiểm thử hộp trắng (CFG, DFG).
- Điều này đảm bảo:
  - Chương trình xử lý đúng dữ liệu hợp lệ.
  - Bỏ qua chính xác dữ liệu sai.
  - Hoạt động ổn định với các trường hợp đặc biệt (null, empty, boundary).

**Kết luận:**
Chương trình StudentAnalyzer đã đạt độ bao phủ kiểm thử tối đa (100% code coverage), thể hiện:
- Áp dụng đúng kỹ thuật kiểm thử đơn vị.
- Thiết kế test case đầy đủ theo cả:
  - Hộp đen (Black-box)
  - Hộp trắng (White-box)
- Đảm bảo chất lượng và độ tin cậy của mã nguồn.
---

## 6. Bài tập thực hành kiểm thử tự động End-to-End với Cypress  
### 6.1. Chủ đề: Kiểm thử End-to-End cho ứng dụng Web

#### 6.1.1. Mục tiêu
- Hiểu được khái niệm và vai trò của **kiểm thử End-to-End (E2E)** trong quy trình phát triển phần mềm
- Làm quen với **Cypress** – công cụ kiểm thử E2E phổ biến cho ứng dụng web
- Thực hành xây dựng kịch bản kiểm thử mô phỏng **hành vi thực tế của người dùng**
- Rèn luyện kỹ năng:
  - Viết trường hợp kiểm thử (test case) tự động
  - Xác định luồng nghiệp vụ chính
  - Phát hiện lỗi giao diện và chức năng

#### 6.1.2. Mô tả bài toán
Thực hiện kiểm thử End-to-End cho một **ứng dụng Web mẫu** với các chức năng cơ bản như:
- Truy cập trang chủ
- Thao tác với giao diện người dùng
- Nhập dữ liệu vào form
- Kiểm tra kết quả hiển thị sau khi người dùng thực hiện hành động

Các kịch bản kiểm thử tập trung vào:
- Tính đúng đắn của luồng nghiệp vụ
- Khả năng phản hồi của giao diện
- Tính ổn định của ứng dụng khi người dùng ththành
- Ứng dụng hoạt động ổn định trong các luồng kiểm thử chính
- Không phát hiện lỗi nghiêm trọng ảnh hưởng đến trải nghiệm người dùng

Kết quả chạy kiểm thử được quan sát trực tiếp thông qua **Cypress Test Runner**.

---

#### 6.1.7. Hướng dẫn cài đặt và chạy kiểm thử

Bước 1: Cài đặt Node.js (phiên bản LTS)

Bước 2: Cài đặt các thư viện cần thiết:
```bash
npm install
```

Bước 3: Chạy kiểm thử với giao diện Cypress:
```bash
npx cypress open
```

Bước 4: Chạy kiểm thử ở chế độ tự động (headless):
```bash
npx cypress run
```
Ảnh cắt mã khi chạy theo trường hợp kiểm thử với thêm vào giỏ hàng:
<img width="1919" height="1199" alt="image" src="https://github.com/user-attachments/assets/6e64cd4e-2850-4e76-889e-2a3cfe9d6843" />

#### 6.1.8. Nhận xét và đánh giá
- Cypress cho phép kiểm thử End-to-End một cách trực quan và dễ sử dụng
- Các kịch bản kiểm thử mô phỏng sát hành vi thực tế của người dùng


- Công cụ giúp phát hiện sớm lỗi giao diện và lỗi luồng nghiệp vụ
- Kiểm thử End-to-End đóng vai trò quan trọng trong việc đảm bảo chất lượng tổng thể của hệ thống

## 7. Kiểm thử hiệu năng với Apache JMeter

### 7.1. Mục tiêu
Bài kiểm thử này sử dụng **Apache JMeter** để đánh giá hiệu năng của một website (mock thử bằng https://www.wikipedia.org).  
Mục tiêu là:
- Hiểu cách sử dụng JMeter để thực hiện kiểm thử hiệu năng.
- Tạo nhiều kịch bản (Thread Group) với tham số khác nhau.
- Phân tích và trình bày kết quả kiểm thử.

### 7.2. Công cụ sử dụng
- **Apache JMeter (v5.6.3)** – công cụ kiểm thử hiệu năng mã nguồn mở, chạy trên Java.  
  JMeter cho phép mô phỏng nhiều người dùng gửi **HTTP Request** đồng thời và ghi nhận các chỉ số như Response Time, Throughput, Error Rate… :contentReference[oaicite:0]{index=0}

### 7.3. Đối tượng kiểm thử
- Trang web được chọn để kiểm thử: **[https://www.wikipedia.org](https://www.example.com)**  
- Đánh giá độ chịu tải, thời gian phản hồi và số lượng phản hồi (request) xử lý trong thời gian nhất định.

### 7.4. Cấu trúc Test Plan (test-plan.jmx)

#### 7.4.1 Thread Group 1 – Kịch bản cơ bản
- **Số lượng người dùng (threads):** 10  
- **Số vòng lặp (loop count):** 5  
- **Hành vi:** Gửi HTTP GET tới trang chủ (/) của website

#### 7.4.2 Thread Group 2 – Kịch bản tải nặng
- **Số lượng người dùng:** 50  
- **Ramp-up:** 30 giây  
- **Hành vi:** Gửi GET tới:
  - Trang chủ: `/`
  - Trang con: `/`

#### 7.4.3 Thread Group 3 – Kịch bản tùy chỉnh
- **Số lượng người dùng:** 20  
- **Ramp-up:** 1 giây  
- **Loop Count:** Infinite  
- **Duration:** 60 giây  
- **Hành vi:** Gửi GET tới:
  - `/`
  - `/`

### 7.5 Các thành phần bổ sung
- **HTTP Request Defaults:** Thiết lập URL cơ bản (protocol + server) để các HTTP Request chỉ cần khai báo Path.
- **Summary Report:** Thu thập kết quả test dưới dạng bảng thống kê.
- **View Results Tree:** (tuỳ chọn) Xem chi tiết từng response.

### 7.6. Các chỉ số thu thập
Các chỉ số được thu thập bao gồm:
- **# Samples:** Số lượng request được gửi
- **Average:** Thời gian phản hồi trung bình (ms)
- **Min/Max:** Thời gian nhỏ nhất / lớn nhất
- **Error %:** Tỷ lệ request lỗi
- **Throughput:** Số request/giây  
Những chỉ số này giúp đánh giá khả năng chịu tải và thời gian xử lý dưới các mức tải khác nhau.

### 7.7. Kết quả kiểm thử

#### 7.7.1. Thread Group 1 – Kịch bản cơ bản
- **Mô tả:** 10 users, 5 loop  
- **File kết quả:** `result-threadgroup1.csv`  
- **Ảnh minh chứng:** `summary1.png`

| Thống số | Giá trị |
|---------|---------|
| Tổng # Samples | 50 |
| Avg Response Time | 380 ms |
| Throughput | 16.64447 req/sec |
| Error % | 0.00% |

#### 7.7.2. Thread Group 2 – Tải nặng
- **File kết quả:** `result-threadgroup2.csv`  
- **Ảnh minh chứng:** `summary2.png`

| Thống số | Giá trị |
|---------|---------|
| Tổng # Samples | 100 |
| Avg Response Time | 366 ms |
| Throughput | 3.35233 req/sec |
| Error % | 0.00% |

#### 7.7.3 Thread Group 3 – Tùy chỉnh (60s)
- **File kết quả:** `result-threadgroup3.csv`  
- **Ảnh minh chứng:** `summary3.png`

| Thống số | Giá trị |
|---------|---------|
| Tổng # Samples | 6790 |
| Avg Response Time | 171 ms |
| Throughput | 112.9859 req/sec |
| Error % | 0.00% |

### 7.8. Nhận xét chung
- Khi tăng số lượng người dùng, thời gian trung bình và độ phân tán response time thường tăng.
- Kịch bản tải nặng/loop kéo dài (Thread Group 3) giúp quan sát hệ thống trong thời gian thực sự chịu tải.
- Tỷ lệ lỗi và throughput là chỉ số quan trọng để đánh giá ngưỡng chịu tải của server/web.


