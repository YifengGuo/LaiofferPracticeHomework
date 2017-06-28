package class5Object;

class Simple {
	public int value;
	
	public Simple(int v) {
		this.value = v;
	}
}
public class ObjectReferenceTest {
	public static void main(String[] args) {
		//case1: input a copy of reference
		Simple originalSimple = new Simple(5);
		changeSimpleValue1(originalSimple);
		System.out.println("The value 5 in object does not change: "+originalSimple.value);
		
		//case2:
		Simple originalSimple2 = new Simple(5);
		changeSimpleValue2(originalSimple2);
		System.out.println("The value 5 in object is changed to: "+originalSimple2.value);
		
		
		//case3:
		Simple originalSimple3 = new Simple(5);
		changeSimpleValue3(originalSimple3);
		System.out.println("This returns origianlSimple3's value: "+ originalSimple3.value);
		System.out.println("This returns a new object's reference: "+ changeSimpleValue3(originalSimple3).value);
		
		int x = 5;
		changeInt(x);
		System.out.println(x);
		
	}

	private static void changeSimpleValue1(Simple simple) {
		Simple newSimple = new Simple(10);//In this case, input simple is a copy of origianlSimple in main()
									      //and both of them point to the same object.
										 
		simple = newSimple;// but if simple(copy) is covered by a new reference of different object, this simple will simply point
		                   // to another object and originalSimple in main() has no change which still points to Simple(5)
	}
	
	private static void changeSimpleValue2(Simple simple) {
		simple.value = 10;// simple is also a copy of originalSimple2 and it points to the object Simple(5)
		                  //however in this method we can access the field of object and change it no matter by which reference of this object
	}
	
	private static Simple changeSimpleValue3(Simple simple) {
		Simple newSimple = new Simple(10); //This method returns a new reference of new object
		                                   //but it does no change to originalSimple3 in main() still
		return newSimple;
	}
	
	private static void changeInt(int x) {
		x = 10;             // primitive type is also passed by a copy of its value, so x in 
				            //main() will not change at all. All the operations happened on a copy of x
	}
}
