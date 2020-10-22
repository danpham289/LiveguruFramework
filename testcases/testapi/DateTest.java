package testapi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		date = DateUtils.addHours(date, -11);
		String dateInString="";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		try {
			dateInString = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("invoice"+dateInString.replace(" ", "_")+".pdf");

	}

}
