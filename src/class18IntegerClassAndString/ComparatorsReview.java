package class18IntegerClassAndString;

import java.util.Comparator;
/*
 * when implement your own Comparator or override equals()
 * Be very careful if you see "==" on Object type
 */
public class ComparatorsReview {
	//Bad case 1: be careful if you see "==" on Object type
//	class Mycomparator implements Comparator<Integer> {
//
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			// TODO Auto-generated method stub
//			if(o1 == o2) { // we do not want to check the reference equality
//				return 0;
//			}
//			return o1 < o2 ? 1 : -1;
//		}
		//solution:
		//1. return o1.compareTo(o2);
	    //2. if(o1.equals(o2)) {}
	    //3. if(o1.intValue() == o2.intValue()) {}
//	}
	
	//Bad case 2:
//	class Mycomparator implements Comparator<Integer> {
//
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			// TODO Auto-generated method stub
//			return o1 - o2; // This may cause overflow
//		}
//		
//	}
	
	//Good implementation
	class Mycomparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if(o1 > o2) { // > or < may not cause overflow
				return 1;
			} else if(o1 < o2) {
				return -1;
			}
			return 0;
		}
		
	}
}
