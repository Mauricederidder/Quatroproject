package domain;

import java.sql.Date;

public abstract class ContentItem {

    private Course linkedCourse;
    private int contentItemId;
    private Status status;
    private Date publicationDate;
    private String title;

    public ContentItem(Course linkedCourse, int contentItemId, Status status, Date publicationDate, String title) {
        this.linkedCourse = linkedCourse;
        this.contentItemId = contentItemId;
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

    public int getContentItemId() {
        return this.contentItemId;
    }

    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
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
            ", contentItemId='" + getContentItemId() + "'" +
            ", status='" + getStatus() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }
    

}
