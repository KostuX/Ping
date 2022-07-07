package time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeHelper {
    public static void printTimeLapsed(Date firstDate)
		  { 		 
	
		Date secondDate = new Date();		 

		   long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		   long hours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		   long minutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
		   long seconds = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		   long miliseconds = TimeUnit.MILLISECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		    String hr = hours > 0 ? String.valueOf(hours)+"hr" :"";
		    String min = minutes > 0 ? String.valueOf(minutes % 60)+"min " :"";
		    String sec = seconds > 0 ? String.valueOf(seconds % 60)+"sec " :"";

		    System.out.println("Time Lapsed: " 
		    + hr
		    + min
		    + sec
		    + miliseconds % 1000+"ms");		    
		
		}
}
