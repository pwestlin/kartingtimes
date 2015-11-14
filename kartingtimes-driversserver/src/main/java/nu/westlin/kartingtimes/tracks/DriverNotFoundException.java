package nu.westlin.kartingtimes.tracks;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(long id) {
        super("No such driver: " + id);
    }

    public DriverNotFoundException(String firstName) {
        super("No such driver: " + firstName);
    }
}
