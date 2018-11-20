import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class Clock {
	
	public static void getClock()
	{
		TimeZone time;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");
		String result = "\n";
		
		time = TimeZone.getTimeZone("Asia/Seoul");
		df.setTimeZone(time);
		result += String.format("%s%n%s%n%n", "Seoul", df.format(date));
		
		time = TimeZone.getTimeZone("JST");
		df.setTimeZone(time);
		result += String.format("%s%n%s%n%n", "Tokyo", df.format(date));
		
		time = TimeZone.getTimeZone("America/Los_Angeles");
		df.setTimeZone(time);
		result += String.format("%s%n%s%n%n", "Los Angeles", df.format(date));
		
		time = TimeZone.getTimeZone("America/New_York");
		df.setTimeZone(time);
		result += String.format("%s%n%s%n%n", "New York", df.format(date));
		
		time = TimeZone.getTimeZone("Pacific/Honolulu");
		df.setTimeZone(time);
		result += String.format("%s%n%s%n%n", "Honolulu", df.format(date));
		
		JOptionPane.showMessageDialog(null, result, "Current Time", 1);
	}
}
