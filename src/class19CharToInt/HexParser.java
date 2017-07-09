package class19CharToInt;

public class HexParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'F';
		System.out.println(parseHex(c));
	}
	
	public static int parseHex(char c) {
		if(c >= '0' && c <= '9') {
			return c - '0';
		}
		if(c >= 'a' && c <= 'f') {
			return 10 + (c - 'a');
		}
		if(c >= 'A' && c <= 'F') {
			return 10 + (c - 'A');
		}
		
		return Integer.MAX_VALUE;
	}

}
