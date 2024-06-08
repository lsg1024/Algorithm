import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, MIN;
    static int[][] abilities;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        abilities = new int[n][n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        MIN = Integer.MAX_VALUE;

        // 인원수 1명부터 n-1명까지 나누는 경우의 수를 모두 고려
        for (int i = 1; i <= n - 1; i++) {
            combi(0, 0, i);
        }

        System.out.println(MIN);
    }

    // 조합 완성된 경우
    static void combi(int idx, int count, int target) {
        if (count == target) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1, target);
                visited[i] = false;
            }
        }
    }

    // 두 팀의 능력 차이를 계산하는 함수
    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team_start += abilities[i][j];
                } else if (!visited[i] && !visited[j]) {
                    team_link += abilities[i][j];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        MIN = Math.min(val, MIN);
    }
}
