package ood.design_pattern.Builder;

public class ConstructorUsingSetterAndGetter {
	private final String firstName;//required
	private final String lastName;//required
	private int age;//optional
	private String phone;//optional
	private String address;//optional
	
	/*
	 * this solution is hard to confirm when the initialization of 
	 * the object of this class is complete.
	 */
	public ConstructorUsingSetterAndGetter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
