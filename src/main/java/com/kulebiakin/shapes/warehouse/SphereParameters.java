package com.kulebiakin.shapes.warehouse;

public class SphereParameters {
    private double surfaceArea;
    private double volume;

    public SphereParameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "SphereParameters{surfaceArea=" + surfaceArea + ", volume=" + volume + "}";
    }
}
