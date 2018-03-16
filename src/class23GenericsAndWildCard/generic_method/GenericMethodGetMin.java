package class23GenericsAndWildCard.generic_method;
/**
 * 
 * @author guoyifeng
 * 1. There may be times when you'll want to restrict the kinds of types that are allowed to be 
 *    passed to a type parameter
 * 2. For example, a method that operates on numbers might only want to accept instances of Number
 *    or its subclasses. This is what bounded type parameters are for.
 * 3. To declare a bounded type parameter, list the type parameters's name, followed by the extends
 *    keyword, followed by its upper bound
 */
public class GenericMethodGetMin {
	/*
	 *  if input type E will be used for comparing or some other operation 
	 *  that basic Object cannot implement, we need to explicitly declare
	 *  E extends some superclass or implements some interface  
	 */
	public static <E extends Comparable<E>> E getMin(E[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		E min = array[0];
		for (int i = 0; i <array.length; i++) {
			min = array[i].compareTo(min) < 0 ? array[i] : min;
		}
		return min;
	}
	
	/*
	 *  What really happens in java runtime is:
	 *  this is called type erasure and this
	 *  method is generated by compiler called bridge
	 *  method
	 */
//	public static Comparable getMin(Comparable[] array) {
//		if (array == null || array.length == 0) {
//			return null;
//		}
//		Comparable min = array[0];
//		for (int i = 0; i <array.length; i++) {
//			min = array[i].compareTo(min) < 0 ? array[i] : min;
//		}
//		return min;
//	}
	
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
		Character[] charArray = {'W', 'O', 'R', 'L', 'D'};
		
		System.out.println("Array integerArray's min value is: " + getMin(intArray));
		
		
		System.out.println("Array doubleArray min value is: " + getMin(doubleArray));
		
		
		System.out.println("Array charArray min value is: " + getMin(charArray));
		
	}
}
