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
		assertEquals(Expected_Zero_Loan, payment.getMonthlyAmount("19990101-0000", 0, 100, 100));
	}
	
	
	@Test	// [ID: 102] The student may receive subsidiary until the year they turn 56.
	public void test_above_56_Years_Old() throws IOException //ID: 102
	{		
		PaymentImpl payment = new PaymentImpl(calend);
			
		int Expected_Zero_Subsidiary = (0);
		assertEquals(Expected_Zero_Subsidiary, payment.getMonthlyAmount("19610101-0000", 0, 100, 100));
	}


	@Test	// [ID: 103] The student may not receive any student loans from the year they turn 47.
	public void test_47_Years_Old() throws IOException //ID: 103
	{	
		PaymentImpl payment = new PaymentImpl(calend);
	
		int Expected_Subsidary = (2816);
		assertEquals(Expected_Subsidary, payment.getMonthlyAmount("19710101-0000", 0, 100, 100));
	}
	
	@Test	// [ID: 201] The student must be studying at least half time to receive any subsidiary.
	public void test_studies_half_time() throws IOException //ID: 201
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Zero_Subsidiary = (0);
		assertEquals(Expected_Zero_Subsidiary, payment.getMonthlyAmount("19951124-0000", 0, 49, 100));
	}
	
	
	@Test	// [ID: 202] A student studying less than full time is entitled to 50% subsidiary.
	public void test_studies_less_than_full_time() throws IOException //ID: 202
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Half_Subsidary = (1396);
		int student_half_loan = (3564);
		assertEquals(Expected_Half_Subsidary, (payment.getMonthlyAmount("19951124-0000", 0, 70, 100) - student_half_loan));
	}

	
	@Test	// [ID: 203] A student studying full time is entitled to 100% subsidiary.
	public void test_studies_full_time() throws IOException //ID: 203
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Subsidary = (7088 + 2816);
		assertEquals(Expected_Full_Subsidary, payment.getMonthlyAmount("19951124-0000", 0, 100, 100));
	}

			// 	[ID: 301] A student who is studying full time or more is permitted to earn a maximum of 85 813SEK per 
	@Test	//	year in order to receive any subsidiary or student loans.
	public void test_maximum_income_per_year() throws IOException //ID: 301
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Money = (7088 + 2816);
		assertEquals(Expected_Full_Money, payment.getMonthlyAmount("19951124-0000", 85813, 100, 100));
	}
			// [ID: 302] A student who is studying less than full time is allowed to earn a maximum of 128 722SEK per 
	@Test	//year in order to receive any subsidiary or student loans.
	public void test_if_studying_less_than_full_time() throws IOException //ID: 302
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Less_Than_Full_Money = (3564 + 1396);
		assertEquals(Expected_Less_Than_Full_Money, payment.getMonthlyAmount("19951124-0000", 128722, 50, 100));
	}
	

			// [ID: 401] A student must have completed at least 50% of previous studies in order to receive any 
	@Test	// subsidiary or student loans.
	public void test_if_student_has_half_completion() throws IOException //ID: 401
	{
		PaymentImpl payment = new PaymentImpl(calend);			
		
		int Expected_Full_Money = (7088 + 2816);
		assertEquals(Expected_Full_Money, payment.getMonthlyAmount("19951124-0000", 0, 100, 50));
	}
	
			// [ID: 501] When and amount paid requirements Full time students are entitled to:
	@Test	// Student loan: 7088 SEK / month
	public void test_if_full_time_gets_full_loan()
	{
		fail("Not done yet");
	}
	
			// [ID: 502] When and amount paid requirements Full time students are entitled to:
	@Test	// Subsidiary: 2816 SEK / month
	public void test_if_full_time_gets_full_subsidiary()
	{
		fail("Not done yet");
	}
	
			// [ID: 503] When and amount paid requirements Less than full time students are entitled to:
	@Test	// Student loan: 3564 SEK / month
	public void test_if__less_than_full_time_gets_less_than_full_loan()
	{
		fail("Not done yet");
	}
	
			// [ID: 504] When and amount paid requirements Less than full time students are entitled to:
	@Test	// Subsidiary: 1396 SEK / month
	public void test_if__less_than_full_time_gets_less_than_full_subsidiary()
	{
		fail("Not done yet");
	}

}
