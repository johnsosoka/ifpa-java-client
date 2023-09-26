package com.johnsosoka.ifpa.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EventTermsTest {

    private EventTerms eventTerms;

    @BeforeEach
    public void setUp() {
        eventTerms = new EventTerms();
    }

    @Test
    public void testGetFormattedTourDate() {
        // Test with null tourDate
        assertNull(eventTerms.getFormattedTourDate());

        // Test with a valid tourDate
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2022-09-24");
            eventTerms.setTourDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("2022-09-24", eventTerms.getFormattedTourDate());
    }

    @Test
    public void testSetTourDateFromString() {
        // Test with a valid date string
        try {
            eventTerms.setTourDateFromString("2022-09-24");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2022-09-24", sdf.format(eventTerms.getTourDate()));

        // Test with an invalid date string (this should throw a ParseException)
        try {
            eventTerms.setTourDateFromString("invalid-date");
        } catch (ParseException e) {
            assertEquals("Unparseable date: \"invalid-date\"", e.getMessage());
        }
    }
}
