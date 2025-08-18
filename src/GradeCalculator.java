public class GradeCalculator {
    public double calculateAverage(double... grades) {
        if (grades.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum = sum + grades[i];
        }
        return sum / grades.length;
    }

    public String getLetterGrade(double avg) {
        if (avg >= 90) {
            return "A";
        }
        if (avg >= 80) {
            return "B";
        }
        if (avg >= 70) {
            return "C";
        }
        if (avg >= 60) {
            return "D";
        }
        return "F";
    }

    public void displayResult(String name, double avg) {
        System.out.println(name + ": " + avg);
    }

    public void displayResult(String name, double avg, String letter) {
        System.out.println(name + ": " + avg + " (" + letter + ")");
    }

    public static void main(String[] args) {
        GradeCalculator gc = new GradeCalculator();
        double avg = gc.calculateAverage(85.5, 92.0, 78.5, 90.0);
        String letter = gc.getLetterGrade(avg);
        gc.displayResult("John Smith", avg);
        gc.displayResult("John Smith", avg, letter);
    }
}
