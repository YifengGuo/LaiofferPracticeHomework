package class27Enum_UnitTest_PracticalProblems.junit_test;

import java.util.Arrays;

/**
 * 
 * @author @Yifeng
 * Example of Unit Test
 */
public class CalculateMedian {
	public double getMedian(double[] array) {
		if (array == null) {
			return 0;
		}
		Arrays.sort(array);
		
		int n = array.length;
		if (n % 2 == 1) {
			return array[n / 2];
		}
		return (array[n / 2] + array[(n-1) / 2]) / 2.0;
	}
}

/*
 * test contents
 */
// null
// empty array
// length == 1 or 2 ? case by case
// odd/even length
// positive values, negative values, or mixed
// unsorted, sorted array
// min value, max value //number overflow
// duplicates
