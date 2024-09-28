import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[] papers = new int[3];
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isPaper(0, 0, N);

        for (int paper : papers){
            System.out.println(paper);
        }
        
    }

    static void isPaper(int x, int y, int size) {
        if (isCheck(x, y, size)) {
            int number = graph[x][y];
            
            if (number == -1) papers[0] += 1;
            else if (number == 0) papers[1] += 1;
            else papers[2] += 1;
            return;
        }

        int papers_size = size / 3;

        // 하나의 큰 종이별로 9개의 조각이 나옴
        isPaper(x, y, papers_size);
        isPaper(x, y + papers_size, papers_size);
        isPaper(x, y + 2 * papers_size, papers_size);
        isPaper(x + papers_size, y, papers_size);
        isPaper(x + 2 * papers_size, y, papers_size);
        isPaper(x + papers_size, y + papers_size, papers_size);
        isPaper(x + 2 * papers_size, y + papers_size, papers_size);
        isPaper(x + papers_size, y + 2 * papers_size, papers_size);
        isPaper(x + 2 * papers_size, y + 2 * papers_size, papers_size);
    }

    // 같은 종류 종이 인지
    static boolean isCheck(int x, int y, int size) {
        int target = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (graph[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
    
}