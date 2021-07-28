package model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PersonTelephone  {


    private int id;
    private boolean isCurrent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dateModified;
    private int fkPersonId;
    private int fkTelephoneId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
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

    public int getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(int fkPersonId) {
        this.fkPersonId = fkPersonId;
    }

    public int getFkTelephoneId() {
        return fkTelephoneId;
    }

    public void setFkTelephoneId(int fkTelephoneId) {
        this.fkTelephoneId = fkTelephoneId;
    }

}
