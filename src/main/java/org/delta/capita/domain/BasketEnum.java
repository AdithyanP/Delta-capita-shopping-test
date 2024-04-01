package org.delta.capita.domain;


import java.math.BigDecimal;

public enum BasketEnum {

    Apple(35,false,""),
    Bananas(20,false,""),
    Melons(50,true,"BUY_ONE_GET_ONE"),
    Limes(15,true,"THREE_FOR_PRICE_OF_TWO");

    private final double paisa;
    private final boolean isOfferAvailable;
    private final String offer;

    BasketEnum(double paisa,boolean isOfferAvailable,String offer){
        this.paisa = paisa;
        this.offer = offer;
        this.isOfferAvailable = isOfferAvailable;
    }

    public double getPaisa() {
        return paisa;
    }

    public boolean isOfferAvailable() {
        return isOfferAvailable;
    }

    public String getOffer() {
        return offer;
    }
}
