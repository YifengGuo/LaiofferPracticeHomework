package class19CharToInt;

/**
 * 
 * @author @Yifeng
 * step1: what are the possible characters in the string
 *     >> '0' - '9' ,'.', 'e', 'E', '+', '-' ' ' (communicate with interviewer to confirm)
 *     
 * step2: string trim
 * 
 * step3: +10e2
 *      >> It should be the first char before E/e or the first char after E/e. Nowhere else
 *      
 * step4: the requirement of dot
 *      >> Only before E/e, and only at most one dot in the input
 *  
 * step5: 
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

	}

}
