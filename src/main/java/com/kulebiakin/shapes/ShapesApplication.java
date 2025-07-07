package com.kulebiakin.shapes;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.observer.SphereObserverImpl;
import com.kulebiakin.shapes.parser.SphereDataParser;
import com.kulebiakin.shapes.reader.SphereFileReader;
import com.kulebiakin.shapes.repository.SphereRepository;
import com.kulebiakin.shapes.repository.SphereRepositoryImpl;
import com.kulebiakin.shapes.service.SphereService;
import com.kulebiakin.shapes.service.SphereServiceImpl;
import com.kulebiakin.shapes.validator.SphereValidator;
import com.kulebiakin.shapes.warehouse.SphereParameters;
import com.kulebiakin.shapes.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ShapesApplication {

    private static final Logger log = LoggerFactory.getLogger(ShapesApplication.class);
    private static final String SPHERES_DATA_PATH = "spheres.txt";

    public static void main(String[] args) {
        log.info("Application started");
        List<Sphere> spheres;

        try {
            spheres = readSpheresFromFile();

            if (!spheres.isEmpty()) {
                log.info("-------- Observer Test --------");
                Sphere firstSphere = spheres.get(0);
                log.info("Before change: {}", Warehouse.getInstance().get(firstSphere.getId()));

                // Change radius of the first sphere - this will trigger the observer
                firstSphere.setRadius(firstSphere.getRadius() + 1.0);

                SphereParameters updatedParams = Warehouse.getInstance().get(firstSphere.getId());
                log.info("After radius change: {}", updatedParams);
            } else {
                log.warn("No valid spheres to test observer.");
            }
        } catch (Exception e) {
            log.error("Error occurred while processing spheres: {}", e.getMessage(), e);
            return;
        }

        log.info("Application ended");
    }

    private static List<Sphere> readSpheresFromFile() throws IOException, URISyntaxException {
        log.info("Loading shapes...");

        SphereFileReader reader = new SphereFileReader();
        SphereValidator validator = new SphereValidator();
        SphereDataParser parser = new SphereDataParser();
        SphereObserverImpl observer = new SphereObserverImpl();
        SphereService service = new SphereServiceImpl();
        SphereRepository repository = new SphereRepositoryImpl();
        Warehouse warehouse = Warehouse.getInstance();

        long id = 1;

        URI fileUri = Objects.requireNonNull(ShapesApplication.class.getClassLoader().getResource(SPHERES_DATA_PATH)).toURI();
        List<String> lines = reader.readAllLines(Paths.get(fileUri));

        for (String line : lines) {
            if (validator.isValid(line)) {
                Sphere sphere = parser.parse(line, id++);
                sphere.attachObserver(observer);
                repository.add(sphere);

                // Initial calculation and store in warehouse
                double area = service.calculateSurfaceArea(sphere);
                double volume = service.calculateVolume(sphere);
                warehouse.put(sphere.getId(), new SphereParameters(area, volume));
            } else {
                log.warn("Invalid sphere data: {}", line);
            }
        }

        log.info("Total valid spheres: {}", repository.getAll().size());
        log.info("Warehouse content:");
        for (Sphere s : repository.getAll()) {
            SphereParameters p = warehouse.get(s.getId());
            log.info("Sphere ID {}: {}", s.getId(), p);
        }

        return repository.getAll();
    }
}
