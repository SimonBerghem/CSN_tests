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
        String DEFAULT_RULES = "student100loan=7088\nstudent100subsidy=2816\nstudent50loan=3564\nstudent50subsidy=1396\nstudent0loan=0\nstudent0subsidy=0\nfulltimeIncome=85813\nparttimeIncome=128722\n";
        String className = System.getProperty("calendar", "src.ltu.CalenderForTesting");
        ICalendar cal = getCalendar(className);
        PaymentImpl t = new PaymentImpl(cal, DEFAULT_RULES);

        int amount = t.getMonthlyAmount("19980121-2867", 0, 100, 100);

        assertEquals(7088+2816, amount);
    }

    // Study pace requirements

    // Income while studying requirements

    // Completion ratio requirement

    // Full time students compensation

    // Halftime students compensation

    // Receiving compensation
}
