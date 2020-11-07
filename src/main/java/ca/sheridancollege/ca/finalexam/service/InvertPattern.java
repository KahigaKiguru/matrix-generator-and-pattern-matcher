package ca.sheridancollege.ca.finalexam.service;

public class InvertPattern {
//	Invert the forward pattern
	public static  String invertPattern(String pattern) {
		String result = "";
		int patternLength = pattern.length();
		
		for (int x = patternLength; x > 0; x--) {
			result += pattern.charAt(x - 1);
		}

		return result;
	}
}


