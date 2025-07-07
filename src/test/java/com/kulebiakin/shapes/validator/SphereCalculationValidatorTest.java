package com.kulebiakin.shapes.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereCalculationValidatorTest {

    private final SphereCalculationValidator validator = new SphereCalculationValidator();

    @Test
    @DisplayName("Surface area greater than minimum is valid")
    void surfaceAreaGreaterThanMinimumIsValid() {
        assertTrue(validator.isSurfaceAreaValid(1.0));
    }

    @Test
    @DisplayName("Surface area equal to minimum is invalid")
    void surfaceAreaEqualToMinimumIsInvalid() {
        assertFalse(validator.isSurfaceAreaValid(0.0001));
    }

    @Test
    @DisplayName("Surface area less than minimum is invalid")
    void surfaceAreaLessThanMinimumIsInvalid() {
        assertFalse(validator.isSurfaceAreaValid(0.0));
    }

    @Test
    @DisplayName("Volume greater than minimum is valid")
    void volumeGreaterThanMinimumIsValid() {
        assertTrue(validator.isVolumeValid(2.0));
    }

    @Test
    @DisplayName("Volume equal to minimum is invalid")
    void volumeEqualToMinimumIsInvalid() {
        assertFalse(validator.isVolumeValid(0.0001));
    }

    @Test
    @DisplayName("Volume less than minimum is invalid")
    void volumeLessThanMinimumIsInvalid() {
        assertFalse(validator.isVolumeValid(-1.0));
    }

    @Test
    @DisplayName("Curvature greater than minimum is valid")
    void curvatureGreaterThanMinimumIsValid() {
        assertTrue(validator.isCurvatureValid(0.5));
    }

    @Test
    @DisplayName("Curvature equal to minimum is invalid")
    void curvatureEqualToMinimumIsInvalid() {
        assertFalse(validator.isCurvatureValid(0.0001));
    }

    @Test
    @DisplayName("Curvature less than minimum is invalid")
    void curvatureLessThanMinimumIsInvalid() {
        assertFalse(validator.isCurvatureValid(-0.1));
    }
}