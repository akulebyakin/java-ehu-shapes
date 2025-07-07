package com.kulebiakin.shapes.validator;

public class SphereValidator {

    /**
     * Examples that match
     * • 1.0;2.0;3.0;5.0
     * • 1;2;3;5
     * • 1 ; 2 ; 3 ; 5.0
     * • -1.2; 0.0; -3; 10.5
     */
    private static final String SPHERE_LINE_REGEX = "^\\s*(\\d+(?:\\.\\d+)?)(?:\\s*;\\s*(\\d+(?:\\.\\d+)?)){3}\\s*$";

    /**
     * Validates whether the input string represents a valid sphere definition.
     * <p>
     * A valid sphere line must consist of four numeric values (integers or decimals)
     * separated by semicolons, with optional surrounding whitespace.
     *
     * @param line the input string to validate
     * @return {@code true} if the input matches the expected sphere format; {@code false} otherwise
     */
    public boolean isValid(String line) {
        return line != null && line.strip().matches(SPHERE_LINE_REGEX);
    }
}
