package com.company;

import java.util.ArrayList;
import java.util.Date;

public class AKniga {
    private int number;
    private String surname;
    private String name;
    private String middlename;
    private Date birthday;
    private ArrayList<String> phones;
    private Date editDate;

    public AKniga(int number, String surname, String name, String middlename, Date birthday, ArrayList<String> phones, Date editDate)
    {
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.phones = phones;
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("AKniga{")
                .append("number: ").append(number).append(",")
                .append("surname: ").append(surname).append(",")
                .append("name: ").append(name).append(",")
                .append("middlename: ").append(middlename).append(",")
                .append("birthday: ").append(birthday).append(",")
                .append("phones: ").append(phones).append(",")
                .append("editDate: ").append(editDate).append("}")
                .toString();
    }

}
