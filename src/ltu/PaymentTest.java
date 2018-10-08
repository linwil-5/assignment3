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
    public void test0MaximumIncome100()	throws IOException	//ID: 301
    {
		
		ICalendar calend = CalendarFactory.getCalendar();

		PaymentImpl payment = new PaymentImpl(calend);			
		
		long monthlyGet;
		int shouldBe = (7088 + 2816); 
		
		monthlyGet = (long) payment.getMonthlyAmount("1995112400000", 0, 100, 100);
		assertEquals(monthlyGet, shouldBe);
	}
}
