package nu.westlin.kartingtimes.services.client;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(String firstName) {
        super("Driver not found: " + firstName);
    }
}
