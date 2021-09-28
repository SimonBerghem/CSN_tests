package src.ltu;

import static org.junit.Assert.*;
import static src.ltu.CalendarFactory.getCalendar;


import org.junit.Test;

import java.io.IOException;

public class PaymentTest
{
    @Test
    public void testSilly()
    {
        assertEquals(1, 1);
    }

    // Age requirements
    @Test
    public void id102AgeOver20() throws IOException {
        String className = System.getProperty("calendar", "ltu.CalenderForTesting");
        ICalendar cal = getCalendar(className);
        PaymentImpl t = new PaymentImpl(cal);

    }


    // Study pace requirements

    // Income while studying requirements

    // Completion ratio requirement

    // Full time students compensation

    // Halftime students compensation

    // Receiving compensation
}
