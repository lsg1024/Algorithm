import java.util.*;
import java.lang.*;
import java.io.*;

//F층 10 / 현재 위치 S층 1 / 스타링크 G층 10 / U +2층, D -1층으로 이동 버튼
class Main {
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int result = bfs();

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);   
        }
        
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, 0});
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int ns = current[0];
            int ncnt = current[1];

            if (ns == G) {
                return ncnt;
            }

            //move nextFloor
            int[] nextFloor = new int[] {ns + U, ns - D};

            for (int i = 0; i < 2; i++) {
                if (0 < nextFloor[i] && nextFloor[i] <= F && !visited[nextFloor[i]]) {
                    visited[nextFloor[i]] = true;
                    q.add(new int[] {nextFloor[i], ncnt + 1});
                }
            } 
        }

        return -1;
        
    }
    
}