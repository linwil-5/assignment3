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

	@Test	// [ID: 101] The student must be at least 20 years old to receive subsidiary and student loans.
	public void test_Under_20_Years_Old() throws IOException //ID: 101
	{
		ICalendar calend = CalendarFactory.getCalendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Zero_Loan = (0);
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("19990101-0000", 0, 100, 100));
	}

	
	@Test	// [ID: 102] The student may receive subsidiary until the year they turn 56.
	public void test_56_Years_Old() throws IOException //ID: 102
	{
		ICalendar calend = CalendarFactory.getCalendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Zero_Loan = (0);
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("19600101-0000", 0, 100, 100));
	}


	@Test
	public void test_47_Years_Old() throws IOException //ID: 103
	{
		ICalendar calend = CalendarFactory.get Calendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Subsidiary = (2816);
		// The student is 47 years of age and has 100% study and completion rate and 0 income.
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("19690101-0000", 0, 100, 100));
	}
	
	@Test	// Test if person with 0 income can get full load if all other is correct
    public void test_zero_income()	throws IOException	//ID: 301
    {
		ICalendar calend = CalendarFactory.getCalendar();
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Loan = (7088 + 2816);
		assertEquals(Expected_Full_Loan, payment.getMonthlyAmount("19951124-0000", 0, 100, 100));
	}

}
