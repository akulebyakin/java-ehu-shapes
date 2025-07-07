package com.kulebiakin.shapes.repository.spec.impl;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;

public class SphereIdSpecification implements Specification<Sphere> {

    private final double id;

    public SphereIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return sphere.getId() == id;
    }
}
