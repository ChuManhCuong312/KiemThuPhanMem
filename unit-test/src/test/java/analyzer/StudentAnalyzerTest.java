package analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

// ===== TEST countExcellentStudents =====

    @Test // Black-box: RP (phân vùng hợp lệ + không hợp lệ)
    public void testCountExcellentStudents_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(2, result);
    }

    @Test // Black-box: RP (danh sách rỗng)
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test // Black-box: RP (có null)
    public void testCountExcellentStudents_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, null, 8.0)
        );
        assertEquals(2, result);
    }

    @Test // Black-box: BVA (biên dưới = 8.0)
    public void testCountExcellentStudents_Boundary8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test // Black-box: BVA (dưới biên 7.99)
    public void testCountExcellentStudents_BelowBoundary() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.99)));
    }

    @Test // Black-box: BVA (trên biên 10.5)
    public void testCountExcellentStudents_InvalidHigh() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(10.5)));
    }

    @Test // Black-box: BVA (giá trị biên trên = 10)
    public void testCountExcellentStudents_WithMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
    }

    @Test // Black-box: BVA (giá trị biên dưới = 0)
    public void testCountExcellentStudents_WithMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
    }

    @Test // Black-box: RP (toàn invalid + null)
    public void testCountExcellentStudents_AllInvalidAndNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(null, -2.0, 15.0)));
    }

    @Test // Black-box: RP (null list)
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

// ======= BỔ SUNG LOGIC =======

    @Test // Black-box: DT (tất cả đều excellent)
    public void testCountExcellentStudents_AllExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0)));
    }

    @Test // Black-box: DT (tất cả hợp lệ nhưng không excellent)
    public void testCountExcellentStudents_AllValidButNotExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0, 5.5, 7.9)));
    }


// ===== TEST calculateValidAverage =====

    @Test // Black-box: RP (hợp lệ + không hợp lệ)
    public void testCalculateValidAverage_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(8.17, avg, 0.01);
    }

    @Test // Black-box: RP (toàn invalid)
    public void testCalculateValidAverage_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(-5.0, 20.0));
        assertEquals(0, avg);
    }

    @Test // Black-box: RP (có null)
    public void testCalculateValidAverage_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(9.0, analyzer.calculateValidAverage(Arrays.asList(8.0, null, 10.0)));
    }

    @Test // Black-box: BVA (biên 0 và 10)
    public void testCalculateValidAverage_Boundary0and10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)));
    }

    @Test // Black-box: RP (list rỗng)
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test // Black-box: RP (toàn null)
    public void testCalculateValidAverage_AllNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(null, null)));
    }

    @Test // Black-box: BVA (1 phần tử hợp lệ)
    public void testCalculateValidAverage_SingleValidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(7.5)));
    }

    @Test // Black-box: BVA (1 phần tử không hợp lệ)
    public void testCalculateValidAverage_SingleInvalidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(12.0)));
    }

    @Test // Black-box: DT (valid + invalid + null)
    public void testCalculateValidAverage_MixedValidInvalidNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(10.0, 5.0, -1.0, null, 11.0));
        assertEquals(7.5, avg);
    }

    @Test // Black-box: BVA (chỉ có max = 10)
    public void testCalculateValidAverage_OnlyMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(10.0, analyzer.calculateValidAverage(Arrays.asList(10.0)));
    }

    @Test // Black-box: BVA (chỉ có min = 0)
    public void testCalculateValidAverage_OnlyMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(0.0)));
    }

    @Test // Black-box: RP (null list)
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(null));
    }

// ======= BỔ SUNG LOGIC =======

    @Test // Black-box: DT (tất cả valid)
    public void testCalculateValidAverage_AllValidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(6.0, analyzer.calculateValidAverage(Arrays.asList(4.0, 6.0, 8.0)));
    }

    @Test // Black-box: BVA (giá trị thập phân)
    public void testCalculateValidAverage_AllValidFractional() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.33, analyzer.calculateValidAverage(Arrays.asList(7.0, 7.0, 8.0)), 0.01);
    }
}
