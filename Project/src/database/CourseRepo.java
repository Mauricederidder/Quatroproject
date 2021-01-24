package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Course;
import domain.CourseAndTag;

import domain.Level;
import domain.Module;
import domain.ContentItem;

public class CourseRepo implements Crud<Course> {

    @Override
    public void create(Course params) {

        int courseID = params.getCourseId();
        String name = params.getCourseName();
        String subject = params.getSubject();
        String dificulty = String.valueOf(params.getLevel());
        String introText = params.getIntroduction();
        String description = params.getDescription();
        List<ContentItem> list = params.getContentItems();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Courses(CourseName, Subject, Difficulty, IntroText, Description) VALUES ('%s','%s', '%s', '%s','%s');",
                name, subject, dificulty, introText, description));

        // ResultSet index = DatabaseConnection
        //         .execute(String.format("SELECT CourseID FROM Courses WHERE CourseName = '%s'", name));
        // int i = 0;
       
        // try {
        //     while (index.next()) {
        //         i = index.getInt("CourseID");
        //     }
        //     for (ContentItem l : list) {
        //         Date date = l.getPublicationDate();
        //         String realDate = String.valueOf(date);

        //         String stat = String.valueOf(l.getStatus());

        //         ResultSet insertContentItem = DatabaseConnection.execute(String.format(
        //             "INSERT INTO ContentItem(Status,PublicationDate,CourseID VALUES ('%s','%s',%d);",
        //              stat, realDate, i));
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

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
          //      System.out.println(course);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public ArrayList<Course> get() {
        ResultSet rs = DatabaseConnection.execute("SELECT * FROM Courses");
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
          //      System.out.println(course);
                coursesList.add(course);

            }

            for (Course i : coursesList) {
      //          System.out.println(i);
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
 //               System.out.println(i + " | " + studentsPerCourse.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsPerCourse;
    }

    public Integer studentsPerCourse(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT CourseName, COUNT(*) AS TotalPersons FROM Registrations INNER JOIN Courses ON Courses.CourseID = Registrations.CourseID WHERE Courses.CourseID = %d GROUP BY CourseName ",
                id));

        HashMap<String, Integer> studentsPerCourse = new HashMap<String, Integer>();
        int totalRegistrations = 0;
        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                totalRegistrations = rs.getInt("TotalPersons");

                studentsPerCourse.put(courseName, totalRegistrations);
            }

            for (String i : studentsPerCourse.keySet()) {
     //           System.out.println(i + " | " + studentsPerCourse.get(i));
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
   //             System.out.println(i + " | Students: " + top5Courses.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return top5Courses;
    }

    public Integer totalClearedBasedOnCourse(int courseID) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT COUNT(CertificateIssuance.StudentID) AS Behaald FROM Certificate INNER JOIN CertificateIssuance ON Certificate.CertificateID  = CertificateIssuance.CertificateID WHERE CourseID = %d",
                courseID));

        Integer behaald = 0;

        try {
            while (rs.next()) {
                behaald = rs.getInt("Behaald");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return behaald;
    }

    public List<CourseAndTag> matchingCoursesBasedOnTag(String tag) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT Courses.CourseID, CourseName, TagName FROM Courses INNER JOIN CourseTags ON CourseTags.CourseID = Courses.CourseID INNER JOIN Tags ON Tags.TagID = CourseTags.TagID WHERE TagName = '%s'",
                tag));

        List<CourseAndTag> matchingCourses = new ArrayList<>();
        try {
            while (rs.next()) {
                CourseAndTag courseAndTags = new CourseAndTag(null, null, null);
                courseAndTags.setCourseName(rs.getString("CourseName"));
                courseAndTags.setStudentsPerCourse(studentsPerCourse(rs.getInt("CourseID")).toString());
                courseAndTags.setTags(rs.getString("TagName"));
                matchingCourses.add(courseAndTags);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // matchingCourses.add(rs.getInt("CourseID"));
        return matchingCourses;
    }

    public List getAllTagsBasedOnCourse() {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT Courses.CourseName, Tags.TagName FROM Courses LEFT JOIN CourseTags ON Courses.CourseID = CourseTags.CourseID LEFT JOIN Tags ON Tags.TagID = CourseTags.TagID"));

        List<String> matchingCourses = new ArrayList<>();

        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                String tagName = rs.getString("TagName");
                matchingCourses.add(courseName + " | " + tagName);
            }
     //       System.out.println(matchingCourses);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchingCourses;
    }

    public ArrayList<Module> getProgress(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT Modules.Title, Progress.Progress FROM Progress INNER JOIN ContentItems ON ContentItems.ContentItemID = Progress.ContentItemID INNER JOIN Courses ON Courses.CourseID = ContentItems.CourseID INNER JOIN Modules ON ContentItems.ContentItemID = Modules.ContentItemID",
                id));

        ArrayList<Module> progress = new ArrayList<Module>();

        try {
            while (rs.next()) {
                Module module = new Module(id, null, null, null, null, null, null, null);
                module.setAvarageProgress(rs.getString("Progress"));
                module.setTitle(rs.getString("Title"));
                progress.add(module);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return progress;
    }

    public List getTagsBasedOnCourse(Integer courseID) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT CourseName, TagName FROM Courses INNER JOIN CourseTags ON CourseTags.CourseID = Courses.CourseID INNER JOIN Tags ON Tags.TagID = CourseTags.TagID "));

        List<String> tags = new ArrayList<>();

        try {
            while (rs.next()) {
                String tagName = rs.getString("TagName");
                tags.add(tagName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tags;
    }
    
}
