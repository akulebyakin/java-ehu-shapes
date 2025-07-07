package com.kulebiakin.shapes;

import com.kulebiakin.shapes.factory.ShapeFactory;
import com.kulebiakin.shapes.factory.SphereFactory;
import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.parser.SphereDataParser;
import com.kulebiakin.shapes.reader.SphereFileReader;
import com.kulebiakin.shapes.service.SphereService;
import com.kulebiakin.shapes.service.SphereServiceImpl;
import com.kulebiakin.shapes.validator.SphereValidator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShapesApplication {

    private static final String SPHERES_DATA_PATH = "spheres.txt";

    public static void main(String[] args) throws IOException {
        List<Sphere> spheres = readSpheresFromFile(SPHERES_DATA_PATH);

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

    private static List<Sphere> readSpheresFromFile(String path) throws IOException {
        SphereFileReader reader = new SphereFileReader();
        SphereValidator validator = new SphereValidator();
        SphereDataParser parser = new SphereDataParser();

        List<Sphere> spheres = new ArrayList<>();
        long id = 1;

        List<String> lines = reader.readAllLines(Paths.get(path));

        for (String line : lines) {
            if (validator.isValid(line)) {
                Sphere sphere = parser.parse(line, id++);
                spheres.add(sphere);
            }
        }

        return spheres;
    }
}
