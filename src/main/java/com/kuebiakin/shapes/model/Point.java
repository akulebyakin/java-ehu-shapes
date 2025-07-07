package com.kuebiakin.shapes.model;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 &&
            Double.compare(point.y, y) == 0 &&
            Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        long temp;
        temp = Double.doubleToLongBits(x);
        hash = 31 * hash + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        hash = 31 * hash + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        hash = 31 * hash + (int) (temp ^ (temp >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}

