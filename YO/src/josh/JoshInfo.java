package josh;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * bussing information:
 * 
 * Leaving From Trowbridge to Churchill:
 * be there 8:07.  take the North point 2 bus to hammarskjold, tell the bus driver that you will be transferring at hammarskjold
 * (will stop at superior first).  At Hammarskjold transfer to north 3 shuttle to Churchill. 
 * 
 * Leaving from Churchill to Trowbridge:
 * get to bus as soon as school is out.  Take North 23 to Hammarskjold. Transfer to North 20 and arrive home 16:39
 * 
 * 
 * 
 * 
 * Leaving from Moms to Churchill:
 * Walk to superior, get there for 9:00.  catch the North 16 to hamarskjold, take north 3 shuttle to churchill
 * 
 * Leaving Churchill to Moms:
 * North 23 to Hammarskjold to take North 16 to superior and then walk home
 * 
 *  
 * @author docere
 *
 */

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
