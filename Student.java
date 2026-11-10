
public class Student {

    String name;
    int id;
    double marks;
    String grade;

    Student(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else {
            return "Fail";
        }
    }
}
