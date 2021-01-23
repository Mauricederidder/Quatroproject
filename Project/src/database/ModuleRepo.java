package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Course;
import domain.Module;
import domain.Status;
import javafx.scene.chart.PieChart.Data;

public class ModuleRepo implements Crud<Module> {

    @Override
    public void create(Module params) {
        String title = params.getTitle();
        double version = params.getVersion();
        String description = params.getDescription();
        String contactName = params.getContactName();
        String contactEmail = params.getContactEmail();

        Status status = params.getStatus();
        // Date date = params.getPublicationDate();
        Course course = params.getLinkedCourse();
        int x = course.getCourseId();

        ResultSet rsci = DatabaseConnection.execute(String.format(
                "INSERT INTO ContentItems(Status, PublicationDate, CourseID) VALUES ('%s','2020-01-22','%s')", status,
                x));

        ResultSet getContentID = DatabaseConnection.execute(String.format("c"));
        int i = 0;
        try {
             i = getContentID.getInt("ContentItemID");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Modules(Titel, Version, Followers, Description, ContactPersonName, ContactPersonEmail, ContentItemID) VALUES ('%s',1.0,10,'%s','%s','%s','%d')",
                title, description, contactName, contactEmail, i));

    }

    @Override
    public Module get(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT * FROM Persons INNER JOIN Students ON Students.Email = Persons.Email WHERE StudentID = %d",
                id));
        Module module = new Module(0, null, null, null, null, null, null, null);

        try {

            while (rs.next()) {
                module.setVersion(rs.getInt("Version"));
                module.setDescription(rs.getString("Description"));
                module.setContactEmail(rs.getString("ContactPersonEmail"));
                module.setContactName(rs.getString("ContactPersonName"));
                System.out.println(module);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return module;
    }

    @Override
    public List<Module> get() {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT * FROM Modules INNER JOIN ContentItems ON ContentItems.ContentItemID = Modules.ContentItemID"));
        Module module = new Module(0, null, null, null, null, null, null, null);
        ArrayList<Module> moduleList = new ArrayList<Module>();

        try {

            while (rs.next()) {
                module.setVersion(rs.getInt("Version"));
                module.setDescription(rs.getString("Description"));
                module.setContactEmail(rs.getString("ContactPersonEmail"));
                module.setContactName(rs.getString("ContactPersonName"));
                moduleList.add(module);
            }
            for (Module i : moduleList) {
                System.out.println(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void update(int id, String params) {
        ResultSet rs = DatabaseConnection.execute(
                String.format("UPDATE Modules SET Modules.Titel = '%s' WHERE ContentItemID = %d)", params, id));
    }

    @Override
    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Modules WHERE ContentItemID = %d", id));
    }
}
