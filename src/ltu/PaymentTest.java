package ltu;

import static org.junit.Assert.*;

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

public class PaymentTest
{

    @Test	// Test if person with 0 income can get full load if all other is correct
    public void test_zero_income()	throws IOException	//ID: 301
    {
		ICalendar calend = CalendarFactory.getCalendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Loan = (7088 + 2816);


		
		assertEquals(Expected_Full_Loan, payment.getMonthlyAmount("1995112400000", 0, 100, 100));
	}


	@Test
	public void testIf47YearsOld() throws IOException //ID: 103
	{
		ICalendar calend = CalendarFactory.getCalendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Zero_Loan = (2816);
		// The student is 47 years of age and has 100% study and completion rate and 0 income.
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("1971010100000", 0, 100, 100));
	}
=======

}
