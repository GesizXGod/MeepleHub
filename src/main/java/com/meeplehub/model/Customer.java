package com.meeplehub.model;

import java.util.Objects;

public class Customer {
    private final long id;
    private String name;
    private boolean vip;

    public Customer(long id, String name, boolean vip) {
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public boolean isVip() { return vip; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer other = (Customer) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}