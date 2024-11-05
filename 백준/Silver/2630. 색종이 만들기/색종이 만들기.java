import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[] result;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        
        result = new int[2];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할탐색
        func_1(0, 0, N);

        for (int num : result) {
            System.out.println(num);
        }
        
    }

    static void func_1(int x, int y, int size) {

        if (func_2(x, y, size)) {
            int target = graph[x][y];
            result[target]++;
            return;
        } else {
            // 사분면 위치에서 false가 나온 경우 즉 일치 하지 않은 경우
            size /= 2;
            
            func_1(x, y, size);
            func_1(x + size, y, size);
            func_1(x, y + size, size);
            func_1(x + size, y + size, size);
        }
        
    }

    static boolean func_2(int x, int y, int size) {

        int target = graph[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (target != graph[i][j]) {
                    return false;
                }
            }
        }

        return true;
        
    }
    
}