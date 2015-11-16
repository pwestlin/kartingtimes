package nu.westlin.kartingtimes.services.client;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Track")
public class Track {

    protected Long id;
    protected String name;
    protected String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override public String toString() {
        return "Track{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", location='" + location + '\'' +
            '}';
    }
}
