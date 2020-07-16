package co.com.japl.facturacionelectronica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	
	public static final Date format(String date,String format) throws RuntimeException {
		try {
			SimpleDateFormat formater =  new SimpleDateFormat(format);
			return formater.parse(date);
		}catch(ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
