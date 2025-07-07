package com.kulebiakin.shapes.repository;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;

import java.util.Comparator;
import java.util.List;

public interface SphereRepository {

    void add(Sphere sphere);

    void remove(Sphere sphere);

    List<Sphere> query(Specification<Sphere> specification);

    List<Sphere> sortBy(Comparator<Sphere> comparator);

    List<Sphere> getAll();
}
