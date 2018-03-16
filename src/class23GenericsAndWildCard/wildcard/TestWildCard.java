package class23GenericsAndWildCard.wildcard;

import java.util.ArrayList;
import java.util.List;

// declare a generic class Pair to hold the possible employee object
// and record the highest bonus and lowest bonus we want to find
class Pair<E> {
	E first;
	E last;
	public void setFirst(E e) {
		this.first = e;
	}
	
	public void setLast(E e) {
		this.last = e;
	}
	
	public String toString()  {
		return this.first.toString() + "\n" + this.last.toString();
	}
}
public class TestWildCard {
	public static void main(String[] args) {
		testLowerBoundedWildCard();
		
		testUpperBoundedWildCard();
	}
	
	public static void minMaxBonus(Manager[] arr, Pair<? super Manager> result) {
		if (arr == null || arr.length == 0) {
			return;
		}
		Manager min = arr[0];
		Manager max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min.getBonus() > arr[i].getBonus()) {
				min = arr[i];
			}
			if (max.getBonus() < arr[i].getBonus()) {
				max = arr[i];
			}
		}
		result.setFirst(max);
		result.setLast(min);
	}
	
	public static void testLowerBoundedWildCard() {
		// lower bounded wildcard
		// ? super 
		Manager m1 = new Manager("John", "Bussiness", 13000, 2500);
		Manager m2 = new Manager("Jack", "Bussiness", 20000, 6500);
		Manager m3 = new Manager("Tom", "Bussiness", 23000, 2200);
		Manager m4 = new Manager("Jason", "Bussiness", 33000, 9500);
		Manager m5 = new Manager("William", "Bussiness", 43000, 6500);
		Employee e1 = new Manager("Kelly", "Business", 40000, 15000);
		
		Manager[] arr = {m1, m2, m3, m4,m5,(Manager) e1};
		// declare lower bounded wildcard of Pair to restrict the type of E at least
		// is Manager or a super class of Manager
		Pair<? super Manager> result = new Pair<>(); 
		minMaxBonus(arr, result);
		System.out.println(result);
	}
	
	
	// upper bounded wildcard
	// ? extends
	// use case: read a generic object and use it as itself or its superclass
	public static Employee getFirstSalaryEmploee(List<? extends Employee> emps) {
		if (emps == null || emps.size() == 0) {
			return null;
		}
		Employee result = emps.get(0);
		for (Employee e : emps) {
			if (e.getSalary() >= result.getSalary()) {
				result = e;
			}
		}
		return result;
	}
	
	
	
	// List '<' ? extends Number> is actually an upper bound wildcard
	// The upper-bounded wildcard says that any class that extends Employee or
	// Employee itself can be used as the formal parameter type: The problem stems
	// from the fact that Java doesn’t know what type List really is, so we can
	// only read it from list but cannot add some certain instance into the List <? extends Employee>
	public static void testUpperBoundedWildCard() {
		Manager m1 = new Manager("John", "Bussiness", 13000, 2500);
		Manager m2 = new Manager("Jack", "Bussiness", 20000, 6500);
		Manager m3 = new Manager("Tom", "Bussiness", 23000, 2200);
		Manager m4 = new Manager("Jason", "Bussiness", 33000, 9500);
		Manager m5 = new Manager("William", "Bussiness", 43000, 6500);
		Employee e1 = new Manager("Kelly", "Business", 40000, 15000);
		Engineer en1 = new Engineer("Bishop", "Engineer", 63000, 9500);
		Engineer en2 = new Engineer("Sebasian", "Engineer", 103000, 5500);
		Employee e2 = new Employee("Bill", "Managment", 140000, 15000);
		
		
		List<Employee> emps = new ArrayList<>(); // cannot initialized as List<? extends Employee>
	    emps.add(m1);
	    emps.add(m2);
	    emps.add(m3);
	    emps.add(m4);
	    emps.add(m5);
	    emps.add(e1);
	    emps.add(e2);
	    emps.add(en1);
	    emps.add(en2);
	    
	    Employee result = getFirstSalaryEmploee(emps);
	    
	    System.out.println(result);
	}
}
