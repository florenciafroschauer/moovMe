package service;

import model.*;
import util.Fine;
import util.Hour;
import util.Tariff;
import util.ToPlan;

/**
 * Setear un asset.
 * Setear zona.
 * Setear terminal.
 * Setear discount.
 * Elegir tiempo del viaje.
 * Otorgar puntos (puntos por minuto del viaje).
 * Calcular tarifa (por zona se agrega un porcentaje al valor del viaje y tener en cuenta que
 * se pueden sumar multas, despues supongo que por minuto de viaje se cobrara cierto precio
 * dependiendo del activo, capaz haya que agregarle eso al asset)
 */

public class TripService {
    private Trip trip;

    // test

    public TripService(Trip trip) {
        this.trip = trip;
    }

    public void setZone(Zone zone) {
        if (trip.getTripState().equals(new ToPlan(trip))) {
            trip.setZone(zone);
        }
    }

    public void setAsset(Asset asset) {
        if (trip.getTripState().equals(new ToPlan(trip))) {
            trip.setAsset(asset);
        }
    }

    public void setTripTime(Hour hour) {
        if (trip.getTripState().equals(new ToPlan(trip))) {
            trip.setTripTime(hour);
        }
    }

    public void setDiscount(Discount discount){
        if (trip.getTripState().equals(new ToPlan(trip))) {
            trip.setDiscount(discount);
        }
    }

    public void setTerminalToHandOver(Terminal terminal) {
        if (trip.getTripState().equals(new ToPlan(trip))) {
            trip.setTerminalToHandOver(terminal);
        }
    }

    public double setTariff( Discount discount, Fine fine) {
        double tripValue = trip.getTariff().calculateTariff(trip, discount, fine);

        Tariff tariff = new Tariff(tripValue);

        trip.setTariff(tariff);

        return trip.getTariff().getTripValue();
    }

    public Integer setScore() {
        Integer score = trip.getTripTime().getMinute() *
                trip.getAsset().getType().getScorePerMinute();

        trip.setScore(score);

        return score;
    }
}
