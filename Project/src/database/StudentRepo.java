package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.Person;
import domain.Student;

public class StudentRepo implements Crud<Student> {

    @Override
    public void create(Student params) {

        int studentID = params.getStudentId();
        String address = params.getAdress();
        String name = params.getName();
        String email = params.getEmail();
        Date dayOfBirth = params.getDayOfBirth();
        String gender = params.getGender();
        String city = params.getCity();
        String country = params.getCountry();
        String postalCode = params.getPostalCode();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Persons(Email, Name, DayofBirth, Gender,Address, City, Country, PostalCode) VALUES ('%s', '%s', '%t','%s','%s','%s','%s','%s') INSERT INTO Students(Email) VALUES ('%s')",
                email, name, gender, dayOfBirth, address, city, country, postalCode, email));
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
                System.out.println(student);
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
            for (Student i : studentsList) {
                System.out.println(i);
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

}
