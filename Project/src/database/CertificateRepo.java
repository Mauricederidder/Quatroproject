package database;

import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Certificate;

public class CertificateRepo implements Crud<Certificate> {

    @Override
    public void create(Certificate params) {
        int certificateID = params.getCertificateId();
        String certificateName = params.getName();
        int rating = params.getRating();
        String difficulty = params.getDifficulty();

        ResultSet rs = DatabaseConnection
                .execute(String.format("INSERT INTO Courses(Name, Rating, Difficulty) VALUES ('%s','%d','%s');",
                        certificateName, rating, difficulty));
    }

    @Override
    public Certificate get(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Certificate WHERE CertificateID = %d", id));
        Certificate certificate = new Certificate(0, null, 0, null);

        try {

            while (rs.next()) {

                certificate.setName(rs.getString("Name"));
                certificate.setCertificateId(rs.getInt("CertificateID"));
                certificate.setRating(rs.getInt("Subject"));

                System.out.println(certificate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificate;
    }

    @Override
    public Certificate get() {
        ResultSet rs = DatabaseConnection.execute("SELECT * FROM Certificate");
        ArrayList<Certificate> certificateList = new ArrayList<Certificate>();

        try {
            while (rs.next()) {

                Certificate certificate = new Certificate(0, null, 0, null);
                certificate.setCertificateId(rs.getInt("CertificateID"));
                certificate.setName(rs.getString("Name"));
                certificate.setRating(rs.getInt("Rating"));
                certificate.setDifficulty(rs.getString("Difficulty"));
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

}