package domain;

import java.sql.Date;

public class Webcast extends ContentItem {

    private String speaker;
    private String organisation;
    private int duration;
    private String url;

    public Webcast(String speaker, String organisation, int duration, String url,Course linkedCourse, Status status, Date publicationDate, String title) {
        super(linkedCourse, status, publicationDate, title);
        this.speaker = speaker;
        this.organisation = organisation;
        this.duration = duration;
        this.url = url;
    }

    public String getSpeaker() {
        return this.speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getOrganisation() {
        return this.organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
            " speaker='" + getSpeaker() + "'" +
            ", organisation='" + getOrganisation() + "'" +
            ", duration='" + getDuration() + "'" +
            ", url='" + getUrl() + "'" +
            super.toString() +
            "}";
    }

}
