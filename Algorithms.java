package Vigeniere;

public class Algorithms {

//	static String ASCII = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
//	static char firstChar = ASCII.charAt(0);
//	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
//	static char a = 'a';
//	static char b = 'b';
	static char nextLetter;
		
	public Algorithms() {
		
	}
	
	public static String encrypt(String input, String key) {
		String newKey = key;
		String output = "";
		
		while(newKey.length() < input.length()) {
			newKey += key;
		}
		
		while(newKey.length() > input.length()) {
			newKey = newKey.substring(0, newKey.length() - 1);
		}
		
		for(int i = 0; i < input.length(); i++) {

			nextLetter = (char) (input.charAt(i) + newKey.charAt(i));
//			try {																														old method used if you want to 
//																																		limit the range of characters
//				nextLetter = ASCII.charAt(((input.charAt(i) - firstChar) + (newKey.charAt(i)) - firstChar));							with a String of every character
//			} catch(StringIndexOutOfBoundsException e) {
//				nextLetter = ASCII.charAt(((input.charAt(i) - firstChar) + (newKey.charAt(i)) - firstChar) - ASCII.length());
//			}
			output += nextLetter;
		}
		
		return output;
	}
	
	public static String decrypt(String input, String key) {
		String newKey = key;
		String output = "";
		
		while(newKey.length() < input.length()) {
			newKey += key;
		}
		
		while(newKey.length() > input.length()) {
			newKey = newKey.substring(0, newKey.length() - 1);
		}
		
		for(int i = 0; i < input.length(); i++) {

			nextLetter = (char) (input.charAt(i) - newKey.charAt(i));
//			try {
//				nextLetter = ASCII.charAt(((input.charAt(i) + firstChar) - (newKey.charAt(i)) - firstChar));
//			} catch(StringIndexOutOfBoundsException e) {
//				nextLetter = ASCII.charAt(((input.charAt(i) + firstChar) - (newKey.charAt(i)) - firstChar) + ASCII.length());
//			}
			output += nextLetter;
		}
		
		return output;
	}
}