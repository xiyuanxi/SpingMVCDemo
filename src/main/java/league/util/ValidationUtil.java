package league.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
	private static final String ACCOUNTNAME_PATTERN = "^[a-zA-Z0-9_-]{2,20}$";

	/**
	 * Verify the validity of the Integer number
	 * 
	 * @param input
	 * @return
	 */
	public static boolean IsNumeric(String input) {
		try {
		    Integer.parseInt(input);
		    return true;
		  }
		  catch (NumberFormatException e) {
		    // s is not numeric
		    return false;
		  }
	}
	
	/**
	 * Verify the validity of the account name
	 * 
	 * @param input
	 * @return
	 */
	public static boolean IsAccountName(String input) {
		Pattern accountNamePattern;
		Matcher matcher;

		accountNamePattern = Pattern.compile(ACCOUNTNAME_PATTERN);
		matcher = accountNamePattern.matcher(input);
		return matcher.matches();
	}
}
