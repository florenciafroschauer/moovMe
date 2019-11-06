package util;

import model.Trip;

public abstract class TripState {
    private Trip trip;

    public abstract void planificate();

    public abstract void start();

    public abstract void finish();
}
