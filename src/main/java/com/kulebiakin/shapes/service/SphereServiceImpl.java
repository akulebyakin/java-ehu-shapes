package com.kulebiakin.shapes.service;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.validator.SphereCalculationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereServiceImpl implements SphereService {

    private static final Logger log = LoggerFactory.getLogger(SphereServiceImpl.class);
    private final SphereCalculationValidator sphereCalculationValidator;

    public SphereServiceImpl() {
        sphereCalculationValidator = new SphereCalculationValidator();
    }

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

    @Override
    public boolean isSurfaceAreaValid(double area) {
        log.info("Checking if surface area valid for sphere: {}", area);
        return sphereCalculationValidator.isSurfaceAreaValid(area);
    }

    @Override
    public boolean isVolumeValid(double volume) {
        log.info("Checking if volume valid for sphere: {}", volume);
        return sphereCalculationValidator.isVolumeValid(volume);
    }

    @Override
    public boolean isCurvatureValid(double curvature) {
        log.info("Checking if curvature valid for sphere: {}", curvature);
        return sphereCalculationValidator.isCurvatureValid(curvature);
    }
}
