package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Certificate;
import domain.Course;
import domain.Person;
import domain.Student;
import domain.Module;

public class StudentRepo implements Crud<Student> {

    @Override
    public void create(Student params) {

        int studentID = params.getStudentId();
        String address = params.getAdress();
        String name = params.getName();
        String email = params.getEmail();
        String dayOfBirth = String.valueOf(params.getDayOfBirth());
        String gender = params.getGender();
        String city = params.getCity();
        String country = params.getCountry();
        String postalCode = params.getPostalCode();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Persons(Email, Name, DayofBirth, Gender,Address, City, Country, PostalCode) VALUES ('%s', '%s', '1997-02-16','%s','%s','%s','%s','%s') INSERT INTO Students(Email) VALUES ('%s')",
                email, name, gender, address, city, country, postalCode, email));
    }

    @Override
    public Student get(int id) {

        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT * FROM Persons INNER JOIN Students ON Students.Email = Persons.Email WHERE StudentID = %d",
                id));
        Student student = new Student(null, null, null, null, null, null, null, null, 0);

        try {
            
            while (rs.next()) {
                student.setStudentId(rs.getInt("StudentID"));
                student.setEmail(rs.getString("Email"));
                student.setAdress(rs.getString("Address"));
                student.setName(rs.getString("Name"));
                student.setDayOfBirth(rs.getDate("DayOfBirth"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));
                student.setCountry(rs.getString("Country"));
                student.setPostalCode(rs.getString("PostalCode"));
            //    System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student get(String name) {

        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT TOP 1 * FROM Persons INNER JOIN Students ON Students.Email = Persons.Email WHERE Persons.Name LIKE '%%%s%%'",
                name));

        Student student = new Student(null, null, null, null, null, null, null, null, 0);

        try {
            while (rs.next()) {
                student.setStudentId(rs.getInt("StudentID"));
                student.setEmail(rs.getString("Email"));
                student.setAdress(rs.getString("Address"));
                student.setName(rs.getString("Name"));
                student.setDayOfBirth(rs.getDate("DayOfBirth"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));
                student.setCountry(rs.getString("Country"));
                student.setPostalCode(rs.getString("PostalCode"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public ArrayList<Student> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Persons INNER JOIN Students ON Students.Email = Persons.Email");
        ArrayList<Student> studentsList = new ArrayList<Student>();

        try {
            while (rs.next()) {

                Student student = new Student(null);
                student.setStudentId(rs.getInt("StudentID"));
                student.setEmail(rs.getString("Email"));
                student.setAdress(rs.getString("Address"));
                student.setName(rs.getString("Name"));
                student.setDayOfBirth(rs.getDate("DayOfBirth"));
                student.setGender(rs.getString("Gender"));
                student.setCity(rs.getString("City"));
                student.setCountry(rs.getString("Country"));
                student.setPostalCode(rs.getString("PostalCode"));
                studentsList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }



    @Override
    public void update(int id, String email) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format(
                "UPDATE Persons SET Persons.Email = '%s' WHERE Persons.Email =(SELECT Students.Email FROM Persons INNER JOIN Students ON Students.Email = Persons.Email WHERE StudentID = %d)",
                email, id));
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Students WHERE StudentID = %d", id));

    }
    public List<Course> getStudentCourse(int studentId) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT Courses.CourseName FROM Courses INNER JOIN Registrations ON Registrations.CourseID = Courses.CourseID INNER JOIN Students ON Students.StudentID = Registrations.StudentID WHERE Students.StudentID = %d", studentId));
        
        List<Course> list = new ArrayList<Course>();

        try {
            while (rs.next()) {
                Course course = new Course(studentId, null, null, null, null, null, null);
                course.setCourseName(rs.getString("CourseName"));
                list.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Certificate> getStudentCertificate(int studentId) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT Certificate.Name FROM CertificateIssuance INNER JOIN Certificate ON CertificateIssuance.CertificateID = Certificate.CertificateID WHERE StudentID = %d", studentId));

        List<Certificate> list = new ArrayList<Certificate>();

        try {
            while (rs.next()) {
                Certificate certificate = new Certificate(null,null,0);
                certificate.setName(rs.getString("Name"));
                list.add(certificate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Module> getStudentCourseModules(int studentId, int courseId) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT Modules.Titel, Progress.Progress FROM Progress INNER JOIN ContentItems ON ContentItems.ContentItemID = Progress.ContentItemID INNER JOIN Modules ON ContentItems.ContentItemID = Modules.ContentItemID WHERE StudentId = %d AND CourseID = %d", studentId,courseId));

        List<Module> list = new ArrayList<Module>();

        try {
            while (rs.next()) {
                Module module = new Module(courseId, null, null, null, null, null, null, null);
                module.setTitle(rs.getString("Titel"));
                module.setAvarageProgress(rs.getString("Progress"));
                list.add(module);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
