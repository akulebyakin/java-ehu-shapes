package com.kuebiakin.shapes;

import com.kuebiakin.shapes.factory.ShapeFactory;
import com.kuebiakin.shapes.factory.SphereFactory;
import com.kuebiakin.shapes.model.Sphere;
import com.kuebiakin.shapes.service.SphereService;
import com.kuebiakin.shapes.service.SphereServiceImpl;

public class ShapesApplication {

    public static void main(String[] args) {
        ShapeFactory sphereFactory = new SphereFactory();
        Sphere sphere = sphereFactory.createSphere(1, 0.0, 0.0, 0.0, 5.0);

        System.out.println("Sphere ID: " + sphere.getId());
        System.out.println("Sphere Center: " + sphere.getCenter());
        System.out.println("Sphere Radius: " + sphere.getRadius());

        SphereService sphereService = new SphereServiceImpl();
        System.out.println("Sphere Diameter: " + sphereService.calculateDiameter(sphere));
        System.out.println("Sphere Surface Area: " + sphereService.calculateSurfaceArea(sphere));
        System.out.println("Sphere Volume: " + sphereService.calculateVolume(sphere));
        System.out.println("Sphere Curvature: " + sphereService.calculateCurvature(sphere));
    }
}
