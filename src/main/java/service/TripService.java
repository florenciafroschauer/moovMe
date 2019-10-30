package service;

import model.*;

import java.util.Date;

/**
 *  --COMPLETADO--
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

    public void setAsset(Asset asset) {

        trip.setAsset(asset);

    }

    public void setZone(Zone zone) {

        trip.setZone(zone);
    }

    public void setTerminal(Terminal terminal){

        trip.setTerminal(terminal);

    }

    public void setDiscount(Discount discount){

        trip.setDiscount(discount);

    }

    public void setTime(Date date){

        trip.setTripTime(date);
    }

    public Integer calculateTariff(Trip trip, Discount discount, Fine fine){ /** la tarifa depende de precio del activo por minuto, tiempo viajado, zona, descuento y multa */




        Integer tripValue = (Integer)(trip.getTripTime().getMinutes()) *  trip.getAsset().getType().getPricePerMinute() * trip.getZone().getRate();


        if(discount != null){

           tripValue = tripValue + discount.getPercent();
        }
        if(fine != null){

            tripValue = tripValue + fine.getFineValue();
        }

        return tripValue;
    }

    public Integer givePoints(Integer awardedPoints, Trip trip){ /** los puntos ganados dependen de la cantidad de tiempo viajado y el valor de puntos del activo */


        awardedPoints = (Integer)(trip.getTripTime().getMinutes()) * trip.getAsset().getType().getScorePerMinute();

        return awardedPoints;

    }

}
