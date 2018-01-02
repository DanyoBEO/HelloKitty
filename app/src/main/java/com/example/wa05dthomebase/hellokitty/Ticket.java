package com.example.wa05dthomebase.hellokitty;

/**
 * Created by WA05DTHOMEBASE on 12/12/2017.
 */

public class Ticket {
    int id;
    String employeeID;
    String shortDesc;
    String longDesc;
    public Ticket(int id, String EID, String descriptionShort, String descriptionLong ){
        this.id = id;
        employeeID = EID;
        shortDesc = descriptionShort;
        longDesc = descriptionLong;
    }

    public Ticket(){

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
