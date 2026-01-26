package analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

// ===== TEST countExcellentStudents =====

    @Test // Black-box: RP | White-box: CFG — Kiểm tra danh sách có cả điểm hợp lệ và không hợp lệ
    public void testCountExcellentStudents_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(2, result);
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra danh sách rỗng thì trả về 0
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra danh sách có phần tử null
    public void testCountExcellentStudents_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, null, 8.0)
        );
        assertEquals(2, result);
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị biên đúng bằng 8.0
    public void testCountExcellentStudents_Boundary8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị nhỏ hơn 8.0 thì không được tính
    public void testCountExcellentStudents_BelowBoundary() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.99)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị lớn hơn 10 (không hợp lệ)
    public void testCountExcellentStudents_InvalidHigh() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(10.5)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị biên trên bằng 10
    public void testCountExcellentStudents_WithMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị biên dưới bằng 0
    public void testCountExcellentStudents_WithMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra toàn bộ phần tử đều không hợp lệ hoặc null
    public void testCountExcellentStudents_AllInvalidAndNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(null, -2.0, 15.0)));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra khi danh sách truyền vào là null
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

// ======= BỔ SUNG LOGIC =======

    @Test // Black-box: DT | White-box: DFG — Kiểm tra tất cả điểm đều ≥ 8 thì đếm hết
    public void testCountExcellentStudents_AllExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0)));
    }

    @Test // Black-box: DT | White-box: CFG — Kiểm tra tất cả điểm hợp lệ nhưng không có điểm giỏi
    public void testCountExcellentStudents_AllValidButNotExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0, 5.5, 7.9)));
    }


// ===== TEST calculateValidAverage =====

    @Test // Black-box: RP | White-box: DFG — Kiểm tra tính trung bình khi có cả điểm hợp lệ và không hợp lệ
    public void testCalculateValidAverage_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(8.17, avg, 0.01);
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra khi tất cả điểm đều không hợp lệ thì trả về 0
    public void testCalculateValidAverage_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(-5.0, 20.0));
        assertEquals(0, avg);
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra danh sách có phần tử null
    public void testCalculateValidAverage_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(9.0, analyzer.calculateValidAverage(Arrays.asList(8.0, null, 10.0)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra giá trị biên 0 và 10
    public void testCalculateValidAverage_Boundary0and10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra danh sách rỗng
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra khi tất cả phần tử đều null
    public void testCalculateValidAverage_AllNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(null, null)));
    }

    @Test // Black-box: BVA | White-box: DFG — Kiểm tra chỉ có 1 điểm hợp lệ
    public void testCalculateValidAverage_SingleValidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(7.5)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra chỉ có 1 điểm không hợp lệ
    public void testCalculateValidAverage_SingleInvalidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(12.0)));
    }

    @Test // Black-box: DT | White-box: DFG — Kiểm tra trộn lẫn valid, invalid và null
    public void testCalculateValidAverage_MixedValidInvalidNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(10.0, 5.0, -1.0, null, 11.0));
        assertEquals(7.5, avg);
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra chỉ có điểm tối đa 10
    public void testCalculateValidAverage_OnlyMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(10.0, analyzer.calculateValidAverage(Arrays.asList(10.0)));
    }

    @Test // Black-box: BVA | White-box: CFG — Kiểm tra chỉ có điểm tối thiểu 0
    public void testCalculateValidAverage_OnlyMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(0.0)));
    }

    @Test // Black-box: RP | White-box: CFG — Kiểm tra khi danh sách truyền vào là null
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(null));
    }

// ======= BỔ SUNG LOGIC =======

    @Test // Black-box: DT | White-box: DFG — Kiểm tra khi tất cả điểm đều hợp lệ
    public void testCalculateValidAverage_AllValidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(6.0, analyzer.calculateValidAverage(Arrays.asList(4.0, 6.0, 8.0)));
    }

    @Test // Black-box: BVA | White-box: DFG — Kiểm tra điểm hợp lệ dạng số thập phân
    public void testCalculateValidAverage_AllValidFractional() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.33, analyzer.calculateValidAverage(Arrays.asList(7.0, 7.0, 8.0)), 0.01);
    }
}
