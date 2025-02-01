import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, maxCount;
    static int[] dx, dy, dnx, dny, dzx, dzy;
    static String[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dx = new int[] {0, 0, 1, -1};
        dy = new int[] {1, -1, 0, 0};

        dnx = new int[] {1, 0};
        dny = new int[] {0, 1};
        
        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.toString(s.charAt(j));
            }
        }

        maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                swapGraph(i, j);
            }
        }

        System.out.println(maxCount);
        
    }

    // 좌, 하 값 스왑
    static void swapGraph(int y, int x) {
        String first_s = graph[y][x];

        for (int i = 0; i < 2; i++) {
            int nx = x + dnx[i];
            int ny = y + dny[i];

            if (nx >= N || ny >= N) continue; 
            
            String temp = graph[y][x];
            graph[y][x] = graph[ny][nx];
            graph[ny][nx] = temp;
    
            // 검사
            countX(y, graph);
            countX(ny, graph);
            countY(x, graph);
            countY(nx, graph);
    
            // 원래대로 복구
            graph[ny][nx] = graph[y][x];
            graph[y][x] = temp;
        }
        
    }


    static void countX(int y, String[][] copy_graph) {

        int count = 1; 
        for (int j = 1; j < N; j++) {
            if (copy_graph[y][j].equals(copy_graph[y][j - 1])) {
                count++; 
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1; 
            }
        }
        maxCount = Math.max(maxCount, count);
    }


    static void countY(int x, String[][] copy_graph) {

        int count = 1;
        for (int i = 1; i < N; i++) {
            if (copy_graph[i][x].equals(copy_graph[i - 1][x])) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
    
}