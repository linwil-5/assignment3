package ltu;

import java.util.Calendar;
import java.util.Date;

import java.util.*;
import java.text.*;

import java.io.StringReader;
import static ltu.CalendarFactory.getCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
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

public class CalendarImplMar2016 implements ICalendar
{
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
	
	@Override
	public Date getDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertDateToString("20160329"));
		return cal.getTime();
	}
}
