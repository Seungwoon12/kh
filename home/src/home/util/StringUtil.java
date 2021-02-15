package home.util;

import java.util.Random;

public class StringUtil {
	public static String generateRandomString(int size) {
		String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();//문자열 합성기
		Random r = new Random();
		for(int i=0; i<size; i++) {
			int index = r.nextInt(baseString.length());
			buffer.append(baseString.charAt(index));
		}
		String str = buffer.toString();
		return str;
	}
}