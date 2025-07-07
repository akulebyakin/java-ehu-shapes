package com.kulebiakin.shapes.observer;

import com.kulebiakin.shapes.model.Sphere;

public interface SphereObserver {
    void onSphereChanged(Sphere sphere);
}
