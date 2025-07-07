package com.kuebiakin.shapes.validator;

public class SphereValidator {

    private static final String SPHERE_LINE_REGEX = "^\\s*([0-9]+(?:\\.[0-9]+)?);\\s*([0-9]+(?:\\.[0-9]+)?);\\s*([0-9]+(?:\\.[0-9]+)?);\\s*([0-9]+(?:\\.[0-9]+)?)\\s*$";

    public boolean isValid(String line) {
        return line != null && line.matches(SPHERE_LINE_REGEX);
    }
}
