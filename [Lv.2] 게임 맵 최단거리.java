import java.util.*;

class Solution {
    class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int[] dx = { -1, +1, +0, +0 };
    public static int[] dy = { +0, +0, -1, +1 };
    
    public boolean inRange(int x, int y, int N, int M) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
    
    public int solution(int[][] maps) {
        int INF = (int) 1e9;
        int N = maps.length;
        int M = maps[0].length;
        
        Deque<Pair> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] countingArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(countingArray[i], INF);
        }
        
        dq.offerLast(new Pair(0, 0));
        visited[0][0] = true;
        countingArray[0][0] = 1;
        
        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst(); 
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (!inRange(nx, ny, N, M)) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;
                if (countingArray[nx][ny] <= countingArray[cur.x][cur.y] + 1) continue;
                
                dq.offerLast(new Pair(nx, ny));
                visited[nx][ny] = true;
                countingArray[nx][ny] = countingArray[cur.x][cur.y] + 1;
            }
        }
        
        return (countingArray[N - 1][M - 1] == INF ? -1 : countingArray[N - 1][M - 1]);
    }
}