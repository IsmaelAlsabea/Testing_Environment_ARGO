package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date_Handler {

	private Date_Handler() {

	}

	public static String date_to_string(Date date) {

		if (date != null)
			return date.toString();
		return null;
	}

	public static Date string_to_date(String date_as_a_String) {

		if (date_as_a_String == null || date_as_a_String.isBlank())
			return null;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date_as_a_String);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date theDate = new Date(parsed.getTime());

		return theDate;
	}
}
