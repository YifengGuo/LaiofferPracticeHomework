package class23GenericsAndWildCard.wildcard;

public class Manager extends Employee {
	private String name;
	private final String department = "Business";
	private double salary;
	private double bonus;
	public Manager(String name, String department, double salary, double bonus) {
		super(name, department, salary, bonus);
	}

}
