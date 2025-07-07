package com.kulebiakin.shapes.state;

import com.kulebiakin.shapes.model.Sphere;

public interface SphereStateEvaluator {
    SphereState evaluate(Sphere sphere);
}
