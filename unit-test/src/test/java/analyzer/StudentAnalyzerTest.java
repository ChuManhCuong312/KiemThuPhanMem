package analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    // ===== TEST countExcellentStudents =====

    @Test
    public void testCountExcellentStudents_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(2, result);
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, null, 8.0)
        );
        assertEquals(2, result);
    }

    @Test
    public void testCountExcellentStudents_Boundary8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test
    public void testCountExcellentStudents_BelowBoundary() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.99)));
    }

    @Test
    public void testCountExcellentStudents_InvalidHigh() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(10.5)));
    }

    // ======= BỔ SUNG =======

    @Test
    public void testCountExcellentStudents_WithMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
    }

    @Test
    public void testCountExcellentStudents_WithMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
    }

    @Test
    public void testCountExcellentStudents_AllInvalidAndNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(null, -2.0, 15.0)));
    }

    @Test
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    // ===== TEST calculateValidAverage =====

    @Test
    public void testCalculateValidAverage_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(8.17, avg, 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(-5.0, 20.0));
        assertEquals(0, avg);
    }

    @Test
    public void testCalculateValidAverage_WithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(8.0, null, 10.0));
        assertEquals(9.0, avg);
    }

    @Test
    public void testCalculateValidAverage_Boundary0and10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0));
        assertEquals(5.0, avg);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test
    public void testCalculateValidAverage_AllNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(null, null)));
    }

    // ======= BỔ SUNG =======

    @Test
    public void testCalculateValidAverage_SingleValidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(7.5)));
    }

    @Test
    public void testCalculateValidAverage_SingleInvalidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(12.0)));
    }

    @Test
    public void testCalculateValidAverage_MixedValidInvalidNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(Arrays.asList(10.0, 5.0, -1.0, null, 11.0));
        assertEquals(7.5, avg);
    }

    @Test
    public void testCalculateValidAverage_OnlyMaxScore10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(10.0, analyzer.calculateValidAverage(Arrays.asList(10.0)));
    }

    @Test
    public void testCalculateValidAverage_OnlyMinScore0() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(0.0)));
    }

    @Test
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(null));
    }
}
