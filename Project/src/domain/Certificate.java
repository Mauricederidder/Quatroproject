package domain;

public class Certificate {

    private String name;
    private String difficulty;
    private int courseId;
    // TODO:: Implementeer certificate

    public Certificate(String name, String difficulty, int courseId) {
        this.name = name;
        this.difficulty = difficulty;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCourseId(){
        return this.courseId;
    }

    public void setCourseId(int courseId){
        this.courseId = courseId;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Name: %s \n", this.name);
    }

}
