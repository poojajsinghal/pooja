package com.pooja.examples.truncate;

public class TruncateUtil {
	public static String truncate(String originalString, int noOfChars) {
		String result = "";
		String fixed = " ... (truncated) ... ";
		//System.out.println(fixed.length());
		
		int length = originalString.length();
		if (length < noOfChars) {
			return originalString;
		}
		
		if (noOfChars <= fixed.length() ) {
			return originalString;
		} else {
			int start = (noOfChars-fixed.length())/2;
			result = originalString.substring(0, start);
			result = result.concat(fixed);
			result = result.concat(originalString.substring(length-start));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(truncate("1234567890",5));
		System.out.println(truncate("123456789012345678901234567890",31));
		System.out.println(truncate("123456789012345678901234567890",25));
		
	}
}
