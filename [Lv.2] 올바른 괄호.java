import java.util.*;

class Solution {
	boolean solution(String s) {
		Deque<Character> dq = new ArrayDeque<>();

		for (char c: s.toCharArray()) {
			if (c == '(') {
				dq.offerLast(c);
				continue;
			}

			if (dq.isEmpty())
				return false;
			if (dq.peekLast() == ')')
				return false;
			dq.pollLast();
		}

		if (!dq.isEmpty())
			return false;
		return true;
	}
}