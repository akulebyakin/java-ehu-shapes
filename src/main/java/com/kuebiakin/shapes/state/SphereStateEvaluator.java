package com.kuebiakin.shapes.state;

import com.kuebiakin.shapes.model.Sphere;

public interface SphereStateEvaluator {
    SphereState evaluate(Sphere sphere);
}
