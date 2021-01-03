package domain;

public class CourseCertificate {
    
    private int certificateId;
    private int rating;
    private Course linkedCourse;

    public CourseCertificate(int certificateId, int rating, Course linkedCourse){
        this.certificateId = certificateId;
        this.rating = rating;
        this.linkedCourse = linkedCourse;
    }

    public int getCertificateId() {
        return this.certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Course getLinkedCourse() {
        return this.linkedCourse;
    }

    public void setLinkedCourse(Course linkedCourse) {
        this.linkedCourse = linkedCourse;
    }
}
