public class Student {
    String name;
    int age;
    String course;
    double grade1, grade2, grade3;

    public Student(String name, int age, String course, double grade1, double grade2, double grade3) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public void displayInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
        System.out.printf("Grades: %.1f, %.1f, %.1f\n", grade1, grade2, grade3);
        System.out.printf("Average: %.2f\n", calculateAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("Status: " + (isPassing() ? "PASSING" : "FAILING"));
        System.out.println();
    }

    public double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }

    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public boolean isPassing() {
        return calculateAverage() >= 70;
    }
}
