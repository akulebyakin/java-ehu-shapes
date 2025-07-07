package com.kuebiakin.shapes.service;

import com.kuebiakin.shapes.model.Sphere;

public interface SphereService {
    double calculateDiameter(Sphere sphere);
    double calculateSurfaceArea(Sphere sphere);
    double calculateVolume(Sphere sphere);
    double calculateCurvature(Sphere sphere);
}

