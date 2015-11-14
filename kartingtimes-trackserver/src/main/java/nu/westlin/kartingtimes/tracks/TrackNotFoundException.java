package nu.westlin.kartingtimes.tracks;

public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(long id) {
        super("Track not found: " + id);
    }

    public TrackNotFoundException(String name) {
        super("Track not found: " + name);
    }
}
