package com.kulebiakin.shapes.reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereFileReaderTest {

    private SphereFileReader reader;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        reader = new SphereFileReader();
        tempFile = Files.createTempFile("test-spheres", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testReadAllLinesSuccessfully() throws IOException {
        List<String> expectedLines = List.of("Sphere1", "Sphere2", "Sphere3");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            for (String line : expectedLines) {
                writer.write(line);
                writer.newLine();
            }
        }

        List<String> result = reader.readAllLines(tempFile);
        assertEquals(expectedLines, result);
    }

    @Test
    void testReadAllLinesSkipsEmptyLines() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Sphere1\n\n  \nSphere2\n");
        }

        List<String> result = reader.readAllLines(tempFile);
        assertEquals(List.of("Sphere1", "Sphere2"), result);
    }

    @Test
    void testReadAllLinesEmptyFile() throws IOException {
        List<String> result = reader.readAllLines(tempFile);
        assertTrue(result.isEmpty());
    }

    @Test
    void testReadAllLinesFileDoesNotExist() {
        Path nonExistentPath = Path.of("non-existent-file.txt");
        assertThrows(IOException.class, () -> reader.readAllLines(nonExistentPath));
    }
}
