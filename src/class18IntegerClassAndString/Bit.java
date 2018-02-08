package class18IntegerClassAndString;

public class Bit {
	public static void printBinary(int value) {
		System.out.println(value + ": ");
		StringBuilder builder = new StringBuilder();
		for(int shift = 31; shift >= 0; shift--) {
			builder.append((value >>> shift) & 1);
		}
		System.out.println(builder.toString());
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a = 0;
		printBinary(a);
		
		a = 5;
		printBinary(a);
		
		a = -5;
		printBinary(a);// use two's complement  -> binary number x, x'complement + 1 = -x
		
		// Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
		// Integer.MIN_VALUE - 1 = Integer.MAX_VALUE
		a = Integer.MIN_VALUE;
		printBinary(a);
		
		a = Integer.MAX_VALUE;
		printBinary(a);
		
		a = -1;
		printBinary(a);
		
		printBinary(Integer.MIN_VALUE + 1);
		
		int b = a >> 5;//maintain symbol bit arithmetical shift
		printBinary(b);
		
		b = a >>> 5; // logic way, disregard left-most bit
		printBinary(b);
	}
}
