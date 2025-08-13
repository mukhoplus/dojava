import java.util.*;

class Solution {
    public static final int INF = (int) 1e9;

    class Edge implements Comparable<Edge> {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public List<List<Edge>> getGraph(int N) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());
        return graph;
    }

    public int[] getDist(int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        return dist;
    }

    public int[] dijkstra(List<List<Edge>> graph, int start) {
        int[] dist = getDist(graph.size());
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int s = cur.destination;
            int w = cur.weight;

            if (dist[s] < w) continue;

            for (Edge next: graph.get(s)) {
                int e = next.destination;
                int nw = w + next.weight;

                if (dist[e] <= nw) continue;

                dist[e] = nw;
                pq.add(new Edge(e, nw));
            }
        }

        return dist;
    }

    public int getAnswer(int[] dist, int K) {
        int answer = 0;
        for (int i = 1; i < dist.length; ++i)
            if (dist[i] <= K) ++answer;
        return answer;
    }

    public int solution(int N, int[][] road, int K) {
        List<List<Edge>> graph = getGraph(N);

        for (int[] info: road) {
            int start = info[0];
            int end = info[1];
            int weight = info[2];

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        int[] dist = dijkstra(graph, 1);

        return getAnswer(dist, K);
    }
}
