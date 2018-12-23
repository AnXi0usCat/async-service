package com.mishas.stuff.as.persistence.model;


import com.mishas.stuff.as.web.dto.SomeDto;
import org.springframework.data.annotation.Id;

public class SomeModel {

    @Id
    private String id;
    private String firstname;
    private String surname;

    public SomeModel() {
        super();
    }

    public SomeModel(String id, String firstname, String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public SomeModel(SomeDto someDto) {
        this.id = someDto.getId();
        this.firstname = someDto.getFirstname();
        this.surname = someDto.getSurname();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "SomeModel{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
