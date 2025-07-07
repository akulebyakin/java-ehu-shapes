package com.kulebiakin.shapes.observer;

public interface SphereSubject {
    void attachObserver(SphereObserver observer);

    void detachObserver(SphereObserver observer);

    void notifyObservers();
}
