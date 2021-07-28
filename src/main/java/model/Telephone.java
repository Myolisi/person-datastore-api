package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Telephone{

    private int id;

    private String telephoneType;

    private int fkTelephoneTypeId;
    private String number;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkTelephoneTypeId() {
        return fkTelephoneTypeId;
    }

    public void setFkTelephoneTypeId(int fkTelephoneTypeId) {
        this.fkTelephoneTypeId = fkTelephoneTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }
}
