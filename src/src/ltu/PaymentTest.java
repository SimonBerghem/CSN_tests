package src.ltu;

import static org.junit.Assert.*;
import static src.ltu.CalendarFactory.getCalendar;


import org.junit.Test;
import org.junit.Before;

import java.io.IOException;

public class PaymentTest
{
    private PaymentImpl testPaymentImpl;

    @Before
    public void setup() {
        String DEFAULT_RULES = "student100loan=7088\nstudent100subsidy=2816\nstudent50loan=3564\nstudent50subsidy=1396\nstudent0loan=0\nstudent0subsidy=0\nfulltimeIncome=85813\nparttimeIncome=128722\n";
        String className = System.getProperty("calendar", "src.ltu.CalenderForTesting");
        ICalendar cal = getCalendar(className);
        try {
            testPaymentImpl = new PaymentImpl(cal, DEFAULT_RULES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSilly()
    {
        assertEquals(1, 1);
    }

    // Age requirements
    @Test
    public void id101AgeUnder20() {
        int amount = testPaymentImpl.getMonthlyAmount("20110928-1483", 0, 100,100);
        assertEquals(0, amount);
    }

    @Test
    public void id101Age20() {
        int amount = testPaymentImpl.getMonthlyAmount("19960928-2368", 0, 100,100);
        assertEquals(7088+2816, amount);
    }

    @Test
    public void id101Id102AgeOver20Under47() {
        int amount = testPaymentImpl.getMonthlyAmount("19860121-2867", 0, 100, 100);
        assertEquals(7088+2816, amount);
    }


    @Test
    public void id102id103Age47() {
        int amount = testPaymentImpl.getMonthlyAmount("19690928-4606", 0, 100,100);
        assertEquals(2816, amount);
    }

    // Study pace requirements
    // Cannot check if sub or loan, assumed to be both
    @Test
    public void id201NoSub() {
        int amount = testPaymentImpl.getMonthlyAmount("20110928-1483", 0, 49, 100);
        assertEquals(0, amount);
    }

    @Test
    public void id202Id503Id504HalfSubEdge() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 50, 100);
        assertEquals(1396+3564, amount);
    }

    @Test
    public void id202Id503Id504HalfSubOver() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 51, 100);
        assertEquals(1396+3564, amount);
    }

    @Test
    public void id202Id503Id504HalfSub() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 65, 100);
        assertEquals(1396+3564, amount);
    }

    @Test
    public void id202Id503Id504HalfSubMax() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 99, 100);
        assertEquals(1396+3564, amount);
    }

    @Test
    public void id203Id501Id502FullSubEdge() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 100, 100);
        assertEquals(2816+7088, amount);
    }

    @Test
    public void id203Id501Id502FullSubOver() {
        int amount = testPaymentImpl.getMonthlyAmount("19740928-4606", 0, 101, 100);
        assertEquals(2816+7088, amount);
    }

    // Income while studying requirements

    // Completion ratio requirement

    // Full time students compensation

    // Halftime students compensation

    // Receiving compensation
}
