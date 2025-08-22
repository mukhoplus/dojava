import java.util.*;

class Solution {
	public String solution(String s) {
		int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(numbers);

		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(numbers[0]));
		sb.append(" ");
		sb.append(Integer.toString(numbers[numbers.length - 1]));

		return sb.toString();
	}
}