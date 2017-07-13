package class20Interface_AbstractClass_AccessModifier_Exceptions.TestPolymorphism;

public class Employee extends Person{
	private String companyName;
	public Employee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String companyName) {
		super(name);
		this.companyName = companyName;
	}
	
	public void setCompany(String companyName) {
		this.companyName = companyName;
	}
	
	public static void main(String[] args) {
		Person p = new Employee("123"); //cannot set company name because there no such method in Person
		Employee e = new Employee("321"); // can set company name
	}

}
