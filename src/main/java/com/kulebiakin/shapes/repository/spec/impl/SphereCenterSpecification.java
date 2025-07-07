package com.kulebiakin.shapes.repository.spec.impl;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.Specification;

public class SphereCenterSpecification implements Specification<Sphere> {

    private final Point center;

    public SphereCenterSpecification(Point center) {
        this.center = center;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return sphere.getCenter().equals(center);
    }
}
