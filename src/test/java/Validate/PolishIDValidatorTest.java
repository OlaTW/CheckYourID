package Validate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolishIDValidatorTest {


    private PolishIDValidator polishIDValidator;


    @Before
    public void setUp() {
        polishIDValidator = new PolishIDValidator();
    }


    @Test
    public void validateCorrectID() {
        String given = "ARX200682";

        assertTrue(polishIDValidator.validate(given));
    }

    @Test
    public void validateIDWithNumbersOnly() {
        String given = "200200682";

        assertFalse(polishIDValidator.validate(given));
    }

    @Test
    public void validateIDWithLettersOnly() {
        String given = "ARXARXARX";

        assertFalse(polishIDValidator.validate(given));
    }

    @Test
    public void validateIDWithShorterString() {
        String given = "A20";

        assertFalse(polishIDValidator.validate(given));
    }

    @Test
    public void validateIDWithSpaceInside() {
        String given = "ARX 200682";

        assertFalse(polishIDValidator.validate(given));
    }

    @Test
    public void validateIDWithSmallLetters() {
        String given = "arx200682";

        assertFalse(polishIDValidator.validate(given));
    }

}