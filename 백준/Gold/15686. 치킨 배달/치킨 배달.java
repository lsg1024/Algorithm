import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, m, house, chicken, result;
    static int[] house_distance;
    static int[][] graph, houses, chickens;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        house = 0;
        chicken = 0;
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int target = Integer.parseInt(st.nextToken());
                if (target == 1) {
                    house++;   
                }
                if (target == 2) {
                    chicken++;
                }

                graph[i][j] = target;
            }
        }

        // 집 거리
        int max_value = Integer.MAX_VALUE;
        house_distance = new int[house];

        for (int i = 0; i < house; i++) {
            house_distance[i] = max_value;
        }
        
        houses = new int[house][2];
        chickens = new int[chicken][2];
        visited = new boolean[chicken];

        int index_1 = 0;
        int index_2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = graph[i][j];
                if (value == 1) {
                    houses[index_1][0] = i;
                    houses[index_1][1] = j;
                    index_1++;
                }
                if (value == 2) {
                    chickens[index_2][0] = i;
                    chickens[index_2][1] = j;
                    index_2++;
                }
            }
        }

        dfs(0, 0);

        System.out.println(result);
        
    }

    static void dfs(int start, int cnt) {

        if (cnt == m) {

            int total = 0;
            
            for (int i = 0; i < house; i++) {
                int x_value = houses[i][0];
                int y_value = houses[i][1];
                int min_dist = Integer.MAX_VALUE;

                for (int j = 0; j < chicken; j++) {
                    if (visited[j]) {
                        int sum = (Math.abs(x_value - chickens[j][0]) + Math.abs(y_value - chickens[j][1]));
                        min_dist = Math.min(min_dist, sum);
                    }
                }
                total += Math.min(house_distance[i], min_dist);
            }

            if (result > total) {
                result = total;
            }
            
            return;
        }

        for (int i = start; i < chicken; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1,cnt + 1);
                visited[i] = false;   
            }   
        }
        
    }

}