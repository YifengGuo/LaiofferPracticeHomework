package class18IntegerClassAndString;

/*
 * Compares two strings lexicographically
 * the comparison is based on the Unicode value of each character in the strings
 * 
 * The result is 0 if the strings are equal; compareTo() return 0 exactly when equals(Object obj) method 
 * would return true
 * 
 * This is the definition of lexicographic ordering. If two strings are different, then either they have
 * different characters at some index that is a valid index for both strings, or their lengths are 
 * different, or both
 * 
 * If they have different characters at one or more index positions, let k be the smallest such Index.
 * In this case, compareTo() returns the difference of the two character values at the position k in the
 * two string -- that is, the value:
 * 		this.charAt(k) - anotherString.charAt(k)
 * 
 * If there is no index position at which they differ, then the shorter string lexicographically
 * precedes the longer string. In this case, compareTo() returns the difference of the lengths of
 * the strings, that is, the value:
 * 		this.length() - anotherString.length()
 */
public class CompareStringInJava {
	public static void main(String[] args) {
		System.out.println("abc".compareTo("abc"));//return 0 for equals() invoked here
		System.out.println("abc".compareTo("abd"));//-1,this.charAt(k) - anotherString.charAt(k) 'c' - 'd'
		System.out.println("ab".compareTo("abcd"));//-2,this.length() - anotherString.length()  2 - 4
	}
}
