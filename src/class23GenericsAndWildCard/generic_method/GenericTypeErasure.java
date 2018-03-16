package class23GenericsAndWildCard.generic_method;

import java.util.ArrayList;
import java.util.List;
/*
 *  If all types match during compile time (without compile error)
 *  java will erase all the types during runtime and only keep
 *  primitive types (the compiler will keep the method signature and
 *  generate bridge method)
 */
/*
 * From type erasure:
 * 	1. Generic types must be subclass of Object, or it cannot be converted to Object
 *  2. Type-check during run time can only check its Original type (like ArrayList in the test program)
 */
public class GenericTypeErasure {
	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		
		Class c1 = integerList.getClass();
		Class c2 = stringList.getClass();
		
		System.out.println(c1 == c2); // during run time they are all 
									  // java.util.ArrayList
		System.out.println(c1);
		/*
		 *  Successfully add a String to integerList
		 *  based on the type erasure of java during 
		 *  run time
		 */
		try {
			integerList.getClass()
			.getMethod("add", Object.class)
			.invoke(integerList, "a");
			System.out.println(integerList.size());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
