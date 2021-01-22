package database;

import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Module;

public class ModuleRepo implements Crud<Module> {

    @Override
    public void create(Module params) {
        double version = params.getVersion();
        int serialNumber = params.getSerialNumber();
        String description = params.getDescription();
        String contactName = params.getContactName();
        String contactEmail = params.getContactEmail();

        ResultSet rs = DatabaseConnection.execute(String.format(
                "INSERT INTO Modules(Version, Description, SerialNumber, ContactPersonName, ContactPersonEmail) VALUES ('%f','%s', %d ,'%s','%s')",
                version, description, contactName, contactEmail));
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
}
