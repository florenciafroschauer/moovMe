package model;


/**
 Clase para diseñar las multas.

 Las multas tienen un precio base/minimo de $500
 */
public class Fine {

    private Zone zone;
    private int basePrice;
    private Integer fineValue;

    public Fine(Zone zone, int basePrice){
        this.zone = zone;
        this.basePrice = basePrice;
        this.fineValue = basePrice * zone.getRate();
    }

    public Integer getFineValue() {
        return fineValue;
    }

}
