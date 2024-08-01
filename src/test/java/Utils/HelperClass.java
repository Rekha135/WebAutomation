package Utils;

import org.apache.commons.lang.RandomStringUtils;

public class HelperClass {
	
	public static String generateRandomText() {
		String text = "";
		String Alpha = RandomStringUtils.randomAlphanumeric(6);
		text = Alpha;
		return text;
	}
}
