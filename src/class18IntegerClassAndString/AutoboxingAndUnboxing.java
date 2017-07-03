package class18IntegerClassAndString;

public class AutoboxingAndUnboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 5;//autoboxing
		int b = 5;//primitive
		System.out.println(a > b); //false // unboxing a.intValue > b, false
		System.out.println(a + 2);//7
		System.out.println(a == b); //true unboxing
		
		//there is a trap using "==", == both operand can be Object and it is comparing if the 
		//two references are pointed to the same object;
		
		Integer a1 = 5; //Integer.valueOf(5)
		Integer c1 = 5; //Integer.valueOf(5)
		System.out.println(a1 > c1); // false normal case
		System.out.println(a1 >= c1); // true normal case
		System.out.println(a1 == c1); //true
		
		//However
		a1 = 129;//Integer.valueOf(129)
		c1 = 129;//Integer.valueOf(129)
		System.out.println(a1 > c1); // false normal case
		System.out.println(a1 >= c1); // true normal case
		
		//Integer class cache the Integer object with value from -128 to 127, so every time an 
		//Integer object within this range is needed, it will always return the corresponding object
		//In this case, two 129 are two different objects in the Heap
		System.out.println(a1 == c1); //false!!!
	}

}
