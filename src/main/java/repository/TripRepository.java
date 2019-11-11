package repository;

import model.Trip;

public class TripRepository extends AbstractRepository<Trip> {

    private static TripRepository tripRepository;

    private TripRepository() {}

    public static TripRepository getInstance() {
        if (tripRepository != null) {
            return tripRepository;
        } else {
            tripRepository = new TripRepository();
        }

        return tripRepository;
    }
}
