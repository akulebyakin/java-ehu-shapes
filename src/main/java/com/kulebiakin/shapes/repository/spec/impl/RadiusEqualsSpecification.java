package com.kulebiakin.shapes.repository.spec.impl;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;

public class RadiusEqualsSpecification implements Specification<Sphere> {

    private final double radius;

    public RadiusEqualsSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return sphere.getRadius() == radius;
    }
}
