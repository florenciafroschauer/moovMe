package repository;

import model.Client;
import model.Trip;

public class TripRepository extends AbstractRepository<Trip> {

    private static TripRepository tripRepository;

    private TripRepository() {
        create(new Trip(new Client("Agus", "123", 123, "Agus")));
        create(new Trip(new Client("Flor", "1234", 1234, "Flor")));
        create(new Trip(new Client("Santi", "1235", 12345, "Santi")));
    }

    public static TripRepository getInstance() {
        if (tripRepository != null) {
            return tripRepository;
        } else {
            tripRepository = new TripRepository();
        }

        return tripRepository;
    }
}
