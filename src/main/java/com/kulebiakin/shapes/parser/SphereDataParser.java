package com.kulebiakin.shapes.parser;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereDataParser {

    private static final Logger log = LoggerFactory.getLogger(SphereDataParser.class);

    public Sphere parse(String line, long id) {
        log.info("Parsing sphere data");
        String[] tokens = line.split(";");
        double x = Double.parseDouble(tokens[0].trim());
        double y = Double.parseDouble(tokens[1].trim());
        double z = Double.parseDouble(tokens[2].trim());
        double radius = Double.parseDouble(tokens[3].trim());

        log.debug("Parsed values - x: {}, y: {}, z: {}, radius: {}", x, y, z, radius);
        return new Sphere(id, new Point(x, y, z), radius);
    }
}
