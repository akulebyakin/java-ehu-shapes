package com.kuebiakin.shapes.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SphereFileReader {

    private static final Logger log = LoggerFactory.getLogger(SphereFileReader.class);

    public List<String> readAllLines(Path path) throws IOException {
        log.info("Reading sphere file: {}", path);
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            log.info("Opened file: {}", path);
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            log.error("Error reading file: {}", path, e);
            throw e;
        }

        log.info("Finished reading file: {}. Total lines read: {}", path, lines.size());
        return lines;
    }
}
