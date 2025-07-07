package com.kulebiakin.shapes.validator;

public class SphereCalculationValidator {

    private static final double MIN_VALUE = 0.0001;

    public boolean isSurfaceAreaValid(double area) {
        return area > MIN_VALUE;
    }

    public boolean isVolumeValid(double volume) {
        return volume > MIN_VALUE;
    }

    public boolean isCurvatureValid(double curvature) {
        return curvature > MIN_VALUE;
    }
}
