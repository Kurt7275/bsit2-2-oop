class Student {
    String name;
    int age;
    String course;
    double grade1, grade2, grade3;

    // Constructor
    Student(String name, int age, String course, double grade1, double grade2, double grade3) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    // Display student info
    void displayInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
        System.out.printf("Grades: %.1f, %.1f, %.1f\n", grade1, grade2, grade3);
        System.out.printf("Average: %.2f\n", calculateAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("Status: " + (isPassing() ? "PASSING" : "FAILING"));
        System.out.println();
    }

    // Calculate average of grades
    double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }

    // Return letter grade
    String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    // Check if passing
    boolean isPassing() {
        return calculateAverage() >= 70;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20, "BSIT", 85.0, 90.0, 88.0);
        Student s2 = new Student("Bob", 19, "BSCS", 92.0, 95.0, 89.0);
        Student s3 = new Student("Charlie", 21, "BSIT", 65.0, 70.0, 68.0);

        Student[] students = {s1, s2, s3};

        int passingCount = 0;

        for (Student s : students) {
            s.displayInfo();
            if (s.isPassing()) {
                passingCount++;
            }
        }

        System.out.println("Summary: " + passingCount + " out of " + students.length + " students are passing.");
    }
}
