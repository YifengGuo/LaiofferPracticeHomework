package class27Enum_UnitTest_PracticalProblems;

public class Student {
	private String name;
	private int mathScore;
	private int englishScore;
	
	public Student(String name, int mathScore, int englishScore) {
		this.name = name;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
	}
	
	public int getMathScore() {
		return this.mathScore;
	}
	
	public int getEnglishScore() {
		return this.englishScore;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String printMathScore() {
		return this.name + "'s math score is : " + this.mathScore;
	}
	
	public String printEnglishScore() {
		return this.name + "'s english score is : " + this.englishScore;
	}
}
