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
	ICalendar calend = CalendarFactory.getCalendar();

	
	@Test	// [ID: 101] The student must be at least 20 years old to receive subsidiary and student loans.
	public void test_Under_20_Years_Old() throws IOException //ID: 101
	{		
		PaymentImpl payment = new PaymentImpl(calend);

		int Expected_Zero_Loan = (0);
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("19980101-0000", 0, 100, 100));
	}
	
	
	@Test	// [ID: 102] The student may receive subsidiary until the year they turn 56.
	public void test_56_Years_Old() throws IOException //ID: 102
	{		
		PaymentImpl payment = new PaymentImpl(calend);

			
		int Expected_Zero = (0);
		assertEquals(Expected_Zero, payment.getMonthlyAmount("19600101-0000", 0, 100, 100));
	}


	@Test	// [ID: 103] The student may not receive any student loans from the year they turn 47.
	public void test_47_Years_Old() throws IOException //ID: 103
	{	
		PaymentImpl payment = new PaymentImpl(calend);

	
		int Expected_Full_Subsidary = (2816);
		assertEquals(Expected_Full_Subsidary, payment.getMonthlyAmount("19690101-0000", 0, 100, 100));
	}

	
	@Test	// [ID: 201] The student must be studying at least half time to receive any subsidiary.
	public void test_studies_half_time() throws IOException //ID: 201
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Subsidary = (3564 + 1396);
		assertEquals(Expected_Subsidary, payment.getMonthlyAmount("19951124-0000", 0, 50, 100));
	}
	
	
	@Test	// [ID: 202] A student studying less than full time is entitled to 50% subsidiary.
	public void test_studies_less_than_full_time() throws IOException //ID: 202
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Half_Subsidary = (1396);
		assertEquals(Expected_Half_Subsidary, payment.getMonthlyAmount("19951124-0000", 0, 70, 100));
	}

	
	@Test	// [ID: 203] A student studying full time is entitled to 100% subsidiary.
	public void test_studies_full_time() throws IOException //ID: 203
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Subsidary = (7088 + 2816);
		assertEquals(Expected_Full_Subsidary, payment.getMonthlyAmount("19951124-0000", 0, 100, 100));
	}
	
	
	@Test	//ID: [301] Test if person with 0 income can get full load if all other is correct
    public void test_zero_income()	throws IOException	//ID: 301
    {	
		PaymentImpl payment = new PaymentImpl(calend);

		int Expected_Full_Loan = (7088 + 2816);
		assertEquals(Expected_Full_Loan, payment.getMonthlyAmount("19951124-0000", 0, 100, 100));
	}

}
