package readablecode.week5.comment;

public class StringBuilderPerformanceExperiment {
	//https://github.com/Null-PE/JavaPlayground/blob/master/src/main/java/day11/StringPlusPerformanceCompare.java
	private static final String S1 = "s";

	public static void main(String[] args) {
		int lengthOfString = 10000;
		logCapacityOf16Char(lengthOfString);
		logCapacityOfLengthOfString(lengthOfString);

	}

	public static void logCapacityOf16Char(int lengthOfString) {

		long startTimeMills = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lengthOfString; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTimeMills = System.currentTimeMillis();
		System.out.println(endTimeMills - startTimeMills);

	}

	public static void logCapacityOfLengthOfString(int lengthOfString) {

		long startTimeMills = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder(lengthOfString);
		for (int i = 0; i < lengthOfString; i++) {
			sb.append(S1);
		}
		sb.toString();

		long endTimeMills = System.currentTimeMillis();
		System.out.println(endTimeMills - startTimeMills);

	}
	
	

}
