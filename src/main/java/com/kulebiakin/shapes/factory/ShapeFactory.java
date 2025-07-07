package com.kulebiakin.shapes.factory;

import com.kulebiakin.shapes.model.Sphere;

public interface ShapeFactory {
    Sphere createSphere(long id, double x, double y, double z, double radius);
}
