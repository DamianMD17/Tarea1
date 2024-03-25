package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Gestion {

    /**
     * Adds a new student to the list of students.
     *
     * @param students The list of students.
     * @param position Flag indicating whether to add the student at the
     * beginning or end of the list.
     */
    public static void addStudents(LinkedList<Students> students,
            boolean position) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the new student data:");

        System.out.print("Course code: ");
        String sigla = scanner.nextLine();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        System.out.print("Study mode: ");
        String studyMode = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Institutional email address: ");
        String institutionalEmail = scanner.nextLine();

        System.out.print("Registration type: ");
        String registrationType = scanner.nextLine();

        Students newStudent = new Students(sigla, group,
                studyMode, studentID, fullName,
                institutionalEmail, registrationType);

        if (position) {
            students.addFirst(newStudent);
        } else {
            students.addLast(newStudent);
        }

        System.out.println("Student successfully added");
    }

    /**
     * Searches for a student in the list of students by student ID.
     *
     * @param students The list of students to search in.
     * @return The student found, or null if not found.
     */
    public static Students searchStudent(LinkedList<Students> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student's ID you want to search for:");
        String searchedID = scanner.nextLine();

        for (Students student : students) {
            if (student.studentID.equalsIgnoreCase(searchedID)) {
                System.out.println("Student found: " + student.fullName);
                return student;
            }
        }

        System.out.println("Estudiante no encontrado.");
        return null;
    }

    /**
     * Loads student data from a file into a list of students.
     *
     * @return The list of loaded students.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static LinkedList<Students> loadStudents() throws IOException {
        HashSet<String> names = new HashSet<>();
        LinkedList<Students> students = new LinkedList<>();

        File file = new File("Programacion II .txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\t");
            Students student = new Students(data[0], (data[1]), (data[2]), data[3], data[4],
                    data[5], data[6]);
            students.add(student);

            if (names.contains(student.fullName)) {
                System.out.println("Repeated name:" + student.fullName);
            } else {
                names.add(student.fullName);
            }
        }

        return students;
    }

    /**
     * Edits the data of a given student in the list of students.
     *
     * @param student The student to edit.
     * @param students The list of students.
     */
    public static void editStudents(Students student, LinkedList<Students> students) {
        if (student == null) {
            System.out.println("Can not delete a null student");
            return;
        }
        Students replaceableStudent = student;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the new student data:");

        System.out.print("New carnet: ");
        student.studentID = scanner.nextLine();

        Students studentEdit = new Students(student.getSigla(),
                student.getGroup(), student.getStudyMode(), student.studentID,
                student.getFullName(), student.getInstitutionalEmail(), student.getRegistrationType());

        students.addFirst(studentEdit);
        deleteStudents(students,
                replaceableStudent);
        System.out.println("Student data updated successfully.");
    }

    /**
     * Deletes a student from the list of students.
     *
     * @param students The list of students.
     * @param student The student to delete.
     */
    public static void deleteStudents(LinkedList<Students> students,
            Students student) {

        if (student == null) {
            System.out.println("Can not delete a null student");
            return;
        }

        students.remove(student);
        System.out.println("Student succesfully eliminited");
    }

    /**
     * Displays the menu for managing student records and performs corresponding
     * actions based on user input.
     *
     * @param students The list of students.
     */
    public void menu(LinkedList<Students> students) {

        boolean position;
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Menu ******");

        System.out.println("1. show student list");

        System.out.println("2. sort students by name");

        System.out.println("3. view sorted student list");

        System.out.println("4. search student");

        System.out.println("5. edit student");

        System.out.println("6. remove student");

        System.out.println("7. add a student at the end of the list");

        System.out.println("8. add a student at the beginning of the list");

        System.out.println("9. exit");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                showStudents(students);
                menu(students);

            case 2:
                sortStudents(students);
                menu(students);

            case 3:
                showSortedStudentsList(students);
                menu(students);

            case 4:
                searchStudent(students);
                menu(students);

            case 5:

                Students editStudent = searchStudent(students);
                if (editStudent != null) {
                    editStudents(editStudent, students);
                }
                menu(students);

            case 6:
                Students studentRemove = searchStudent(students);
                if (studentRemove != null) {
                    deleteStudents(students, studentRemove);
                }
                menu(students);

            case 7:
                position = false;
                addStudents(students, position);
                menu(students);

            case 8:
                position = true;
                addStudents(students, position);
                menu(students);

                break;
            case 9:
                System.exit(0);

            default:
                System.out.println("invalid option");

        }

    }

    /**
     * Displays the list of students with their names and IDs.
     *
     * @param students The list of students.
     */
    public static void showStudents(LinkedList<Students> students) {
        for (Students student : students) {
            System.out.println("Name: " + student.fullName
                    + ", ID: " + student.studentID);
        }
    }

    /**
     * Displays the sorted list of students' names.
     *
     * @param students The list of students.
     */
    public static void showSortedStudentsList(LinkedList<Students> students) {
        for (Students student : students) {
            System.out.println(student.fullName);
        }
    }

    /**
     * Sorts the list of students by their full names.
     *
     * @param students The list of students to sort.
     */
    public static void sortStudents(LinkedList<Students> students) {
        Collections.sort(students, new Comparator<Students>() {
            public int compare(Students s1, Students s2) {
                return s1.fullName.compareTo(s2.fullName);
            }
        });
        System.out.println("Sorting completed");
    }

}
