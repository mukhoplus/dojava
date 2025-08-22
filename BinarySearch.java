import java.util.*;

class Solution {
	public int binarySearch(int[] numbers, int target, int low, int high) {
		if (start > end)
			return -1;

		int index = (low + high) / 2;

		if (numbers[index] == target)
			return index;

		if (numbers[index] > index)
			return binarySearch(numbers, target, low, index - 1);
		else
			return binarySearch(numbers, target, index + 1, high);
	}
}