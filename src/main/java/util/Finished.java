package util;

import model.Trip;

public class Finished extends TripState {
    private Trip trip;

    @Override
    public void planificate() {
        throw new RuntimeException("This trip is finished");
    }

    @Override
    public void start() {
        throw new RuntimeException("This trip is finished");
    }

    @Override
    public void finish() {
        trip.setTripState(this);
    }
}
