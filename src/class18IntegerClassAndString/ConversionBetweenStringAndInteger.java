package class18IntegerClassAndString;

public class ConversionBetweenStringAndInteger {
	public static void main(String[] args) {
		/************** number to String  *************/
		// primitive number to String
		int i = 0;
		// method 1
		String s1 = i + ""; // "0"
		// method 2
		s1 = String.valueOf(i);
		// method 3
		s1 = Integer.toString(i);
		
		// Wrapper class (Integer to String)
		Integer integer = null;
		// method 1
		String s2 = integer.toString();
		// method 2
		s2 = String.valueOf(integer);
		
		
		
		/************** String to number  *************/
		String s3 = "11";
		// method 1
		Integer a = Integer.valueOf(s3);
		// method 2
		a = Integer.parseInt(s3);

	}
	
}
