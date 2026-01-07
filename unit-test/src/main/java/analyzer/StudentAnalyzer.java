package analyzer;

import java.util.List;

public class StudentAnalyzer {

    /*Đếm số học sinh đạt loại Giỏi (>= 8.0)*/
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Double score : scores) {
            if (score != null && score >= 0 && score <= 10) {
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /*Tính điểm trung bình các điểm hợp lệ (0–10)*/
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int validCount = 0;

        for (Double score : scores) {
            if (score != null && score >= 0 && score <= 10) {
                sum += score;
                validCount++;
            }
        }

        return validCount == 0 ? 0 : sum / validCount;
    }
}

