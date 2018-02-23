package class21Exception_ComplexityAnalysis_Probability;
/*
 * The flow of execution of the program stops immediately after the throw statement is
 * executed and 
 *     1. the nearest enclosing try block is checked to see if it has a catch statement
 *        that matches the type of execution
 *        a. if it finds a match, the control is transferred to that statement
 *        b. otherwise next enclosing try block is checked and so on
 *           i. If no matching catch is found then the default exception handler will
 *              halt the program
 */
public class CatchMultipleException {
	static void test() throws NullPointerException, IllegalAccessException {
		System.out.println("Inside test(). ");
		throw new NullPointerException("NPE"); // this exception will be caught in the main()
		                                       // and the program exits after handling the exception
	}
	
	static void test2() throws NullPointerException, IllegalAccessException {
		test();
		System.out.println("Inside test2()");
	}
	public static void main(String[] args) {
		// result: Inside test(). 
		try {
			test2();
		} catch(NullPointerException | IllegalAccessException e) { //handle at one time
                                                                   //but one block can only 
                                                                   //throw one exception at one
                                                                   //time, so it actually handle one exception 
                                                                   //at once
			e.printStackTrace();
		}
		
//		try {           //This is a more normal writing style
//			test2();
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

}
