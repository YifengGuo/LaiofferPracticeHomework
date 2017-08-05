package class27Enum_UnitTest_PracticalProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

enum ScoreComparator implements Comparator<Student> {
	//Enum shall be capital by default
	MATH_COMPARATOR { 
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getMathScore() - s2.getMathScore();
		}
	},

	ENGLISH_COMPARATOR {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getEnglishScore() - s2.getEnglishScore();
		}
	}
}

public class EnumComparator {
	public static void main(String[] args) { 
		//min heap by default
		
		//math rankings
		PriorityQueue<Student> mathComparator = new PriorityQueue<>(11, ScoreComparator.MATH_COMPARATOR);
		mathComparator.add(new Student("A", 100, 97));
		mathComparator.add(new Student("B", 95, 90));
		while (!mathComparator.isEmpty()) {
			System.out.println(mathComparator.poll().printMathScore());
		}
		
		//english rankings
		//valueOf can receive String input (name of a certain enum)  more readable and this is identical as above
		PriorityQueue<Student> englishComaprator = new PriorityQueue<>(11, ScoreComparator.valueOf("ENGLISH_COMPARATOR"));
		englishComaprator.add(new Student("A", 100, 97));
		englishComaprator.add(new Student("B", 95, 90));
		while (!englishComaprator.isEmpty()) {
			System.out.println(englishComaprator.poll().printEnglishScore());
		}
	}
}

