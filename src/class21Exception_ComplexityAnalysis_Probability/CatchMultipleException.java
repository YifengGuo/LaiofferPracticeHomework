package class21Exception_ComplexityAnalysis_Probability;

public class CatchMultipleException {
	static void test() throws NullPointerException, IllegalAccessException {
		System.out.println("Inside test(). ");
		throw new NullPointerException("NPE");
	}
	
	static void test2() throws NullPointerException, IllegalAccessException {
		test();
		System.out.println("Inside test2()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test2();
		} catch(NullPointerException | IllegalAccessException e) { //handle at one time
																  //but one block can only 
			          											  //throw one exception at one
																  //time, so it actually handle one exception 
																  //at once
			e.printStackTrace();
		}
		
//		try {                        //This is a more normal writing style
//			test2();
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

}
