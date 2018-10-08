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

    @Test
    public void test0MaximumIncome100()		//ID: 301
    {
	ICalendar calend = CalendarFactory.getCalendar();	
	long monthlyGet;
	int shouldBe = (7088 + 2816); 
		
	try{
	
		PaymentImpl payment = new PaymentImpl(calend);	
		monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 0, 100, 100);
        	assertEquals(monthlyGet, shouldBe);
	}
	catch(Exception e){
		StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
    		printWriter.flush();
    		String stackTrace = writer.toString();
    		fail(stackTrace);
	}


    }


    @Test
    public void testMaximumIncome100()		//ID: 301
    {
	ICalendar calend = CalendarFactory.getCalendar();	
	long monthlyGet;
	int shouldBe = (7088 + 2816); 
		
	try{
	
		PaymentImpl payment = new PaymentImpl(calend);	
		monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 85813, 100, 100);
        	assertEquals(monthlyGet, shouldBe);
	}
	catch(Exception e){
		StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
    		printWriter.flush();
    		String stackTrace = writer.toString();
    		fail(stackTrace);
	}


    }

    @Test
	public void testBelowMaxIncome100()	//ID: 301
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (7088 + 2816); 
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 85812, 100, 100);
        	assertEquals(monthlyGet, shouldBe);
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
   			fail(stackTrace);
		}


    }


    @Test
	public void testAboveMaxIncome100()	//ID: 301
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (0); 
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 85814, 100, 100);
        	assertEquals(monthlyGet, shouldBe);
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
   			fail(stackTrace);
		}


    }

    @Test
	public void testNegativeIncome100()	//ID: 301
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (7088 + 2816); 
		boolean shouldFail = true;
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", -128722, 50, 100);
   			fail("no exception thrown");
		}
		catch(Exception e)
		{
        	assertTrue(shouldFail);
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
		}


    }


    @Test
    public void test0MaximumIncome50()		//ID: 302
    {
	ICalendar calend = CalendarFactory.getCalendar();	
	long monthlyGet;
	int shouldBe = (3564 + 1396); 
		
	try{
	
		PaymentImpl payment = new PaymentImpl(calend);	
		monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 0, 50, 100);
        	assertEquals(monthlyGet, shouldBe);
	}
	catch(Exception e){
		StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
    		printWriter.flush();
    		String stackTrace = writer.toString();
    		fail(stackTrace);
	}


    }


    @Test
	public void testMaxIncome50()	//ID: 302
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (3564 + 1396); 
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 128722, 50, 100);
        	assertEquals(monthlyGet, shouldBe);
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
   			fail(stackTrace);
		}


    }

    @Test
	public void testBelowMaxIncome50()	//ID: 302
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (3564 + 1396); 
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 128721, 50, 100);
        	assertEquals(monthlyGet, shouldBe);
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
   			fail(stackTrace);
		}


    }


    @Test
	public void testAboveMaxIncome50()	//ID: 302
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (0); 
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 128723, 50, 100);
        	assertEquals(monthlyGet, shouldBe);
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
   			fail(stackTrace);
		}


    }

    @Test
	public void testNegativeIncome50()	//ID: 302
	{
		ICalendar calend = CalendarFactory.getCalendar();	
		long monthlyGet;
		int shouldBe = (3564 + 1396); 
		boolean shouldFail = true;
	
		try
		{
			PaymentImpl payment = new PaymentImpl(calend);	
			monthlyGet = (long) payment.getMonthlyAmount("1995112400000", -128723, 50, 100);
   			fail("no exception thrown");
		}
		catch(Exception e)
		{
        	assertTrue(shouldFail);
			StringWriter writer = new StringWriter();
    		PrintWriter printWriter = new PrintWriter( writer );
    		e.printStackTrace( printWriter );
   			printWriter.flush();
   			String stackTrace = writer.toString();
		}


    }

}
