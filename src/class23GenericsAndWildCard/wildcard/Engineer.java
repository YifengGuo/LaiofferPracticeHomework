package class23GenericsAndWildCard.wildcard;

public class Engineer extends Employee {
	private String name;
	private final String department = "Engineering";
	private double salary;
	private double bonus;
	public Engineer(String name, String department, double salary, double bonus) {
		super(name, department, salary, bonus);
	}

}
