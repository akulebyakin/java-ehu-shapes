package com.kulebiakin.shapes.repository;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.repository.spec.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereRepositoryImplTest {

    private SphereRepository repository;
    private Sphere sphere1;
    private Sphere sphere2;
    private Sphere sphere3;

    @BeforeEach
    void setUp() {
        repository = new SphereRepositoryImpl();
        sphere1 = new Sphere(1L, new Point(0, 0, 0), 5.0);
        sphere2 = new Sphere(2L, new Point(1, 1, 1), 10.0);
        sphere3 = new Sphere(3L, new Point(0, 0, 0), 5.0);
        repository.add(sphere1);
        repository.add(sphere2);
        repository.add(sphere3);
    }

    @Test
    @DisplayName("Add and retrieve all spheres")
    void addAndGetAllSpheres() {
        List<Sphere> all = repository.getAll();
        assertEquals(3, all.size());
        assertTrue(all.contains(sphere1));
        assertTrue(all.contains(sphere2));
        assertTrue(all.contains(sphere3));
    }

    @Test
    @DisplayName("Remove sphere from repository")
    void removeSphere() {
        repository.remove(sphere2);
        List<Sphere> all = repository.getAll();
        assertEquals(2, all.size());
        assertFalse(all.contains(sphere2));
    }

    @Test
    @DisplayName("Query spheres by exact radius")
    void queryByRadiusEquals() {
        List<Sphere> result = repository.query(new RadiusEqualsSpecification(5.0));
        assertEquals(2, result.size());
        assertTrue(result.contains(sphere1));
        assertTrue(result.contains(sphere3));
    }

    @Test
    @DisplayName("Query spheres by radius less than value")
    void queryByRadiusLessThan() {
        List<Sphere> result = repository.query(new RadiusLessThanSpecification(6.0));
        assertEquals(2, result.size());
        assertTrue(result.contains(sphere1));
        assertTrue(result.contains(sphere3));
    }

    @Test
    @DisplayName("Query spheres by radius greater than value")
    void queryByRadiusGreaterThan() {
        List<Sphere> result = repository.query(new RadiusGreaterThanSpecification(5.0));
        assertEquals(1, result.size());
        assertTrue(result.contains(sphere2));
    }

    @Test
    @DisplayName("Query spheres by center point")
    void queryByCenter() {
        List<Sphere> result = repository.query(new SphereCenterSpecification(new Point(0, 0, 0)));
        assertEquals(2, result.size());
        assertTrue(result.contains(sphere1));
        assertTrue(result.contains(sphere3));
    }

    @Test
    @DisplayName("Query spheres by id")
    void queryById() {
        List<Sphere> result = repository.query(new SphereIdSpecification(2L));
        assertEquals(1, result.size());
        assertEquals(sphere2, result.get(0));
    }

    @Test
    @DisplayName("Sort spheres by radius ascending")
    void sortByRadiusAscending() {
        List<Sphere> sorted = repository.sortBy(Comparator.comparingDouble(Sphere::getRadius));
        assertEquals(sphere1, sorted.get(0));
        assertEquals(sphere3, sorted.get(1));
        assertEquals(sphere2, sorted.get(2));
    }

    @Test
    @DisplayName("Sort spheres by id descending")
    void sortByIdDescending() {
        List<Sphere> sorted = repository.sortBy((a, b) -> Long.compare(b.getId(), a.getId()));
        assertEquals(sphere3, sorted.get(0));
        assertEquals(sphere2, sorted.get(1));
        assertEquals(sphere1, sorted.get(2));
    }

    @Test
    @DisplayName("Query returns empty list when no match")
    void queryReturnsEmptyWhenNoMatch() {
        List<Sphere> result = repository.query(new RadiusEqualsSpecification(100.0));
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Get all returns unmodifiable list")
    void getAllReturnsUnmodifiableList() {
        List<Sphere> all = repository.getAll();
        assertThrows(UnsupportedOperationException.class, () -> all.add(new Sphere(4L, new Point(2, 2, 2), 7.0)));
    }
}
