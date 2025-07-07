package com.kulebiakin.shapes.observer;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.warehouse.SphereParameters;
import com.kulebiakin.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SphereObserverImplTest {

    private final Warehouse warehouse = Warehouse.getInstance();
    private final SphereObserverImpl observer = new SphereObserverImpl();

    @Test
    void observerRemovesInvalidSphereFromWarehouse() {
        Sphere sphere = new Sphere(1, new Point(0, 0, 0), 5.0);
        sphere.attachObserver(observer);

        observer.onSphereChanged(sphere);
        SphereParameters initial = warehouse.get(sphere.getId());

        assertNotNull(initial, "Warehouse must contain sphere parameters after first notification");

        sphere.setRadius(0.0);

        SphereParameters removed = warehouse.get(sphere.getId());
        assertNull(removed, "Sphere must be removed from warehouse after becoming invalid");
    }
}
