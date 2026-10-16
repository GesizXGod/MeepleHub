package com.meeplehub.model;

public class WaitListEntry {
    private final Customer customer;
    private final long order;

    public WaitListEntry(Customer customer, long order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getOrder() {
        return order;
    }
}
