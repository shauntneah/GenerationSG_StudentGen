package EXAM_JAVA.model;

import java.util.Date;
import java.util.HashMap;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }


    // Challenge (4): Enroll Student to Course
    //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
    public boolean enrollToCourse( Course course )
    {
        //@@ my codes
        if (!enrolledCourses.containsKey(course.getCode())) {
            enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return true;
        }
        else {
            return false;
        }
        //@@ end my codes

       //return false; //default test code. commenting out for my coding clarity.
    }//end enrollToCourse Challenge (4)



    // Challenge (5): Show Student Summary
    //TODO return a Hashmap of all the enrolledCourses
    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //@@ my codes
        return enrolledCourses;
        //@@ end my codes
        //return null;  //This was test code default.
    }//end getEnrolledCourses Challenge (5)



    //Challenge (3): Grade Student (Min grade input: 1 and Max grade input 6)
    //TODO set the grade for the enrolled Course
    public void gradeCourse( String courseCode, double grade )
    {
        //@@ my codes
        if (enrolledCourses.containsKey(courseCode)) {
            enrolledCourses.get(courseCode).setGrade(grade);
        }
        //@@ end my codes
    }//end gradeCourse Challenge (3)



    //Challenge (3): Grade Student (Min grade input: 1 and Max grade input 6)
    //TODO print return a Course from the course Id
    public Course findCourseById( String courseId )
    {
        //@@ my codes
        if (enrolledCourses.containsKey(courseId)) {
            return enrolledCourses.get(courseId);
        }
        else {
            return null;
        }
        //@@ end my codes
        // return null; default test code. commenting out for my coding clarity.
    }//end findCourseById Challenge (3)



   //Challenge (7): Show Passed Course (the minimum passing grade is 3.0), Min grade input: 1 and Max grade input 6
   //TODO Check the enrolled courses grade and compare to the passing grade
    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //@@ my codes
        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();
        if ( enrolledCourses.isEmpty() )
        {
            System.out.println("Student has not enrolled to any courses");
            return null;
        }
        else
        {
            for ( String courseCode : enrolledCourses.keySet() )
            {
                if ( enrolledCourses.get( courseCode ).getGrade() >= PASS_MIN_GRADE )
                {
                    passedCourses.put( courseCode, enrolledCourses.get( courseCode ) );
                }
            }
            return passedCourses;
        }
        //@@ end my codes

       //return null; //default test code. commenting out for my coding clarity.
    }//end findPassedCourses Challenge (7)


    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
