package ood.design_pattern.Builder;

public class ConstructorWithTooManyParams {
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	//in this case there are too many parameters in the constructor
	public ConstructorWithTooManyParams(String firstName, String lastName, int age, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	
}
