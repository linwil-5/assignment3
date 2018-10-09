package ltu;

import static org.junit.Assert.*;

import java.util.*;
import java.text.*;

import java.io.StringReader;
import static ltu.CalendarFactory.getCalendar;
import java.util.Calendar;
import org.junit.Test;
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
import ltu.CalendarImplJan2016;
import ltu.CalendarImplFeb2016;
import ltu.CalendarImplMar2016;
import ltu.CalendarImplApr2016;
import ltu.CalendarImplMay2016;
import ltu.CalendarImplJun2016;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;


public class PaymentTest
{
	
	
	ICalendar calend = CalendarFactory.getCalendar();

	
	
	
	public Date convertDateToString(String date) {
		try 
		{
			return new SimpleDateFormat("yyyyMMdd").parse(date);
		} 
		catch(Exception e)
		{
			return null;
		}
	}
	
	public String convertStringToDate(Date indate)
	{
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
		/*you can also use DateFormat reference instead of SimpleDateFormat 
			* like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			*/
		try{
			dateString = sdfr.format( indate );
		}catch (Exception ex ){
			System.out.println(ex);
		}
		return dateString;
	}
	
	public String find_which_day(Date indate)
	{
	
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("EEEE", Locale.ENGLISH);
		/*you can also use DateFormat reference instead of SimpleDateFormat 
			* like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			*/
		try{
			dateString = sdfr.format( indate );
		}catch (Exception ex ){
			System.out.println(ex);
		}
		return dateString;
	}
	
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
	
			// [ID: 501] Full time students are entitled to:
	@Test	// Student loan: 7088 SEK / month
	public void test_if_full_time_gets_full_loan() throws IOException  // [ID: 501]
	{
		PaymentImpl payment = new PaymentImpl(calend);	
		
		int Expected_Full_Loan = (7088);
		int student_Full_Subsidiary = (2816);
		assertEquals(Expected_Full_Loan, (payment.getMonthlyAmount("19951124-0000", 0, 100, 100)-student_Full_Subsidiary));

	}
	
			// [ID: 502] Full time students are entitled to:
	@Test	// Subsidiary: 2816 SEK / month
	public void test_if_full_time_gets_full_subsidiary() throws IOException  // [ID: 502]
	{
		PaymentImpl payment = new PaymentImpl(calend);	
		
		int Expected_Full_Subsidiary = (2816);
		int student_Full_Loan = (7088);
		assertEquals(Expected_Full_Subsidiary, (payment.getMonthlyAmount("19951124-0000", 0, 100, 100)-student_Full_Loan));
	}
	
			// [ID: 503] Less than full time students are entitled to:
	@Test	// Student loan: 3564 SEK / month
	public void test_if_less_than_full_time_gets_less_than_full_loan() throws IOException // [ID: 503]
	{
		PaymentImpl payment = new PaymentImpl(calend);	
		
		int Expected_Half_Loan = (3564);
		int student_Full_Subsidiary = (1396);
		assertEquals(Expected_Half_Loan, (payment.getMonthlyAmount("19951124-0000", 0, 99, 100)-student_Full_Subsidiary));
	}
	
			// [ID: 504] When and amount paid requirements Less than full time students are entitled to:
	@Test	// Subsidiary: 1396 SEK / month
	public void test_if_less_than_full_time_gets_less_than_full_subsidiary() throws IOException // [ID: 504]
	{
		PaymentImpl payment = new PaymentImpl(calend);	
		
		int Expected_Half_Subsidiary = (1396);
		int student_Full_Loan = (3564);
		assertEquals(Expected_Half_Subsidiary, (payment.getMonthlyAmount("19951124-0000", 0, 99, 100)-student_Full_Loan));
	}

	@Test // [ID: 505] A person who is entitled to receive a student loan will always receive the full amount.	
	public void test_if_entitled_student_receives_full_amount() throws IOException // [ID: 505]
	{
		fail("not done yet");
	}
	
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_Jan_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplJan2016(); // Tests for Jan
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		
		System.out.println("Payday Jan is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		assertEquals("Friday", find_which_day(convertDateToString(payDay_string)));	
	}
	
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_Feb_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplFeb2016(); // Tests for Feb
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		System.out.println("Payday Feb is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		assertEquals("Monday", find_which_day(convertDateToString(payDay_string)));	
	}
	
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_Mar_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplMar2016(); // Tests for Mar
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		System.out.println("Payday Mar is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		
		assertEquals("Thursday", find_which_day(convertDateToString(payDay_string)));	
	}
	
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_Apr_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplApr2016(); // Tests for Apr
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		System.out.println("Payday Apr is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		assertEquals("Friday", find_which_day(convertDateToString(payDay_string)));	
	}
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_May_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplMay2016(); // Tests for May
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		System.out.println("Payday May is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		assertEquals("Tuesday", find_which_day(convertDateToString(payDay_string)));	
	}
	
	
	@Test // [ID: 506] Student loans and subsidiary is paid on the last weekday (Monday to Friday) every month.	
	public void test_if_loan_or_subsidiary_paid_Jun_2016() throws IOException // [ID: 506]
	{
		ICalendar calend = new CalendarImplJun2016(); // Tests for Jun
		PaymentImpl payment = new PaymentImpl(calend);
		String payDay_string = payment.getNextPaymentDay();
		
		System.out.println("Payday Jun is: " + " payDay_string " + find_which_day(convertDateToString(payDay_string)));
		assertEquals("Thursday", find_which_day(convertDateToString(payDay_string)));	
	}

	
}
