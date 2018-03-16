package class23GenericsAndWildCard.wildcard;

public class Employee {
	private String name;
	private String department;
	private double salary;
	private double bonus;

	
	public Employee(String name, String department, double salary, double bonus) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String toString() {
		return this.name + " " + this.department + " "+  this.salary + " " + this.bonus;
	}
	
}
