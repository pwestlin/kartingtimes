package nu.westlin.kartingtimes.drivers;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_DRIVER")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Long nextId = 0L;

    @Id
    protected Long id;

    protected String firstName;

    protected String surname;

    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }

    /**
     * Default constructor for JPA only.
     */
    protected Driver() {
    }

    public Driver(String firstName, String surname) {
        id = getNextId();
        this.firstName = firstName;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    /**
     * Set JPA id - for testing and JPA only. Not intended for normal use.
     *
     * @param id The new id.
     */
    protected void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String DriverNumber) {
        this.firstName = DriverNumber;
    }

    public String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
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
