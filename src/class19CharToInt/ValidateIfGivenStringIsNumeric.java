package class19CharToInt;

/**
 * 
 * @author @Yifeng
 * step1: what are the possible characters in the string
 *     >> '0' - '9' ,'.', 'e', 'E', '+', '-' ' ' (communicate with interviewer to confirm)
 *     
 * step2: string trim
 * 
 * step3: the requirement of sign: eg: +10e2
 *      >> It should be the first char before E/e or the first char after E/e. Nowhere else
 *      
 * step4: the requirement of dot
 *      >> Only before E/e, and only at most one dot in the input
 *  
 * step5: the requirement of E/e
 *      >> There can be only one; must have number before it and after it
 */
public class ValidateIfGivenStringIsNumeric {
	/*
	 * format of rules:
	 *     space = ''
	 *     NUM::= '0'|'1'|...|'9'
	 *     Dot::='.'
	 *     
	 *     (space*) ['+' | '-'] (NUM*) [DOT(NUM*)] [('E'|'e') (['+' | '-']) (NUM+)] (space*)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "-10.5e-3";
		System.out.println(isNumeric(num));

	}

	public static boolean isNumeric(String s) {
		s = s.trim(); // cut off head and tail whitespaces
		boolean seenNumber = false;
		boolean seenSignBeforeE = false;
		boolean seenDot = false;
		boolean seenE = false;
		boolean seenSignAfterE = false;
		boolean seenNumberAfterE = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' || c == '-') { // if current char is a sign character
				// case 1 if we have met dot or number but did not see E/e, but in this case, sign must be right after E/e, so return false
				// case 2 if sign is not before number before E/e, then it must be right after E, but we have seen number after E, so in this case return false as well
				if (((seenDot || seenNumber) && !seenE) || seenNumberAfterE) {
					return false;
				}
				// case 1: already has sign right after E/e, so there no place for extra sign, so return false
				// case 2: E has never appeared, and there is sign before E, so we do not need two more signs for a number without E/e, so return false
				if (seenSignAfterE || (!seenE && seenSignBeforeE)) {
					return false;
				}
				if (seenE) { // if E is seen, immediately update seenSignAfterE
					seenSignAfterE = true;
				} else { // or update seenSignBeforeE
					seenSignBeforeE = true;
				}
			} else if (c >= '0' && c <= '9') { // current character is numerical
				seenNumber = true;
				if (seenE) {
					seenNumberAfterE = true;
				}
			} else if (c == 'e' || c == 'E') { // current character is E/e
				if (seenE) { // duplicate E/e, we can only have E/e appeared once and only once
					return false;
				}
				if (!seenNumber) { // E/e cannot appear without any number preceding
					return false;
				}
				seenE = true;
			} else if (c == '.') { // current character is dot, dot can only be before E/e and only appear once
				if (seenE || seenDot) {
					return false;
				}
				seenDot = true;
			} else { // other characters cannot appear in the numerical format
				return false;
			}
		}
		if (seenE && !seenNumberAfterE) { // if this number is represented with E/e, then there must exist some number after E/e
			return false;
		}
		return seenNumber;
	}

}
