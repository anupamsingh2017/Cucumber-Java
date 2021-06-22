package utils;

import java.util.Random;

public class ReusableMethods {

	// Get random string
	public String getRandomString(final int len) {
		final String abc = "abcdefghijklmnopqrstuvwxyz";
		final Random rnd = new Random();
		final StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(abc.charAt(rnd.nextInt(abc.length())));
		}
		return sb.toString();
	}
	
	// Get random integer
	public int getRandomInteger(final int len) {
		final Random rnd = new Random();
		int randInt = (int) Math.pow(10, len-1) + rnd.nextInt(9*(int) Math.pow(10, len-1));
		return randInt;
	}
}
