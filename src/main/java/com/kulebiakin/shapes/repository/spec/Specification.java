package com.kulebiakin.shapes.repository.spec;

public interface Specification<T> {

    boolean specify(T item);
}
