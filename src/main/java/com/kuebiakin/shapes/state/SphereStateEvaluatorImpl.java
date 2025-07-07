package com.kuebiakin.shapes.state;

import com.kuebiakin.shapes.model.Sphere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereStateEvaluatorImpl implements SphereStateEvaluator {

    private static final Logger log = LoggerFactory.getLogger(SphereStateEvaluatorImpl.class);
    private static final double TOLERANCE = 0.0001;

    @Override
    public SphereState evaluate(Sphere sphere) {
        log.info("Evaluating sphere state: {}", sphere);
        if (sphere == null || sphere.getRadius() <= TOLERANCE) {
            return SphereState.INVALID;
        }
        return SphereState.VALID;
    }
}
