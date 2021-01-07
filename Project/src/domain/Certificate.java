package domain;

public class Certificate {

    private int certificateId;
    private int rating;
    private String name;
    private String difficulty;
    // TODO:: Implementeer certificate

    public Certificate(int certificateId, String name, int rating, String difficulty) {
        this.certificateId = certificateId;
        this.rating = rating;
        this.name = name;
        this.difficulty = difficulty;
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(" CertificateID: %d \n Name: %s \n Rating: %d \n", this.certificateId, this.name,
                this.rating);
    }

}
