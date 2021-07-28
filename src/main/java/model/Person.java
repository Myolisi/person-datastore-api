package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

    //@JsonPropertyOrder({ "id", "firstName", "secondName", "thirdName", "dateCreated" })
    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String surname;
    private String identifier;
    private boolean isPassport;
    private int fkCountryId;

    private List<Telephone> telephones;

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateModified;

    public int getFkCountryId() {
        return fkCountryId;
    }
    public boolean isPassport() {
        return isPassport;
    }
    public void setPassport(boolean passport) {
        isPassport = passport;
    }
    public void setFkCountryId(int fkCountryId) {
        this.fkCountryId = fkCountryId;
    }

    //gets and sets Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //gets and sets first name
    //@JsonGetter("First Name")
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //gets and sets secondName
    //@JsonGetter("Second Name")
    public String getSecondName() {
        return this.secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    //gets and sets third name
    //@JsonGetter("Third Name")
    public String getThirdName() {
        return thirdName;
    }
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    //gets and sets surname
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getIdentifier() {
        return this.identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    ////gets and sets dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    //gets and sets Date_modified
    //@JsonGetter("Date Modified")
    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
