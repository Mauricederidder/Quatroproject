package domain;

import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private Level level;
    private String subject;
    private String introduction;
    private String description;
    private List<ContentItem> contentItems;

    public Course(int courseId, String courseName, Level level, String subject, String introduction, String description, List<ContentItem> contentItems) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.level = level;
        this.subject = subject;
        this.introduction = introduction;
        this.description = description;
        this.contentItems = contentItems;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ContentItem> getContentItems() {
        return this.contentItems;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    
    


}
