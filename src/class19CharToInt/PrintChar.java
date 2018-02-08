package class19CharToInt;

public class PrintChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 = 65;
		
		int a2 = 6;//6 in ascii map is unprintable
		
		int a3 = 256 + 65;
		
		// a4 is int which is 32 bit, and 256 * 256 = 1 0000  ... 0000(32 0s)
		//so if convert a4 to char , the high bits higher than 16 bits are 
		//invisible, so a4 is simply 65 in ascii 
		int a4 = 256 * 256 + 65;
		
		int a5 = -1000;
		
		long a6 = (long)(Math.pow(2, 32) - 1000);
		
		char c = (char)a4;
		
		System.out.println(c);
		
		System.out.println('1' + '2' == '3');//false == ascii 99
		System.out.println('6' - '3' == 3);//true
		
		
	}

}
