package src.ltu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderForTesting implements ICalendar {
    private String date;

    public CalenderForTesting(String date) {
        this.date = date;
    }

    public CalenderForTesting() {
        this.date = "2016-01-01";
    }

    @Override
    public Date getDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
