package com.kulebiakin.shapes.repository;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SphereRepositoryImpl implements SphereRepository {

    private static final Logger log = LoggerFactory.getLogger(SphereRepositoryImpl.class);
    private final List<Sphere> storage = new ArrayList<>();

    @Override
    public void add(Sphere sphere) {
        log.info("Sphere added to the repository: {}", sphere);
        storage.add(sphere);
    }

    @Override
    public void remove(Sphere sphere) {
        log.info("Sphere removed from the repository: {}", sphere);
        storage.remove(sphere);
    }

    @Override
    public List<Sphere> query(Specification<Sphere> specification) {
        List<Sphere> result = new ArrayList<>();
        for (Sphere sphere : storage) {
            if (specification.specify(sphere)) {
                result.add(sphere);
            }
        }
        return result;
    }

    @Override
    public List<Sphere> sortBy(Comparator<Sphere> comparator) {
        List<Sphere> sorted = new ArrayList<>(storage);
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public List<Sphere> getAll() {
        return Collections.unmodifiableList(storage);
    }
}
