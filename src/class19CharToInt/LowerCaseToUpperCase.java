package class19CharToInt;

public class LowerCaseToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'b';
		System.out.println(toUpper(c));
	}
	
	public static char toUpper(char lower) {
		return (char)(lower - 'a' + 'A');
	}

}
