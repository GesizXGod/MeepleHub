package com.meeplehub.repository;

import com.meeplehub.model.HasId;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Repository<T extends HasId> {
    private final Map<Long, T> items = new HashMap<>();

    public void save(T item) {
        items.put(item.getId(), item);
    }

    public T findById(long id) {
        return items.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(items.values());
    }

    public int count() {
        return items.size();
    }


}
