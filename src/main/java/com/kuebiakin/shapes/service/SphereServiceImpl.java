package com.kuebiakin.shapes.service;

import com.kuebiakin.shapes.model.Sphere;

public class SphereServiceImpl implements SphereService {

    private static final double TOLERANCE = 0.0001;

    @Override
    public double calculateDiameter(Sphere sphere) {
        return sphere.getRadius() * 2;
    }

    @Override
    public double calculateSurfaceArea(Sphere sphere) {
        double radius = sphere.getRadius();
        return radius * radius * 4 * Math.PI;
    }

    @Override
    public double calculateVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public double calculateCurvature(Sphere sphere) {
        return 1.0 / sphere.getRadius();
    }
}

