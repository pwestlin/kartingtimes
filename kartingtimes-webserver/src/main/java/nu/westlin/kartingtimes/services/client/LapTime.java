package nu.westlin.kartingtimes.services.client;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("LapTime")
public class LapTime {

    protected Long id;
    protected Long driverId;
    protected Long trackId;
    protected Integer time;

    protected Driver driver;
    protected Track track;

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override public String toString() {
        return "LapTime{" +
            "id=" + id +
            ", driverId=" + driverId +
            ", trackId=" + trackId +
            ", time=" + time +
            ", driver=" + driver +
            ", track=" + track +
            '}';
    }
}
