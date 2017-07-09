package class19CharToInt;

public class Atoi {
	/**
	 * @author @Yifeng
	 * Implement atoi to convert a string to an integer
	 * Assumption: The string is a valid integral number
	 */
	
	/*
	 * careful with all possible input format
	 * 1. null or empty string
	 * 2. leading spaces to trim
	 * 3. + / -?
	 * 4. trailing spaces or other characters
	 * 5. overflow an integer
	 * 6. overflow a long
 	 */
	
	/*
	 * valid input form example:
	 *     (space*) [-|+] (NUM) (Space*)
	 *     and NUM :: = '0' ... '9'
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   +1234232    das2";
		System.out.println(myAtoi(s));
	}
	
	public static int myAtoi(String s) {
		if(s == null || s.length() == 0) { //corner case 1
			return 0;
		}
		
		int n = s.length();
		int index = 0;
		
		while(index < n && s.charAt(index) == ' ') { //corner case 2
			index++;
		}
		
		boolean positive = true; // flag bit to check the num is positive or not
		if(s.charAt(index) == '-' || s.charAt(index) == '+') { //corner case 3
			positive = (s.charAt(index) == '+');  
			index++;
		}
		
		long number = 0; // record number's number format used to check the validation and maintain the number part of input
		while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') { //number part of input
			number = number * 10 + (s.charAt(index) - '0');
			 //corner case 6
			if(number > (long)(Integer.MAX_VALUE) + 1) { //because Integer.MIN_VALUE == Integer.MAX_VALUE + 1, so we 
				                                         // need to check if number > Integer.MAX_VALUE + 1 instead of MAX_VALUE
				break;
			}
			index++;
		}
		number = positive ? number : -number; //corner case 3
		
		//corner case 5  must check after adding sign
		if(number > (long)Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if(number < (long)Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)number;
	}
}
