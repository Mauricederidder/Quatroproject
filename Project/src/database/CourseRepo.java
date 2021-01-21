package database;

import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Course;
import domain.Level;

public class CourseRepo implements CRUD<Course> {

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
    public Course get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Courses");
        ArrayList<Course> coursesList = new ArrayList<Course>();

        try {
            while (rs.next()) {

                Course course = new Course(1, null, null, null, null, null, null);
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

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void update(int id, String name) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("UPDATE Courses SET CourseName = '%s' WHERE CourseID = %d)",
        name, id));
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Courses WHERE CourseID = %d", id));

    }

}
