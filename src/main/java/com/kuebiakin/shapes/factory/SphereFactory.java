package com.kuebiakin.shapes.factory;

import com.kuebiakin.shapes.model.Point;
import com.kuebiakin.shapes.model.Sphere;

public class SphereFactory implements ShapeFactory {

    @Override
    public Sphere createSphere(long id, double x, double y, double z, double radius) {
        Point center = new Point(x, y, z);
        return new Sphere(id, center, radius);
    }
}
