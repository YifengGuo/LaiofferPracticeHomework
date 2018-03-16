package class23GenericsAndWildCard;
/**
 * 
 * @author guoyifeng
 * Syntax:
 * 		 class ClassName <T> {
 * 
 *       }
 *       <T> declares this is a generic class and its
 *         a. member variable
 *         b. method parameter
 *         c. method return type
 *         d. method local variable
 *       could be generic type T
 * @param <T> value of generic class field
 */
class Node<T> {
	private T value;

	public Node(T value) {
		this.value = value;
	}

	public String toString() {
		return this.getValue().toString();
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

public class GenericClass {

	public static void main(String[] args) {
		Node<Integer> n = new Node<>(1);
		System.out.println(n.toString());
		Node<String> n2 = new Node<>("name");
		n2.setValue("String");
		System.out.println(n2.toString());

	}
}
