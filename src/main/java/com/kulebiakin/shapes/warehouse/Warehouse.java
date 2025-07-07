package com.kulebiakin.shapes.warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static final Logger log = LoggerFactory.getLogger(Warehouse.class);
    private static Warehouse instance;

    private final Map<Long, SphereParameters> storage = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(long id, SphereParameters parameters) {
        storage.put(id, parameters);
    }

    public SphereParameters get(long id) {
        return storage.get(id);
    }

    public void update(long id, SphereParameters parameters) {
        log.debug("Updating sphere parameters for {}", id);
        storage.put(id, parameters);
    }

    public boolean contains(long id) {
        return storage.containsKey(id);
    }

    public void remove(long id) {
        log.debug("Removing sphere parameters for {}", id);
        storage.remove(id);
    }
}
