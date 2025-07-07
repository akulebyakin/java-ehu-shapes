package com.kuebiakin.shapes.service;

import com.kuebiakin.shapes.model.Sphere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereServiceImpl implements SphereService {

    private static final Logger log = LoggerFactory.getLogger(SphereServiceImpl.class);
    private static final double TOLERANCE = 0.0001;

    @Override
    public double calculateDiameter(Sphere sphere) {
        log.info("Calculating diameter of sphere: {}", sphere);
        return sphere.getRadius() * 2;
    }

    @Override
    public double calculateSurfaceArea(Sphere sphere) {
        log.info("Calculating surface area of sphere: {}", sphere);
        double radius = sphere.getRadius();
        return radius * radius * 4 * Math.PI;
    }

    @Override
    public double calculateVolume(Sphere sphere) {
        log.info("Calculating volume of sphere: {}", sphere);
        double radius = sphere.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public double calculateCurvature(Sphere sphere) {
        log.info("Calculating curvature of sphere: {}", sphere);
        return 1.0 / sphere.getRadius();
    }
}

