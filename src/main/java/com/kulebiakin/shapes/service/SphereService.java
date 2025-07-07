package com.kulebiakin.shapes.service;

import com.kulebiakin.shapes.model.Sphere;

public interface SphereService {
    double calculateDiameter(Sphere sphere);
    double calculateSurfaceArea(Sphere sphere);
    double calculateVolume(Sphere sphere);
    double calculateCurvature(Sphere sphere);

    boolean isSurfaceAreaValid(double area);

    boolean isVolumeValid(double volume);

    boolean isCurvatureValid(double curvature);
}
