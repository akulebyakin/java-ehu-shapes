package com.kulebiakin.shapes.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphereValidatorTest {

    private final SphereValidator validator = new SphereValidator();

    @Test
    @DisplayName("Valid line with integer values is accepted")
    void validLineWithIntegersIsAccepted() {
        assertTrue(validator.isValid("1;2;3;4"));
    }

    @Test
    @DisplayName("Valid line with decimal values is accepted")
    void validLineWithDecimalsIsAccepted() {
        assertTrue(validator.isValid("1.5; 2.0; 3.25; 4.75"));
    }

    @Test
    @DisplayName("Valid line with extra spaces is accepted")
    void validLineWithExtraSpacesIsAccepted() {
        assertTrue(validator.isValid("  10 ; 20 ; 30 ; 40  "));
    }

    @Test
    @DisplayName("Null input is rejected")
    void nullInputIsRejected() {
        assertFalse(validator.isValid(null));
    }

    @Test
    @DisplayName("Line with missing values is rejected")
    void lineWithMissingValuesIsRejected() {
        assertFalse(validator.isValid("1;2;3"));
    }

    @Test
    @DisplayName("Line with non-numeric values is rejected")
    void lineWithNonNumericValuesIsRejected() {
        assertFalse(validator.isValid("a;b;c;d"));
    }

    @Test
    @DisplayName("Line with negative numbers is rejected")
    void lineWithNegativeNumbersIsRejected() {
        assertFalse(validator.isValid("-1;2;3;4"));
    }

    @Test
    @DisplayName("Line with extra delimiters is rejected")
    void lineWithExtraDelimitersIsRejected() {
        assertFalse(validator.isValid("1;2;3;4;5"));
    }

    @Test
    @DisplayName("Line with empty string is rejected")
    void emptyStringIsRejected() {
        assertFalse(validator.isValid(""));
    }
}