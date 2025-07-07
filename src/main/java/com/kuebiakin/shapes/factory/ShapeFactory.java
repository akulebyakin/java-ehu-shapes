package com.kuebiakin.shapes.factory;

import com.kuebiakin.shapes.model.Sphere;

public interface ShapeFactory {
    Sphere createSphere(long id, double x, double y, double z, double radius);
}
