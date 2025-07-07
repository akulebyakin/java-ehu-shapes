package com.kulebiakin.shapes.observer;

import com.kulebiakin.shapes.model.Sphere;
import com.kulebiakin.shapes.service.SphereService;
import com.kulebiakin.shapes.service.SphereServiceImpl;
import com.kulebiakin.shapes.state.SphereState;
import com.kulebiakin.shapes.state.SphereStateEvaluator;
import com.kulebiakin.shapes.state.SphereStateEvaluatorImpl;
import com.kulebiakin.shapes.warehouse.SphereParameters;
import com.kulebiakin.shapes.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereObserverImpl implements SphereObserver {

    private static final Logger log = LoggerFactory.getLogger(SphereObserverImpl.class);
    private final SphereService service = new SphereServiceImpl();
    private final SphereStateEvaluator evaluator = new SphereStateEvaluatorImpl();

    @Override
    public void onSphereChanged(Sphere sphere) {
        log.info("Notify Observer. Sphere changed: {}", sphere);

        if (evaluator.evaluate(sphere) == SphereState.INVALID) {
            log.warn("Sphere {} became invalid, removing from the warehouse", sphere.getId());
            Warehouse.getInstance().remove(sphere.getId());
            return;
        }

        double area = service.calculateSurfaceArea(sphere);
        double volume = service.calculateVolume(sphere);
        SphereParameters parameters = new SphereParameters(area, volume);
        Warehouse.getInstance().update(sphere.getId(), parameters);
    }
}
