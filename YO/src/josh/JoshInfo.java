package josh;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JoshInfo {

	public static final String bussingWebsite = "http://www.ststb.ca/";
	public static final String OEN = "619-546-278";
	public static final Date birthDate = new GregorianCalendar(2000, Calendar.JANUARY, 31).getTime();
	
	
	public double calculateAge()
	{
		Calendar now = Calendar.getInstance();
		GregorianCalendar dob = new GregorianCalendar();
		dob.setTime(birthDate);
		
		int factor = 0;
		if(now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
		      factor = -1; 
		}
		
		int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR) + factor;
		System.out.println("Age is: "+age);
		
		
		return age;
	}
	
	public static void main(String[] args) {
		JoshInfo joshInfo = new JoshInfo();
		joshInfo.calculateAge();
	}
}
