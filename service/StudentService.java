package EXAM_JAVA.service;

import EXAM_JAVA.model.Course;
import EXAM_JAVA.model.EnrolledCourse;
import EXAM_JAVA.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();


    // **done! Challenge (1): Register Student
    //TODO Add new student to the students hashmap
    public void registerStudent( Student student )
    {
        //@@ my code
       Student newStudent = new Student(student.getId(), student.getName(), student.getEmail(), student.getBirthDate());
         students.put(newStudent.getId(), newStudent);
         //@@ end my code
    }


    // **done! Challenge (2): Find Student
    //TODO Find the student from the Hashmap with the student id
    public Student findStudent( String studentId )
    {
      //@@ my code
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        //@@ end my code

        return null; //default test code.
    }//end findStudent Challenge (2)


    // **done! Challenge (4): Enroll Student to Course. Test using `INTRO-CS-1` and `INTRO-CS-2`
    //TODO check if students hashmap contains the studentsId, if not enroll student to the course
    public void enrollToCourse( String studentId, Course course )
    {
        //@@ my code
        if (students.containsKey(studentId)) {
            students.get(studentId).enrollToCourse(course);
        }
        else {
            System.out.println("Student not found");
        }
        //@@ end my code

    }//end enrollToCourse Challenge (4)


    // **done! Challenge (5): Show Student Summary
    //TODO Loop through students hashmap and print out students' details including the enrolled courses
    public void showSummary()
    {
        //@@ my code
        for (Student student : students.values()) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
            System.out.println("Student Birth Date: " + student.getBirthDate());
            System.out.println("Student Enrolled Courses: " + student.getEnrolledCourses()); //needed to update code in Student.java for this to work
            //@@@@  KIV next line `+ "\n"`
        }
        //@@ end my code

    }//end showSummary Challenge (5)


    // **done! Challenge (3): Grade Student (Min grade input: 1 and Max grade input 6)
    //TODO return a HashMap of all the enrolledCourses
    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //@@ my codes
        HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();

        if (students.containsKey(student.getId())) {
            enrolledCourses = student.getEnrolledCourses();
            return enrolledCourses;
        }
        //@@ end my codes

        return null;  // default test code.
    }//end enrolledCourses Challenge (3)


    // **done! Challenge (3): Grade Student (Min grade input: 1 and Max grade input 6)
    //TODO return the course enrolled by the student from the course Id
    public Course findEnrolledCourse( Student student, String courseId )
    {
        //@@ my codes
        if (students.containsKey(student.getId())) {
            return student.findCourseById(courseId);
        //@@ end my codes

        }
        return null; // default test code.
    }//end findEnrolledCourse Challenge (3)

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
