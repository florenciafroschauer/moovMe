package service;

import model.*;
import util.Fine;
import util.Tariff;
import util.ToPlan;

import java.util.Date;

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

    public void setZone(Zone zone) {
        if (trip.getTripState().equals(new ToPlan())) {
            trip.setZone(zone);
        }
    }

    public void setAsset(Asset asset) {
        if (trip.getTripState().equals(new ToPlan())) {
            trip.setAsset(asset);
        }
    }

    public void setTripTime(Date date) {
        if (trip.getTripState().equals(new ToPlan())) {
            trip.setTripTime(date);
        }
    }

    public void setDiscount(Discount discount){
        if (trip.getTripState().equals(new ToPlan())) {
            trip.setDiscount(discount);
        }
    }

    public void setTerminalToHandOver(Terminal terminal) {
        if (trip.getTripState().equals(new ToPlan())) {
            trip.setTerminalToHandOver(terminal);
        }
    }

    public double setTariff(Trip trip, Discount discount, Fine fine) {
        double tripValue = trip.getTariff().calculateTariff(trip, discount, fine);

        Tariff tariff = new Tariff(tripValue, trip.getAsset());

        trip.setTariff(tariff);

        return trip.getTariff().getTripValue();
    }

    public Integer setScore(Trip trip) {
        Integer score = (Integer)(trip.getTripTime().getMinutes()) *
                trip.getAsset().getType().getScorePerMinute();

        trip.setScore(score);

        return score;
    }
}
