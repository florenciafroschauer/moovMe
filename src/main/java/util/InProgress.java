package util;

import model.Trip;

public class InProgress extends TripState {
    private Trip trip;


    @Override
    public void planificate() {
        throw new RuntimeException("This trip is in progress");
    }

    @Override
    public void start() {
        trip.setTripState(this);
    }

    @Override
    public void finish() {
        throw new RuntimeException("This trip is in progress");

    }
}
