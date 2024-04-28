package com.cleanCode.CCJen.ejercicio2;

public class Address {
    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    public String formatAddress() {

        return country + ", " +
                city+", "+
                street+", "+
                house+" "+
                quarter;
    }

}
