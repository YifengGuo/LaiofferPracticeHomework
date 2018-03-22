package ood.design_pattern.Builder;
/*
 * Builder Pattern
 */
public class User {
	private final String firstName;
	private final String lastName;
	private int age;
	private String phone;
	private String address;
	
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public String toString() {
		return firstName +" "+ lastName +"\nage: "+ age +"\nphone: "+phone +"\naddress: "+address;
	}
	
	
	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	public static void main(String[] args) {
		User user = new UserBuilder("Yifeng","Guo")
						.age(23)
						.phone("+1732-857-9315")
						.address("Rutgers,New Jersey")
						.build();
		
		User user2 = new UserBuilder("William", "Kuo")
			             .age(24)
			             .build();
		
		System.out.println(user.toString());
		System.out.println(user2.toString());
	}
	
	
}
