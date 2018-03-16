package class23GenericsAndWildCard.generic_method.ComparePairWithGenerics;

public class GenericMethod2 {
	public static void main(String[] args) {
		// specify the key and value type of class MyPair<K, V>
		MyPair<String, Integer> p1 = new MyPair<String, Integer>("a", 1); // specify K V
		MyPair<String, Integer> p2 = new MyPair<>("b", 2); // diamond
		MyPair<String, Integer> p3 = new MyPair<>("a", 1);
		
		System.out.println(p1 + " compares with " + p2 + " : " + UtilOverride.compare(p1, p2));
		
		// we can also specify the key and value type before the corresponding generic method
		System.out.println(p1 + " compares with " + p3 + " : " + UtilOverride.<String, Integer>compare(p1, p3));
	}
}
