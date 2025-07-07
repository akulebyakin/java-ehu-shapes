package com.kulebiakin.shapes.repository.spec.impl;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;

public class RadiusLessThanSpecification implements Specification<Sphere> {

    private final double radius;

    public RadiusLessThanSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return sphere.getRadius() < radius;
    }
}
