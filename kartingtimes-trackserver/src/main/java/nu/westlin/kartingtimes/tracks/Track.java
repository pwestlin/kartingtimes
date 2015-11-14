package nu.westlin.kartingtimes.tracks;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_TRACK")
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    protected Long id;

    protected String name;

    protected String location;

    /**
     * Default constructor for JPA only.
     */
    protected Track() {
    }

    public Track(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getName() {
        return name;
    }

    protected void setName(String DriverNumber) {
        this.name = DriverNumber;
    }

    public String getLocation() {
        return location;
    }

    protected void setLocation(String location) {
        this.location = location;
    }

    @Override public String toString() {
        return "Track{" +
            "id=" + id +
            ", firstName='" + name + '\'' +
            ", surname='" + location + '\'' +
            '}';
    }
}
