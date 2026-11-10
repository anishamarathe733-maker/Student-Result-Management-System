
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT RESULT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                // ADD STUDENT
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter ID: ");

                    int id;

                    try {
                        id = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID!");
                        break;
                    }

                    if (id <= 0) {
                        System.out.println("ID must be positive!");
                        break;
                    }

                    boolean duplicate = false;

                    for (Student st : students) {
                        if (st.id == id) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Student ID already exists!");
                        break;
                    }

                    System.out.print("Enter marks: ");

                    double marks;

                    try {
                        marks = Double.parseDouble(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100!");
                        break;
                    }

                    Student s = new Student(name, id, marks);
                    students.add(s);

                    System.out.println("Student added successfully!");
                    break;


                // VIEW STUDENTS
                case 2:
                    System.out.println("\n--- Student Records ---");

                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    }

                    for (Student st : students) {
                        System.out.println("Name: " + st.name);
                        System.out.println("ID: " + st.id);
                        System.out.println("Marks: " + st.marks);
                        System.out.println("Grade: " + st.grade);
                        System.out.println("--------------------");
                    }
                    break;


                // SEARCH STUDENT
                case 3:
                    System.out.print("Enter Student ID to search: ");

                    int searchId;

                    try {
                        searchId = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID!");
                        break;
                    }

                    boolean found = false;

                    for (Student st : students) {
                        if (st.id == searchId) {
                            System.out.println("Student Found!");
                            System.out.println("Name: " + st.name);
                            System.out.println("ID: " + st.id);
                            System.out.println("Marks: " + st.marks);
                            System.out.println("Grade: " + st.grade);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;


                // DELETE STUDENT
                case 4:
                    System.out.print("Enter Student ID to delete: ");

                    int deleteId;

                    try {
                        deleteId = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID!");
                        break;
                    }

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == deleteId) {
                            students.remove(i);
                            deleted = true;
                            System.out.println("Student deleted successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found!");
                    }
                    break;


                // SORT STUDENTS
                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No students available to sort!");
                        break;
                    }

                    Collections.sort(students,
                        (a, b) -> Double.compare(b.marks, a.marks));

                    System.out.println("\n--- Students Sorted by Marks ---");

                    for (Student st : students) {
                        System.out.println("Name: " + st.name);
                        System.out.println("ID: " + st.id);
                        System.out.println("Marks: " + st.marks);
                        System.out.println("Grade: " + st.grade);
                        System.out.println("--------------------");
                    }
                    break;


                // EXIT
                case 6:
                    System.out.println("Thank you!");
                    break;


                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}

