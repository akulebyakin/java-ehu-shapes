package com.kuebiakin.shapes.model;

public class Sphere {
    private final long id;
    private final Point center;
    private final double radius;

    public Sphere(long id, Point center, double radius) {
        this.id = id;
        this.center = center;
        this.radius = radius;
    }

    public long getId() {
        return id;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sphere sphere = (Sphere) obj;
        return id == sphere.id &&
            Double.compare(sphere.radius, radius) == 0 &&
            center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Long.hashCode(id);
        hash = 31 * hash + center.hashCode();
        long temp = Double.doubleToLongBits(radius);
        hash = 31 * hash + (int) (temp ^ (temp >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Sphere{id=" + id + ", center=" + center + ", radius=" + radius + '}';
    }
}
