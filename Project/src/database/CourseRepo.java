package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Course;
import domain.Level;

public class CourseRepo implements Crud<Course> {

    @Override
    public void create(Course params) {

        int courseID = params.getCourseId();
        String name = params.getCourseName();
        String subject = params.getSubject();
        Level dificulty = params.getLevel();
        String introText = params.getIntroduction();
        String description = params.getDescription();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Courses(CourseName, Subject, Difficulty, IntroText, Description) VALUES ('%s','%s', %d, '%s','%s');",
                name, subject, dificulty, introText, description));
    }

    @Override
    public Course get(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT * FROM Courses WHERE CourseID = %d", id));
        Course course = new Course(id, null, null, null, null, null, null);

        try {
            while (rs.next()) {

                course.setCourseName(rs.getString("CourseName"));
                course.setLevelString(rs.getString("Difficulty"));
                course.setSubject(rs.getString("Subject"));
                course.setIntroduction(rs.getString("IntroText"));
                course.setDescription(rs.getString("Description"));
                System.out.println(course);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public ArrayList<Course> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Courses");
        ArrayList<Course> coursesList = new ArrayList<Course>();
        Course course = new Course(1, null, null, null, null, null, null);
        try {
            while (rs.next()) {
            
                course.setCourseName(rs.getString("CourseName"));
                course.setLevelString(rs.getString("Difficulty"));
                course.setSubject(rs.getString("Subject"));
                course.setIntroduction(rs.getString("IntroText"));
                course.setDescription(rs.getString("Description"));
                course.setCourseId(rs.getInt("CourseID"));
                System.out.println(course);
                coursesList.add(course);

            }
            
            for (Course i : coursesList) {
                System.out.println(i);
            }
            return coursesList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public void update(int id, String name) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection
                .execute(String.format("UPDATE Courses SET CourseName = '%s' WHERE CourseID = %d)", name, id));
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Courses WHERE CourseID = %d", id));

    }

    public HashMap studentsPerCourse() {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT CourseName, COUNT(*) AS TotalPersons FROM Registrations INNER JOIN Courses ON Courses.CourseID = Registrations.CourseID GROUP BY CourseName"));

        HashMap<String, Integer> studentsPerCourse = new HashMap<String, Integer>();

        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                int totalRegistrations = rs.getInt("TotalPersons");

                studentsPerCourse.put(courseName, totalRegistrations);
            }

            for (String i : studentsPerCourse.keySet()) {
                System.out.println(i + " | " + studentsPerCourse.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsPerCourse;
    }
    public Integer studentsPerCourse(int id){
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT CourseName, COUNT(*) AS TotalPersons FROM Registrations INNER JOIN Courses ON Courses.CourseID = Registrations.CourseID WHERE Courses.CourseID = %d GROUP BY CourseName ",id));

        HashMap<String, Integer> studentsPerCourse = new HashMap<String, Integer>();
        Integer totalRegistrations = 0;
        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                totalRegistrations = rs.getInt("TotalPersons");

                studentsPerCourse.put(courseName, totalRegistrations);
            }

            for (String i : studentsPerCourse.keySet()) {
                System.out.println(i + " | " + studentsPerCourse.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRegistrations;
    }

    public HashMap top5Courses() {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT TOP 5 CourseName, COUNT(Registrations.CourseID) AS Students FROM Courses INNER JOIN Registrations ON Registrations.CourseID = Courses.CourseID GROUP BY CourseName ORDER BY COUNT(Registrations.CourseID) DESC"));

        HashMap<String, Integer> top5Courses = new HashMap<String, Integer>();

        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                int students = rs.getInt("Students");

                top5Courses.put(courseName, students);
            }

            for (String i : top5Courses.keySet()) {
                System.out.println(i + " | Students: " + top5Courses.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return top5Courses;
    }

    public int totalClearedBasedOnCourse(int courseID) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT COUNT(CertificateIssuance.StudentID) AS Behaald FROM Certificate INNER JOIN CertificateIssuance ON Certificate.CertificateID  = CertificateIssuance.CertificateID WHERE CourseID = %d",
                courseID));

        int behaald = 0;

        try {
            while (rs.next()) {
                behaald = rs.getInt("Behaald");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return behaald;
    }

    public List matchingCoursesBasedOnTag(String tag) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT CourseName, TagName FROM Courses INNER JOIN CourseTags ON CourseTags.CourseID = Courses.CourseID INNER JOIN Tags ON Tags.TagID = CourseTags.TagID WHERE TagName = '%s'",
                tag));

        List<String> matchingCourses = new ArrayList<>();

        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                String tagName = rs.getString("TagName");
                matchingCourses.add(courseName + " | " + tagName);
            }
            System.out.println(matchingCourses);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchingCourses;
    }

    
}
