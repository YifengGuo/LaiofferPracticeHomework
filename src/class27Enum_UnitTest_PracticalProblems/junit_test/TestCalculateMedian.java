package class27Enum_UnitTest_PracticalProblems.junit_test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/*
 * a naive test document
		null
		empty array
		length == 1 or 2 ? case by case
		odd/even length
		positive values, negative values, or mixed
		unsorted, sorted array
		min value, max value //number overflow
		duplicates
 */


public class TestCalculateMedian {
	
	@BeforeClass
	public static void setUpAll() { // before all and only be called once
		System.out.println("setUpAll() is called");
	}
	
	@AfterClass
	public static void tearDownAll() { // after all and only be called once
		System.out.println("tearDownAll() is called");
	}
	
	@Before
	public void setUp() { // called before each test method
		System.out.println("setUp() is called");
	}
	
	@After
	public void tearDown() { // called after each test method
		System.out.println("tearDown() is called");
	}

	@Test
	public void testBasic() {
		double[] array = {1,2,3};
		CalculateMedian cm = new CalculateMedian();
		double res = cm.getMedian(array);
		//System.out.println(res);
		assertEquals(2, res,0.00001); //to check if result matched with our expected result
									  //if assert double and double equality, we need to offer
		                              // a precision
	}
	
	@Test
	public void testNull() {
		double[] array = null;
		CalculateMedian cm = new CalculateMedian();
		double res = cm.getMedian(array);
		assertEquals(0, res, 0.00001); //we expect 0 as result if input array is null
	}
	
	@Test 
	public void testEvenLength() { //even and odd length of array may affect result of getMedian()
		double[] array = {1.0,2.0,3.0,4.0};
		CalculateMedian cm = new CalculateMedian();
		double res = cm.getMedian(array);
		assertEquals(2.5, res, 0.00001);
	}
	
	@Test
	public void testSorted() { //so getMedian(array) needs the array being sorted
		double[] array = {2.0,3.0,1.0,4.0};
		CalculateMedian cm = new CalculateMedian();
		double res = cm.getMedian(array);
		assertEquals(2.5, res, 0.00001);
	}

}
