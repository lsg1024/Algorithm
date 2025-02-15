import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int tryCount;
    static int[][] graph = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tryCount = 0;
        
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
        
                attach(Integer.parseInt(st.nextToken()));
                if (check()) {
                    System.out.println(tryCount);
                    return;
                }
            }
        }
        
    }

    static void attach(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j] && graph[i][j] == number) {
                    visited[i][j] = true;
                    tryCount++;
                }
            }
        }
    }

    static boolean check() {  

        int binggo = 0;
        
        for (int i = 0; i < 5; i++) {
            if (visited[i][0] && visited[i][1] && visited[i][2] && visited[i][3] && visited[i][4]) {
                binggo++;
            }

            if (visited[0][i] && visited[1][i] && visited[2][i] && visited[3][i] && visited[4][i]) {
                binggo++;
            }
        }

        if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
                binggo++;
        }

        if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) {
                binggo++;
        }

        return binggo >= 3;
    }
    
}

