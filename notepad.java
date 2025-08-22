import java.util.*;

// 낙서장
class Notepad {
	// 주요 자료구조, 커스텀 정렬
	class DataStructure {
		class Edge implements Comparable<Edge> {
			int d, w;

			Edge(int d, int w) {
				this.d = d;
				this.w = w;
			}

			@Override
			public int compareTo(Edge other) {
				return this.w - other.w;
			}
		}

		// ArrayList
		List<Integer> numberList = new ArrayList<>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		numberList.get(0); // 1
		numberList.remove(0); // [1, 2]
		numberList.size(); // 2
		numberList.indexOf(1); // 0
		int[] numberArray = numberList.stream().mapToInt(i -> i).toArray();

		// HashMap
		Map<String, Integer> map = new HashMap<>();
		map.put("묵호", 1);
		map.getOrDefault("쌈무", 0) + 1;
		map.get("묵호"); // 1
		map.containsKey("나린"); // false

		// Deque(Queue, Stack)
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerFirst(1); // [1]
		dq.offerLast(2); // [1, 2]
		dq.peekFirst(); // 1
		dq.peekLast(); // 2
		dq.pollFirst(); // [2], return 1
		dq.pollLast(); // [], return 2
	}

	// StreamBuilder
	class StreamBuilderTest {
		StreamBuilder sb = new StreamBuilder();
		sb.append("m");
		sb.append("u");
		sb.append("k");
		// return sb.toString();
	}

	public static void main(String[] args) {

	}
}