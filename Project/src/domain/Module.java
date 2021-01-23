package domain;

import java.sql.Date;

public class Module extends ContentItem {

    private double version;
    private int serialNumber;
    private String description;
    private String contactName;
    private String contactEmail;

    public Module(double version, int serialNumber, String description, String contactName, 
        String contactEmail,Course linkedCourse, int contentItemId, Status status, Date publicationDate, String title) {
        super(linkedCourse, contentItemId, status, publicationDate, title);
        this.version = version;
        this.serialNumber = serialNumber;
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

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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

    @Override
    public String toString() {
        return "{" +
            " version='" + getVersion() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", description='" + getDescription() + "'" +
            ", contactName='" + getContactName() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            super.toString() +
            "}";
    }

}
