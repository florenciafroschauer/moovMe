package model;


/**
 Clase para diseñar las multas.

 Las multas tienen un precio base/minimo de $500
 */
public class Fine {

    private Zone zone;
    private Integer fineValue = 500 * zone.getRate();


    public Integer getFineValue() {
        return fineValue;
    }

    public void setFineValue(Integer fineValue) {
        this.fineValue = fineValue;
    }
}
