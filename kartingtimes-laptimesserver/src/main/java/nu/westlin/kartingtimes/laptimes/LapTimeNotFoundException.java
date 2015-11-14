package nu.westlin.kartingtimes.laptimes;

public class LapTimeNotFoundException extends RuntimeException {

    public LapTimeNotFoundException(long id) {
        super("LapTime not found: " + id);
    }

    public LapTimeNotFoundException(String name) {
        super("Track not found: " + name);
    }
}
