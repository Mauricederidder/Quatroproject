package domain;

public class CourseAndTag {
    private String tag;
    private String courseName;
    private String studentsPerCourse;

    public CourseAndTag(String tag, String courseName, String studentsPerCourse) {
        this.tag = tag;
        this.courseName = courseName;
        this.studentsPerCourse = studentsPerCourse;
    }

    public String getTags() {
        return this.tag;
    }

    public void setTags(String tag) {
        this.tag = tag;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentsPerCourse() {
        return this.studentsPerCourse;
    }

    public void setStudentsPerCourse(String studentsPerCourse) {
        this.studentsPerCourse = studentsPerCourse;
    }


}   
