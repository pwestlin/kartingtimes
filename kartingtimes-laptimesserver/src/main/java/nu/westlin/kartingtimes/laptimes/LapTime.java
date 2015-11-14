package nu.westlin.kartingtimes.laptimes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_LAPTIME")
public class LapTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    protected Long id;

    protected Long driverId;

    protected Long trackId;

    protected Integer time;

    /**
     * Default constructor for JPA only.
     */
    protected LapTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override public String toString() {
        return "LapTime{" +
            "id=" + id +
            ", driverId=" + driverId +
            ", trackId=" + trackId +
            ", time=" + time +
            '}';
    }
}
