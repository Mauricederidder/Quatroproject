import java.security.cert.CRLReason;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import database.CertificateRepo;
import database.CourseRepo;
import database.ModuleRepo;
import database.StudentRepo;
import domain.Certificate;
import domain.Person;
import domain.Student;

public class App {


	public static void main(String[] args)  {
        CertificateRepo repo = new CertificateRepo();
        repo.mostCertificatesGiven();
        // hey ik ben Noah :)
    }
}
