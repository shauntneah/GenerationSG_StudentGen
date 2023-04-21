package EXAM_JAVA.java;

import EXAM_JAVA.model.Course;
import EXAM_JAVA.model.Student;
import EXAM_JAVA.service.CourseService;
import EXAM_JAVA.service.StudentService;
import EXAM_JAVA.utils.PrinterHelper;
import EXAM_JAVA.model.EnrolledCourse;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args)
            throws ParseException {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerStudent(studentService, scanner);
                    break;
                case 2:
                    findStudent(studentService, scanner);
                    break;
                case 3:
                    gradeStudent(studentService, scanner);
                    break;
                case 4:
                    enrollStudentToCourse(studentService, courseService, scanner);
                    break;
                case 5:
                    showStudentsSummary(studentService, scanner);
                    break;
                case 6:
                    showCoursesSummary(courseService, scanner);
                    break;
                case 7:
                    showPassedCourses(studentService, scanner);
                    break;
            }
        }
        while (option != 8);
    }

    private static void enrollStudentToCourse(StudentService studentService, CourseService courseService,
                                              Scanner scanner) {
        System.out.println("Insert student ID");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Invalid Student ID");
            return;
        }
        System.out.println(student);
        System.out.println("Insert course ID");
        String courseId = scanner.next();
        Course course = courseService.getCourse(courseId);
        if (course == null) {
            System.out.println("Invalid Course ID");
            return;
        }
        System.out.println(course);
        studentService.enrollToCourse(studentId, course);
        System.out.println("Student with ID: " + studentId + " enrolled successfully to " + courseId);

    }

    private static void showCoursesSummary(CourseService courseService, Scanner scanner) {
        courseService.showSummary();
    }

    private static void showStudentsSummary(StudentService studentService, Scanner scanner) {
        studentService.showSummary();
    }


    //Challenge (3): Grade Student (Min grade input: 1 and Max grade input 6)
    //TODO Loop through the student enrolled courses, and use the scanner object to get the course ID to insert the course grade
    private static void gradeStudent(StudentService studentService, Scanner scanner) {
        Student student = getStudentInformation(studentService, scanner);
        System.out.println("Enrolled course ID:"); //edited print statement for better user experience & context

        //@@ my codes
        String courseId = scanner.next();
            for (Map.Entry<String, EnrolledCourse> entry : student.getEnrolledCourses().entrySet())
            {
                if (entry.getKey().equals(courseId)) {
                    System.out.println("Insert grade, scoring (min 1 - max 6): ");
                    double grade = scanner.nextDouble();
                    studentService.gradeStudent(student, student.getEnrolledCourses().get(courseId), grade);
                }
            }
        //@@ end my codes
    }//end gradeStudent Challenge (3)

    private static Student getStudentInformation(StudentService studentService, Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found");
        }
        return student;
    }

    private static void findStudent(StudentService studentService, Scanner scanner) {
        Student student = getStudentInformation(studentService, scanner);
        if (student != null) {
            System.out.println("Student Found: ");
            System.out.println(student);
        }
    }

    private static void registerStudent(StudentService studentService, Scanner scanner) throws ParseException {
        Student student = PrinterHelper.createStudentMenu(scanner);
        studentService.registerStudent(student);
    }


    //Challenge (7): Show Passed Course (the minimum passing grade is 3.0), Min grade input: 1 and Max grade input 6
    //TODO Loop through the student enrolled courses, and show all the passed courses
    private static void showPassedCourses(StudentService studentService, Scanner scanner) {

        //@@ my codes
        System.out.println("Insert student ID: ");
        String studentId = scanner.next();
        EXAM_JAVA.model.Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student ID not found");
        } else {
            System.out.println("Student found: ");
            System.out.println(student);
            System.out.println("Student's passed courses: ");
            //loop through every entry from the getPassedCourses() method from StudentService
            for (Map.Entry<String, EnrolledCourse> entry : studentService.getPassedCourses(student).entrySet()) {

                System.out.println(entry.getValue());
            }
        }
        //@@ end my codes


    }//end showPassedCourses Challenge (7)
}//end Class workspace
