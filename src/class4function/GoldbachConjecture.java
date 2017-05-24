package class4function;

/**
 * 
 * @author Yifeng 
 * Each even integer greater than 2 can be expressed as the sum of two primes
 *
 */
public class GoldbachConjecture {

	public static void main(String[] args) {
		int even = 20;
		int limit = 10000;
		for(int i = 4; i <= limit; i++) {
			helper(i);
		}
		//helper(even);

	}

	public static boolean helper(int even) {
		if(even < 4 || even % 2 != 0  ) {
			System.out.println("Please input an even integer greater than 4.");
			return false;
		}
		int halfEven = even / 2;
		int prime1 = halfEven - 1;
		int prime2 = halfEven + 1;
		while (prime1 >= 2) {
			if (isPrime(prime1) && isPrime(prime2)) {
 				System.out.println(even + " can be expressed by two primes which are:"+ prime1 +" and "+ prime2);
				return true;
			} else if (!isPrime(prime1) || !isPrime(prime2)) {
				prime1 -= 2;
				prime2 += 2;
			}
		}
		System.out.println(even + " cannot be expressed by two primes.");
		return false;

	}

	/* my edition for checking if a is a prime number*/
//	private static boolean isPrime(int a) {
//		int i = 2;
//		while(i < a) {
//			if(a % i == 0) {
//				return false;
//			}
//			else i++;
//		}
//		if(i == a) {
//			return true;
//		}
//		else return false;
//	}
	
	/*solution for checking the prime validity*/
	private static boolean isPrime(int a) {
		for(int i = 2; i * i <= a ; i++) {
			if(a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
