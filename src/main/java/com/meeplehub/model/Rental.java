package com.meeplehub.model;


public abstract class Rental {
    private final long id;
    private final Customer customer;
    private final GameCopy copy;
    private final double deposit;

    public Rental(long id, Customer customer, GameCopy copy, double deposit) {
        this.id = id;
        this.customer = customer;
        this.copy = copy;
        this.deposit = deposit;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public GameCopy getGameCopy() {
        return copy;
    }

    public double getDeposit() {
        return deposit;
    }
    public abstract double calculatePrice();
}
