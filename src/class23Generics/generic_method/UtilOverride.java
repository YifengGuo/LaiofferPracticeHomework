package class23Generics.generic_method;

import class23Generics.generic_method.MyPair;

public class UtilOverride {
	public static <K, V> boolean compare(MyPair<K, V>p1, 
										 MyPair<K, V>p2) {
		return p1.getKey().equals(p2.getKey()) && 
				p1.getValue().equals(p2.getValue());
	}
}
