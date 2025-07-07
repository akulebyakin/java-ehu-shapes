package com.kulebiakin.shapes.factory;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereFactory implements ShapeFactory {

    private static final Logger log = LoggerFactory.getLogger(SphereFactory.class);

    @Override
    public Sphere createSphere(long id, double x, double y, double z, double radius) {
        log.info("Creating sphere with id: {}", id);
        Point center = new Point(x, y, z);
        return new Sphere(id, center, radius);
    }
}
