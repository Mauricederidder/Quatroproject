package domain;

public class Certificate {
    
    private int certificateId;
    private int rating;

    public Certificate(int certificateId, int rating){

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

}
