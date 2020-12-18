import java.sql.*;

public class Main {

    public static void main(String[] args) {

        CRUD crud = new CRUD();
        crud.delete(1);
        crud.read();
        crud.create(1, "noah.cristiaan@gmail.com");
        crud.read();
        
       // crud.update(1, "noahdekeijzer@gmail.com");
       // crud.read();
    }
}
