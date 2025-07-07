package com.kulebiakin.shapes.parser;

import com.kulebiakin.shapes.model.Point;
import com.kulebiakin.shapes.model.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SphereDataParserTest {

    private final SphereDataParser parser = new SphereDataParser();

    @Test
    @DisplayName("Parse valid line with integer values")
    void parseValidLineWithIntegers() {
        Sphere sphere = parser.parse("1;2;3;4", 42L);
        assertEquals(42L, sphere.getId());
        assertEquals(new Point(1, 2, 3), sphere.getCenter());
        assertEquals(4.0, sphere.getRadius());
    }

    @Test
    @DisplayName("Parse valid line with decimal values and spaces")
    void parseValidLineWithDecimalsAndSpaces() {
        Sphere sphere = parser.parse(" 1.5 ; 2.25 ; 3.75 ; 4.5 ", 7L);
        assertEquals(7L, sphere.getId());
        assertEquals(new Point(1.5, 2.25, 3.75), sphere.getCenter());
        assertEquals(4.5, sphere.getRadius());
    }

    @Test
    @DisplayName("Parse line with negative values")
    void parseLineWithNegativeValues() {
        Sphere sphere = parser.parse("-1; -2; -3; 5", 3L);
        assertEquals(new Point(-1, -2, -3), sphere.getCenter());
        assertEquals(5.0, sphere.getRadius());
    }

    @Test
    @DisplayName("Parse line with zero values")
    void parseLineWithZeroValues() {
        Sphere sphere = parser.parse("0;0;0;0", 1L);
        assertEquals(new Point(0, 0, 0), sphere.getCenter());
        assertEquals(0.0, sphere.getRadius());
    }

    @Test
    @DisplayName("Parse line with extra spaces between tokens")
    void parseLineWithExtraSpaces() {
        Sphere sphere = parser.parse("  10 ;   20 ;  30 ;  40  ", 5L);
        assertEquals(new Point(10, 20, 30), sphere.getCenter());
        assertEquals(40.0, sphere.getRadius());
    }

    @Test
    @DisplayName("Parse line with invalid number format throws exception")
    void parseLineWithInvalidNumberFormatThrowsException() {
        assertThrows(NumberFormatException.class, () -> parser.parse("a;b;c;d", 1L));
    }

    @Test
    @DisplayName("Parse line with missing values throws exception")
    void parseLineWithMissingValuesThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.parse("1;2;3", 1L));
    }

    @Test
    @DisplayName("Parse line with extra values ignores extras")
    void parseLineWithExtraValuesIgnoresExtras() {
        Sphere sphere = parser.parse("1;2;3;4;5;6", 9L);
        assertEquals(new Point(1, 2, 3), sphere.getCenter());
        assertEquals(4.0, sphere.getRadius());
    }
}