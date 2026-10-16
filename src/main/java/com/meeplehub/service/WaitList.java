package com.meeplehub.service;

import com.meeplehub.model.Customer;
import com.meeplehub.model.WaitListEntry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class WaitList {
    private long counter = 0;

    private final Queue<WaitListEntry> queue = new PriorityQueue<>(
            (e1, e2) -> {
                int byVip = Boolean.compare(e2.getCustomer().isVip(), e1.getCustomer().isVip());
                if (byVip != 0) {
                    return byVip;
                }
                return Long.compare(e1.getOrder(), e2.getOrder());
            });

    public void join(Customer customer) {
        counter++;
        queue.offer(new WaitListEntry(customer, counter));
    }

    public Customer next() {
        WaitListEntry entry = queue.poll();
        return entry == null ? null : entry.getCustomer();
    }

    public int size() {
        return queue.size();
    }
}