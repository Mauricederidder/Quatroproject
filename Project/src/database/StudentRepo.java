package database;

import java.sql.ResultSet;

import domain.Person;
import domain.Student;
public class StudentRepo implements Crud<Student> {

    @Override
    public void create(Student params) {
        // TODO Auto-generated method stub

    }


    @Override
    public Student get(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT * FROM Cursisten WHERE StudentID = %d", id));
        Student student = new Student(null);
     
        return student;
    }

    @Override
    public Student get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(int id, Student params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }


}
