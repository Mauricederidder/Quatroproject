import database.StudentRepo;

public class App {
    public static void main(String[] args) throws Exception {
        StudentRepo repo = new StudentRepo();
        System.out.println(repo.get(1).getName());
    
        // hey ik ben Noah :)
    }
}
