package hu.schonherz.web.core.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements hu.schonherz.common.Validator {
	public static final String DATEFORMAT = "MM/dd/yyyy";
	private String date;
	private String format = DATEFORMAT;

	public void setFormat(String format) {
		if (format != null)
			this.format = format;
	}

	public DateValidator(String date) {
		super();
		this.date = date;
	}

	@Override
	public boolean validate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public void setDate(String date) {
		this.date = date;
	}

}
