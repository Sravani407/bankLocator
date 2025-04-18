package com.bankLocator.model;

public class latLon {
    private double lat;
    private double lng;

    public latLon(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
