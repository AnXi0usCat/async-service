package com.mishas.stuff.as.web.dto;

import com.mishas.stuff.as.persistence.model.SomeModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SomeDto implements Serializable {

    @NotNull
    private String id;
    @NotNull
    @Size(min = 12, max = 12)
    private String firstname;
    @NotNull
    @Size(min = 12, max = 12)
    private String surname;

    public SomeDto() {
        super();
    }

    public SomeDto(
            CompletableFuture<String> id,
            CompletableFuture<String> firstname,
            CompletableFuture<String> surname
    ) throws InterruptedException , ExecutionException {
        this.id = id.get();
        this.firstname = firstname.get();
        this.surname = surname.get();
    }

    public SomeDto(SomeModel someModel) {
        this.id = someModel.getId();
        this.firstname = someModel.getFirstname();
        this.surname = someModel.getSurname();
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SomeDto)) return false;
        SomeDto someDto = (SomeDto) o;
        return Objects.equals(id, someDto.id) &&
                Objects.equals(firstname, someDto.firstname) &&
                Objects.equals(surname, someDto.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, surname);
    }

    @Override
    public String toString() {
        return "SomeDto{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
