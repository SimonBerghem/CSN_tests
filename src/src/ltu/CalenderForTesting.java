package src.ltu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderForTesting implements ICalendar {
    @Override
    public Date getDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-28");
        } catch (ParseException e) {
            return null;
        }
    }
}
