package com.meeplehub.model;

public class HourlyRental extends Rental {
    private final int hours;
    private final double ratePerHour;

    public HourlyRental(long id, Customer customer, GameCopy copy, double deposit, int hours, double ratePerHour) {
        super(id, customer, copy, deposit);
        this.hours = hours;
        this.ratePerHour = ratePerHour;
    }

    public int getHours() {
        return hours;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    @Override
    public double calculatePrice() {
        return hours * ratePerHour;
    }
}
