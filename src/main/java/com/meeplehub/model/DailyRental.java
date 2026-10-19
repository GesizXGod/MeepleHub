package com.meeplehub.model;

public class DailyRental extends Rental {
    private final int days;
    private final double ratePerDay;

    public DailyRental(long id, Customer customer, GameCopy copy, double deposit,
                       int days, double ratePerDay) {
        super(id, customer, copy, deposit);
        this.days = days;
        this.ratePerDay = ratePerDay;
    }

    @Override
    public double calculatePrice() {
        return days * ratePerDay;
    }
}