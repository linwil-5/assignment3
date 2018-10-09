package ltu;

import java.util.Calendar;
import java.util.Date;

public class CalendarImpl implements ICalendar
{
	@Override
	public Date getDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	public Date getDate(Calendar calender)
	{
		calender = Calendar.getInstance();
		return calender.getTime();
		
	}
	
}
