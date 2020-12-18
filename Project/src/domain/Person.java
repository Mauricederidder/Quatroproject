package domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
}
