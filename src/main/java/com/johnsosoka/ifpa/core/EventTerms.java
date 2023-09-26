package com.johnsosoka.ifpa.core;

import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@Data
public class EventTerms {
    private String eventId;
    private Date tourDate;

    /**
     * Gets the tour date in "yyyy-MM-dd" format.
     *
     * @return A string representing the tour date, or null if the tour date is not set.
     */
    public String getFormattedTourDate() {
        if (tourDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tourDate);
    }

    /**
     * Sets the tour date from a string in "yyyy-MM-dd" format.
     *
     * @param dateString The date string in "yyyy-MM-dd" format.
     * @throws ParseException If the date string is not in the correct format.
     */
    public void setTourDateFromString(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.tourDate = sdf.parse(dateString);
    }
}
