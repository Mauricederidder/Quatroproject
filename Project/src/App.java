import java.security.cert.CRLReason;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import database.CourseRepo;
import database.RegistrationsRepo;
import database.StudentRepo;
import database.oldCrud;
import domain.Person;
import domain.Student;

public class App {


	public static void main(String[] args)  {
        StudentRepo repo = new StudentRepo();
        repo.get();
        // hey ik ben Noah :)
    }
}
