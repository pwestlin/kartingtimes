package nu.westlin.kartingtimes.services.web;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(String firstName) {
        super("Driver not found: " + firstName);
    }
}
