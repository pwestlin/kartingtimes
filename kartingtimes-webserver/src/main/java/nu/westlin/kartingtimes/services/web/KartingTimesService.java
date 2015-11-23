package nu.westlin.kartingtimes.services.web;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class KartingTimesService {

    protected DriverRepository driverRepository;
    protected TrackRepository trackRepository;
    protected LaptimesRepository lapTimeRepository;

    @Inject
    public KartingTimesService(DriverRepository driverRepository, TrackRepository trackRepository,
                               LaptimesRepository lapTimeRepository) {
        this.driverRepository = driverRepository;
        this.trackRepository = trackRepository;
        this.lapTimeRepository = lapTimeRepository;
    }

    public List<Driver> drivers() {
        return driverRepository.getDrivers();
    }

    public List<Driver> findDriverByFirstName(String firstName) {
        return driverRepository.findByFirstName(firstName);
    }

    public List<Track> tracks() {
        return trackRepository.getTracks();
    }

    public List<LapTime> lapTimesOnAllTracksForDriver(Long driverId) {
        List<LapTime> lapTimes = lapTimeRepository.getLapTimeByDriver(driverId);

        // TODO petves: Optimera
        // TODO petves: Lambda
        for (LapTime lapTime : lapTimes) {
            lapTime.setDriver(driverRepository.getDriver(lapTime.getDriverId()));
            lapTime.setTrack(trackRepository.getTrack(lapTime.getTrackId()));
        }

        return lapTimes;
    }

    public List<LapTime> lapTimesOnOneTrackAllDrivers(Long trackId) {
        List<LapTime> lapTimes = lapTimeRepository.getLapTimeByTrack(trackId);

        // TODO petves: Optimera
        // TODO petves: Lambda
        for (LapTime lapTime : lapTimes) {
            lapTime.setDriver(driverRepository.getDriver(lapTime.getDriverId()));
            lapTime.setTrack(trackRepository.getTrack(lapTime.getTrackId()));
        }

        return lapTimes;
    }

    public List<LapTime> lapTimesOnTrackForDriver(Long driverId, Long trackId) {
        List<LapTime> lapTimes = lapTimeRepository.getLapTimeByTrackAndDriver(driverId, trackId);

        Driver driver = driverRepository.getDriver(driverId);
        Track track = trackRepository.getTrack(trackId);

        // TODO petves: Lambda
        for (LapTime lapTime : lapTimes) {
            lapTime.setDriver(driver);
            lapTime.setTrack(track);
        }

        return lapTimes;
    }
}
