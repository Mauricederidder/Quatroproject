package domain;

import java.security.cert.Certificate;
import java.sql.Date;

public class Employee extends Person {
    
    private int employeeID;

    public Employee(int employeeID, String Email, String name, Date dayOfBirth, String gender, String adress, String city,String country, String postalCode) {
        super(Email, name, dayOfBirth, gender, adress, city, country, postalCode);
        this.employeeID = employeeID;
    }

    public void giveCertificate(CourseCertificate certificate, Student student){
        student.addCertificate(certificate);
    }
    public void removeCertificate(CourseCertificate certificate, Student student){
        student.removeCertificate(certificate);
    }
}
