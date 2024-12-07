import java.util.*;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int STRAIGHT_COST = 100;
    static final int CORNER_COST = 500;

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 각 방향에서의 최소 비용
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));
        for (int i = 0; i < 4; i++) {
            pq.offer(new int[]{0, 0, i, 0}); // x, y, direction, cost
            cost[0][0][i] = 0;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int dir = current[2];
            int currentCost = current[3];

            if (x == n - 1 && y == n - 1) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                    continue;
                }

                int newCost = currentCost + STRAIGHT_COST;
                if (dir != i) {
                    newCost += CORNER_COST; // 방향이 바뀌면 코너 비용 추가
                }

                if (newCost < cost[nx][ny][i]) {
                    cost[nx][ny][i] = newCost;
                    pq.offer(new int[]{nx, ny, i, newCost});
                }
            }
        }

        return Arrays.stream(cost[n - 1][n - 1]).min().orElse(Integer.MAX_VALUE);
    }
}
