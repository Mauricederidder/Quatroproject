package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Module;

public class ModuleRepo implements Crud<Module> {

    @Override
    public void create(Module params) {
        String title = params.getTitle();
        double version = params.getVersion();
        String description = params.getDescription();
        String contactName = params.getContactName();
        String contactEmail = params.getContactEmail();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Modules(Title, Version, Description, SerialNumber, ContactPersonName, ContactPersonEmail) VALUES ('%s','%f','%s', %d ,'%s','%s')",
                title, version, description, contactName, contactEmail));
    }

    @Override
    public Module get(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT * FROM Persons INNER JOIN Students ON Students.Email = Persons.Email WHERE StudentID = %d",
                id));
        Module module = new Module(0, 0, null, null, null, null, 0, null, null, null);

        try {

            while (rs.next()) {
                module.setVersion(rs.getInt("Version"));
                module.setSerialNumber(rs.getInt("SerialNumber"));
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
    public Module get() {
        ResultSet rs = DatabaseConnection.execute(String.format("SELECT * FROM Modules INNER JOIN ContentItems ON ContentItems.ContentItemID = Modules.ContentItemID"));
        Module module = new Module(0, 0, null, null, null, null,0, null, null, null);
        ArrayList<Module> moduleList = new ArrayList<Module>();

        try {
            
            while (rs.next()) {
                module.setVersion(rs.getInt("Version"));
                module.setSerialNumber(rs.getInt("SerialNumber"));
                module.setDescription(rs.getString("Description"));
                module.setContactEmail(rs.getString("ContactPersonEmail"));
                module.setContactName(rs.getString("ContactPersonName"));
                moduleList.add(module);
            }
            for(Module i : moduleList){
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

    public List modulePerCourse(int id){
        ResultSet rs = DatabaseConnection.execute(String.format(
                "SELECT Modules.Titel AS Module FROM Modules INNER JOIN ContentItems ON Modules.ContentItemID = ContentItems.ContentItemID INNER JOIN Courses ON Courses.CourseID = ContentItems.CourseID WHERE Courses.CourseID = %d",
                id));

        List<String> modules = new ArrayList<>();

        try {
            while (rs.next()) {
                String module = rs.getString("Module");
                modules.add(module);
            }
            System.out.println(modules);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modules;
    }
    }
}
