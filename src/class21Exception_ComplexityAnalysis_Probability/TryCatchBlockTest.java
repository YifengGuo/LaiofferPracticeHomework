package class21Exception_ComplexityAnalysis_Probability;

public class TryCatchBlockTest {
	public static void test() throws IllegalAccessException {
		try {
			throw new NullPointerException("demo");
			// System.out.println("hello"); //if exception has been thrown, the 
										    //code below it could not be executed
		} catch(NullPointerException e) {
			System.out.println("Caught inside test()");
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			test();
		} catch(IllegalAccessException e) { //test() throw e to outside and main will catch it
			System.out.println("Caught in main()");
		}
	}
}
