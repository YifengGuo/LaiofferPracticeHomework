package class4function;

/**
 * 
 * @author yifeng
 *
 * Fermat's Last Theorem: No three positive integers a, b, and c 
 * satisfy the equation a^n + b^n = c^n for
 * any integer value of n greater than 2.
 * if n == 2, it is Pythagorean theorem, 3^2 + 4^2 = 5^2;
 */
public class FermatLastTheorem {

	public static void main(String[] args) {
		new Fermat().check(4);
	}
}

class Fermat {
	private static final int LIMIT = 1000;
	private boolean helper(int a, int b, int n) {
		long c = (long)Math.pow(Math.pow(a, n) + Math.pow(b, n), 1 / n);
		return Math.pow(c, n) == Math.pow(a, n) + Math.pow(b, n);
	}
	
	public void check(int n) {
		for(int i = 1; i < LIMIT; i++) {
			for(int j = 1; j < LIMIT; j++) {
				if(helper(i,j,n)) {
					System.out.println("Successfully found!");
				}
				System.out.println("n is held on: " +n +" where a = "+i+" and b = "+j);
			}
		}
	}
	
}
