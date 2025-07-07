package com.kulebiakin.shapes.model;

import com.kulebiakin.shapes.observer.SphereObserver;
import com.kulebiakin.shapes.observer.SphereSubject;

import java.util.ArrayList;
import java.util.List;

public class Sphere implements SphereSubject {

    private final long id;
    private final List<SphereObserver> observers;
    private Point center;
    private double radius;

    public Sphere(long id, Point center, double radius) {
        this.id = id;
        this.center = center;
        this.radius = radius;
        observers = new ArrayList<>();
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

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObservers();
    }

    @Override
    public void attachObserver(SphereObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(SphereObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.onSphereChanged(this));
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
