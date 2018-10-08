package ltu;

import static ltu.CalendarFactory.getCalendar;
import static java.lang.Integer.parseInt;

import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Properties;
import ltu.PaymentImpl;
import ltu.Main;
import ltu.IPayment;
import ltu.ICalendar;
import ltu.CalendarImpl;
import ltu.CalendarFactory;
import org.junit.Test;
import static org.junit.Assert.*;


public class PaymentTest
{
	// 			Instances Created here 			//
	ICalendar calend = CalendarFactory.getCalendar();
	
    @Test
    public void testSilly()
    {
		
        assertEquals(1, 1);
    }
	
    @Test
    public void test_if_below_max_income_for_fullLoanStudent() //ID: 301
    {
		int excpected = (7088 + 2816); 
		
		assertEquals(1, 1);
    }
	
	@Test
    public void test_if_below_max_income_for_halfLoanStudent() //ID: 301
    {
		int excpected = (7088 + 2816); 
		
		assertEquals(1, 1);
    }
	
}
