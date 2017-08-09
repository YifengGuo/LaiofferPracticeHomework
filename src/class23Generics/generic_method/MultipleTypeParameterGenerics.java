package class23Generics.generic_method;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultipleTypeParameterGenerics {
	public static <A, B, C> void printAll(A[] arr, List<B> list, Queue<C> queue) {
		for (A a : arr) {
			System.out.print(a + ", ");
		}
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			B b = list.get(i);
			System.out.print(b + ", ");
		}
		System.out.println();
		
		while (!queue.isEmpty()) {
			C c = queue.poll();
			System.out.print(c + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5};
		
		List<Double> list = new ArrayList<>();
		list.add(1.1);
		list.add(2.2);
		list.add(3.3);
		
		Queue<Character> queue = new LinkedList<>();
		queue.offer('A');
		queue.offer('B');
		queue.offer('C');
		
		printAll(arr, list, queue);

	}

}
