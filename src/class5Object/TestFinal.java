package class5Object;

class Student {
	String name;
	public Student(String name) {
		this.name = name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
}

class Boy extends Student {
	final Student girlFriend;
	public Boy(String name, Student gf) {
		super(name);
		this.girlFriend = gf;
	}
	
	public void setGirlName(String name) {
		this.girlFriend.setName(name);
	}
}
public class TestFinal {
	public static void main(String[] args) {
		Boy John = new Boy("John", new Student("Lily"));
		
		// field girlFriend of class Boy is final, so cannot be assigned more than once 
//		John.girlFriend = new Student("Cathy"); 
		
		
		// can do because we can modify the non-private field of an object
		// even though it is modified by final
		// we did not John's girlFriend itself
		John.girlFriend.setName("Cathy");
		System.out.println(John.girlFriend.name);
		
	}
}
