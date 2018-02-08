package class18IntegerClassAndString;

public class StringIteral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); //true!
		//Reason: Pooling for String Objects
		//There is no need for maintaining several copies of String objects with the same
		//literal, since String objects are immutable
		
		//Usually compiler and JVM will optimize for the number of String objects created
		//it will maintain an intern area in HEAP, for the same String literal, it will 
		//only has one String object associated
		
		String s3 = "abc";
		String s4 = new String("abc");
		System.out.println(s3 == s4); //false, two different objects 
		System.out.println(s3.equals(s4)); //true , two different objects with same semantic meaning
		
		
		String sa = "a";
		String sb = "b";
		String sab = "a" + "b";//compile time concatenation, "ab"
		System.out.println(sab == "a" + "b"); // true, compiler and JVM optimization
		System.out.println(sab == sa + "b");// false, only when run time create a new String object, sa.concat("b")
		System.out.println(sab == sa + sb); // false, only when run time create a new String object, sa.concat(sb)
		// The reason above is because the optimization is at compile time, the literals will be concatenated
		// if possible before getting the String object
		
		// String concatenation:
		   // s1.concat(s2) this will create a new String object rather than change the value of s1 or s2 due
		   // to the immutability
		
		   // s1 = "abc" + "def" is the same as s1 = "abcdef", this happened during compile time for its optimization
		
		   // s1 = 1 + "def" String.valueOf(1) <=== (1 -> Integer(1) -> Integer(1).toString(1) -> "1") how 1 becomes "1"
		
		   // s1 = "id" + "2" + "isStudent: " + true + 'y'
		   // could be further optimized using StringBuilder()   --> sb.append().append....
	}
}
