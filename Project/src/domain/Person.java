package domain;

import java.sql.Date;

public abstract class Person {
    // Attributes

    private String Email;
    private String name;
    private Date dayOfBirth;
    private String gender;
    private String adress;
    private String city;
    private String country;
    private String postalCode;

    // constructor 
    public Person(String Email, String name, Date dayOfBirth, String gender, String adress, String city, String country, String postalCode) {
        this.Email = Email;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    // getters and setters
    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayOfBirth() {
        return this.dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return 
            " Email='" + getEmail() + "'" +
            ", name='" + getName() + "'" +
            ", dayOfBirth='" + getDayOfBirth() + "'" +
            ", gender='" + getGender() + "'" +
            ", adress='" + getAdress() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", postalCode='" + getPostalCode() + "'";
    }

}
