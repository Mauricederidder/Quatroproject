package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Certificate;

public class CertificateRepo implements Crud<Certificate> {

    @Override
    public void create(Certificate params) {
        
        String certificateName = params.getName();
        int courseId = params.getCourseId();
        String difficulty = params.getDifficulty();

        ResultSet rs = DatabaseConnection
                .execute(String.format("INSERT INTO Certificate(Name,CourseID, Difficulty) VALUES ('%s','%d','%s');",
                        certificateName,courseId, difficulty));
    }

    @Override
    public Certificate get(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Certificate WHERE CertificateID = %d", id));
        Certificate certificate = new Certificate(null, null,0);

        try {

            while (rs.next()) {

                certificate.setName(rs.getString("Name"));

                System.out.println(certificate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificate;
    }

    @Override
    public ArrayList<Certificate> get() {
        ResultSet rs = DatabaseConnection.execute("SELECT * FROM Certificate");
        ArrayList<Certificate> certificateList = new ArrayList<Certificate>();

        try {
            while (rs.next()) {

                Certificate certificate = new Certificate(null, null,0);
                certificate.setName(rs.getString("Name"));
                certificate.setDifficulty(rs.getString("Difficulty"));
                certificate.setCourseId(rs.getInt("CourseID"));
                certificateList.add(certificate);

            }
            for (Certificate i : certificateList) {
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
        ResultSet rs = DatabaseConnection.execute(String.format(
                "UPDATE Certificate SET Certificate.Name = '%s' WHERE Certificate.CertificateID = %d)", name, id));
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        ResultSet rs = DatabaseConnection
                .execute(String.format("DELETE FROM Certificate WHERE CertificateID = %d", id));

    }

    public List completionBasedOnGender() {
        ResultSet rs = DatabaseConnection.execute(
                "SELECT CourseName, COUNT(CertificateIssuance.StudentID) AS Total, COUNT(CASE WHEN Gender='man' THEN 1 END) AS Male, COUNT(CASE WHEN Gender='vrouw' THEN 1 END) AS Female FROM CertificateIssuance INNER JOIN Certificate ON Certificate.CertificateID = CertificateIssuance.CertificateID INNER JOIN Courses ON Certificate.CourseID = Courses.CourseID INNER JOIN Students ON CertificateIssuance.StudentID = Students.StudentID INNER JOIN Persons ON Persons.Email = Students.Email GROUP BY CourseName");

        List<String> completionBasedOnGender = new ArrayList<>();

        try {

            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                double totalStudents = rs.getDouble("Total");
                double totalMale = rs.getDouble("Male");
                double totalFemale = rs.getDouble("Female");
                double percentageMale = (totalMale / totalStudents) * 100;
                double percentageFemale = (totalFemale / totalStudents) * 100;
                completionBasedOnGender.add(courseName + " | Total: " + totalStudents + "  |  Male: " + percentageMale
                        + "%  |  Female: " + percentageFemale + "%  |  \n ");
            }
            System.out.println(completionBasedOnGender);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return completionBasedOnGender;
    }
    public List completionBasedOnGender(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT CourseName, COUNT(CertificateIssuance.StudentID) AS Total, COUNT(CASE WHEN Gender='man' THEN 1 END) AS Male, COUNT(CASE WHEN Gender='vrouw' THEN 1 END) AS Female FROM CertificateIssuance INNER JOIN Certificate ON Certificate.CertificateID = CertificateIssuance.CertificateID INNER JOIN Courses ON Certificate.CourseID = Courses.CourseID INNER JOIN Students ON CertificateIssuance.StudentID = Students.StudentID INNER JOIN Persons ON Persons.Email = Students.Email WHERE Certificate.CourseID = %d GROUP BY CourseName",id));

        List<String> completionBasedOnGender = new ArrayList<>();

        try {

            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                Double totalStudents = rs.getDouble("Total");
                Double totalMale = rs.getDouble("Male");
                Double totalFemale = rs.getDouble("Female");
                Double percentageMale = (totalMale / totalStudents) * 100;
                Double percentageFemale = (totalFemale / totalStudents) * 100;
                completionBasedOnGender.add(percentageMale.toString());
                completionBasedOnGender.add(percentageFemale.toString());
                // completionBasedOnGender.add(courseName + " | Total: " + totalStudents + "  |  Male: " + percentageMale
                //         + "%  |  Female: " + percentageFemale + "%  |  \n ");
            }
            System.out.println(completionBasedOnGender);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // if no one is subscribed to the course, add 0.
        if(completionBasedOnGender.isEmpty()){
            completionBasedOnGender.add("0");
            completionBasedOnGender.add("0");
        }
        return completionBasedOnGender;
    }
    public HashMap mostCertificatesGiven() {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT Courses.CourseName, COUNT(CertificateIssuance.CertificateID) AS AmountOfCertificates FROM Certificate INNER JOIN CertificateIssuance ON CertificateIssuance.CertificateID = Certificate.CertificateID INNER JOIN Courses ON Courses.CourseID = Certificate.CourseID GROUP BY Courses.CourseName ORDER BY COUNT(CertificateIssuance.CertificateID) DESC"));

        HashMap<String, Integer> mostCertificates = new HashMap<>();

        try {
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                int amount = rs.getInt("AmountOfCertificates");
                mostCertificates.put(courseName, amount);
            }
            for (String i : mostCertificates.keySet()) {
                System.out.println(i + " | Amount of certificates: " + mostCertificates.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mostCertificates;
    }
}