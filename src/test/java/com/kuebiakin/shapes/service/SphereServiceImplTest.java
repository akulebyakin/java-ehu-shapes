package com.kuebiakin.shapes.service;

import com.kuebiakin.shapes.model.Point;
import com.kuebiakin.shapes.model.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereServiceImplTest {

    private final SphereServiceImpl service = new SphereServiceImpl();

    @Test
    @DisplayName("Calculates diameter for positive radius")
    void calculatesDiameterForPositiveRadius() {
        Sphere sphere = new Sphere(1L, new Point(0, 0, 0), 5.0);
        assertEquals(10.0, service.calculateDiameter(sphere), 0.0001);
    }

    @Test
    @DisplayName("Calculates surface area for positive radius")
    void calculatesSurfaceAreaForPositiveRadius() {
        Sphere sphere = new Sphere(2L, new Point(0, 0, 0), 3.0);
        assertEquals(4 * Math.PI * 9, service.calculateSurfaceArea(sphere), 0.0001);
    }

    @Test
    @DisplayName("Calculates volume for positive radius")
    void calculatesVolumeForPositiveRadius() {
        Sphere sphere = new Sphere(3L, new Point(0, 0, 0), 2.0);
        assertEquals((4.0 / 3.0) * Math.PI * 8, service.calculateVolume(sphere), 0.0001);
    }

    @Test
    @DisplayName("Calculates curvature for positive radius")
    void calculatesCurvatureForPositiveRadius() {
        Sphere sphere = new Sphere(4L, new Point(0, 0, 0), 4.0);
        assertEquals(0.25, service.calculateCurvature(sphere), 0.0001);
    }

    @Test
    @DisplayName("Diameter is zero when radius is zero")
    void diameterIsZeroWhenRadiusIsZero() {
        Sphere sphere = new Sphere(5L, new Point(0, 0, 0), 0.0);
        assertEquals(0.0, service.calculateDiameter(sphere), 0.0001);
    }

    @Test
    @DisplayName("Surface area is zero when radius is zero")
    void surfaceAreaIsZeroWhenRadiusIsZero() {
        Sphere sphere = new Sphere(6L, new Point(0, 0, 0), 0.0);
        assertEquals(0.0, service.calculateSurfaceArea(sphere), 0.0001);
    }

    @Test
    @DisplayName("Volume is zero when radius is zero")
    void volumeIsZeroWhenRadiusIsZero() {
        Sphere sphere = new Sphere(7L, new Point(0, 0, 0), 0.0);
        assertEquals(0.0, service.calculateVolume(sphere), 0.0001);
    }

    @Test
    @DisplayName("Curvature is infinite when radius is zero")
    void curvatureIsInfiniteWhenRadiusIsZero() {
        Sphere sphere = new Sphere(8L, new Point(0, 0, 0), 0.0);
        assertTrue(Double.isInfinite(service.calculateCurvature(sphere)));
    }

    @Test
    @DisplayName("Calculates for very small radius")
    void calculatesForVerySmallRadius() {
        Sphere sphere = new Sphere(9L, new Point(0, 0, 0), 1e-10);
        assertEquals(2e-10, service.calculateDiameter(sphere), 1e-15);
        assertEquals(4 * Math.PI * 1e-20, service.calculateSurfaceArea(sphere), 1e-25);
        assertEquals((4.0 / 3.0) * Math.PI * 1e-30, service.calculateVolume(sphere), 1e-35);
        assertEquals(1.0 / 1e-10, service.calculateCurvature(sphere), 1e-5);
    }

    @Test
    @DisplayName("Throws or returns NaN for negative radius")
    void handlesNegativeRadius() {
        Sphere sphere = new Sphere(10L, new Point(0, 0, 0), -2.0);
        assertEquals(-4.0, service.calculateDiameter(sphere), 0.0001);
        assertEquals(4 * Math.PI * 4, service.calculateSurfaceArea(sphere), 0.0001);
        assertEquals((4.0 / 3.0) * Math.PI * -8, service.calculateVolume(sphere), 0.0001);
        assertEquals(-0.5, service.calculateCurvature(sphere), 0.0001);
    }
}
