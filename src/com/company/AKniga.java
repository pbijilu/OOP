package com.company;

import java.util.ArrayList;
import java.util.Date;

public class AKniga {
    private String surname;
    private String name;
    private String middlename;
    private Date birthday;
    private ArrayList<String> phones;
    private String address;
    private Date editDate;

    AKniga(String surname, String name, String middlename, Date birthday, ArrayList<String> phones, String address, Date editDate)
    {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.phones = phones;
        this.address = address;
        this.editDate = editDate;
    }
    public String getSurname(){
        return surname;
    }
    public Date getBirthday(){
        return  birthday;
    }
    public String getName(){
        return name;
    }
    public Date getEditDate(){
        return editDate;
    }
    @Override
    public String toString() {
        return  surname + " " + name + " " + middlename + " " +
                Main.getFormat().format(birthday) + " " +
                phones + " " +
                address + " " +
                Main.getFormat().format(editDate);
    }

    String toFile() {
        return  surname + "%" + name + "%" + middlename + "%" +
                Main.getFormat().format(birthday) + "%" +
                phones + "%" +
                address + "%" +
                Main.getFormat().format(editDate) + "%";
    }

}
