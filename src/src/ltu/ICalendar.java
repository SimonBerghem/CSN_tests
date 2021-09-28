package src.ltu;

import java.text.ParseException;
import java.util.Date;

public interface ICalendar
{

    /**
     * Returns the last weekday (mon-fri) for the current month.
     * 
     * @return date of last weekday (yyyymmdd)
     */
//    public String lastWeekday();
    public Date getDate();
}
