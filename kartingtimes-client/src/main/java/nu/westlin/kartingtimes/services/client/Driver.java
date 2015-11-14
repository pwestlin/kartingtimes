package nu.westlin.kartingtimes.services.client;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Driver")
public class Driver {

    protected Long id;
    protected String firstName;
    protected String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override public String toString() {
        return "Driver{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            '}';
    }
}
