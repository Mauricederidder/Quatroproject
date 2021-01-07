package domain;

import java.security.cert.Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Course> courses;
    private List<CourseCertificate> authorisedCertificates;
    private int studentId;

    public Student(String Email, String name, Date dayOfBirth, String gender, String adress, String city,
            String country, String postalCode, int studentId) {

        super(Email, name, dayOfBirth, gender, adress, city, country, postalCode);

        this.studentId = studentId;

        this.authorisedCertificates = new ArrayList<>();
        this.courses = new ArrayList<>();

    }

    // delete after vertical slice
    public Student(String Email) {
        super(Email);

        this.studentId = 1;

        this.authorisedCertificates = new ArrayList<>();
        this.courses = new ArrayList<>();

    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<CourseCertificate> getAuthorisedCertificates() {
        return this.authorisedCertificates;
    }

    public void setAuthorisedCertificates(List<CourseCertificate> authorisedCertificates) {
        this.authorisedCertificates = authorisedCertificates;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    @Override
    public String toString() {
        return String.format(" StudentID: %d \n Name: %s \n Email: %s \n Day of Birth: %s \n Gender: %s \n Address: %s \n City: %s \n Country: %s \n PostalCode: %s \n ",
                this.studentId, this.getName(), this.getEmail(),this.getDayOfBirth(), this.getGender(), this.getAdress(),this.getCity(), this.getCountry(), this.getPostalCode());
    }
    public void signup(Course course){
        // add to list
        this.courses.add(course);       
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
    }
    public void addCertificate(CourseCertificate certificate){
        this.authorisedCertificates.add(certificate);
    }
    public void removeCertificate(CourseCertificate certificate){
        this.authorisedCertificates.remove(certificate);
    }
}
