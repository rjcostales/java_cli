package rjsc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateValidatorTest {

    private DateValidator dateValidator;

    @Before
    public void init() {
        dateValidator = new DateValidator();
    }

    @Test
    public void testDateIsNull() {
        assertFalse(dateValidator.isThisDateValid(null, "dd/MM/yyyy"));
    }

    @Test
    public void testDayIsInvalid() {
        assertFalse(dateValidator.isThisDateValid("32/02/2012", "dd/MM/yyyy"));
    }

    @Test
    public void testMonthIsInvalid() {
        assertFalse(dateValidator.isThisDateValid("31/20/2012", "dd/MM/yyyy"));
    }

    @Test
    public void testYearIsInvalid() {
        assertFalse(dateValidator.isThisDateValid("31/20/19991", "dd/MM/yyyy"));
    }

    @Test
    public void testDateFormatIsInvalid() {
        assertFalse(dateValidator.isThisDateValid("2012/02/20", "dd/MM/yyyy"));
    }

    @Test
    public void testDateFeb29_2012() {
        assertTrue(dateValidator.isThisDateValid("29/02/2012", "dd/MM/yyyy"));
    }

    @Test
    public void testDateFeb29_2011() {
        assertFalse(dateValidator.isThisDateValid("29/02/2011", "dd/MM/yyyy"));
    }

    @Test
    public void testDateFeb28() {
        assertTrue(dateValidator.isThisDateValid("28/02/2011", "dd/MM/yyyy"));
    }

    @Test
    public void testDateIsValid_1() {
        assertTrue(dateValidator.isThisDateValid("31/01/2012", "dd/MM/yyyy"));
    }

    @Test
    public void testDateIsValid_2() {
        assertTrue(dateValidator.isThisDateValid("30/04/2012", "dd/MM/yyyy"));
    }

    @Test
    public void testDateIsValid_3() {
        assertTrue(dateValidator.isThisDateValid("31/05/2012", "dd/MM/yyyy"));
    }

}