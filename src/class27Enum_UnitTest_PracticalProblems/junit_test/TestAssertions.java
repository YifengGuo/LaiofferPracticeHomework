package class27Enum_UnitTest_PracticalProblems.junit_test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAssertions {
	@Test
	public void testAssertions() {
		//test data
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = null;
		String s4 = "abc";
		String s5 = "abc";
		
		int val1 = 5;
		int val2 = 6;
		
		String[] expectedArray = {"one", "two", "three"};
		String[] resultArray = {"one", "two", "three"};
		
		
		assertEquals(s1, s2);  // equals to check if two objects are equal(content)
		
		assertFalse(s1 == s2); // == means to check if two references point to same object
		
		assertTrue(val1 < val2);
		
		assertFalse(val1 > val2);
		
		assertNotNull(s1);
		
		assertNull(s3);
		
		assertSame(s4,s5); //s4 and s5 both point to "abc"
		
		assertNotSame(s1, s3);
		
		assertArrayEquals(expectedArray, resultArray);
	}
}

