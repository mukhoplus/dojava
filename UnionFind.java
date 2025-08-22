import java.util.*;

class Solution {
	public int findParent(int[] parants, int x) {
		if (parants[x] != x)
			parants[x] = findParent(parants, parants[x]);
		return parants[x];
	}

	public void unionParent(int[] parents, int a, int b) {
		a = findParent(parents, a);
		b = findParent(parents, b);

		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}
	/*
	int LEN = 5;
	int[] parents = new int[LEN];

	Arrays.fill(parents, LEN); // [5, 5, 5 ,5 ,5]
	Arrays.setAll(arr, i -> i); // [0, 1, 2, 3, 4]
	 */
}