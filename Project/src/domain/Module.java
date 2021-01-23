package domain;

import java.sql.Date;

public class Module extends ContentItem {

    private double version;
    private String description;
    private String contactName;
    private String contactEmail;
    private String avarageProgress;



    public Module(double version, String description, String contactName, 
        String contactEmail,Course linkedCourse, Status status, Date publicationDate, String title) {
        super(linkedCourse, status, publicationDate, title);
        this.version = version;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public double getVersion() {
        return this.version;
    }

    public void setVersion(double version) {
        this.version = version;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getAvarageProgress() {
        return this.avarageProgress;
    }

    public void setAvarageProgress(String avarageProgress) {
        this.avarageProgress = avarageProgress;
    }
    
    @Override
    public String toString() {
        return "{" +
            " version='" + getVersion() + "'" +
            ", serialNumber='" + "'" +
            ", description='" + getDescription() + "'" +
            ", contactName='" + getContactName() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            super.toString() +
            "}";
    }

}
