package class23GenericsAndWildCard.generic_method.ComparePairWithGenerics;
/**
 * 
 * @author yifengguo
 * We can write a single generic method declaration that can be called with arguments of different types.
 * Based on the types of the arguments passed to the generic method, the compiler handles each method
 * appropriately
 * 
 *  1. Syntax: All generic method declarations have a type parameter section delimited by angle brackets (< >) that
 *             precedes the method's return type
 *     
 *  2. Number of Generics: Each type parameter section contains one or more type parameters separated by commas.
 *                         A type parameter, also known as a type variable, is an identifier that specifies a 
 *                         generic type name
 *                         
 *  3. Applicable Uses: The type parameters can be used to declare the return type and act as placeholders for the 
 *                      types of the arguments passed to the generic method
 *                      
 *  4. Object only: A generic method's body is declared like that of any other method. Note that type parameters can
 *                  represent only reference types, not primitive types (like in, double and char...)
 */
public class UtilOverride {
	public static <K, V> boolean compare(MyPair<K, V>p1, 
										 MyPair<K, V>p2) {
		return p1.getKey().equals(p2.getKey()) && 
				p1.getValue().equals(p2.getValue());
	}
}
