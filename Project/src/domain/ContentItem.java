package domain;

import java.sql.Date;

public abstract class ContentItem {

    private Course linkedCourse;
    private Status status;
    private Date publicationDate;
    private String title;

    public ContentItem(Course linkedCourse, Status status, Date publicationDate, String title) {
        this.linkedCourse = linkedCourse;
        this.status = status;
        this.publicationDate = publicationDate;
        this.title = title;
    }

    public Course getLinkedCourse() {
        return this.linkedCourse;
    }

    public void setLinkedCourse(Course linkedCourse) {
        this.linkedCourse = linkedCourse;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "{" +
            " linkedCourse='" + getLinkedCourse() + "'" +
            ", status='" + getStatus() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }
    

}
