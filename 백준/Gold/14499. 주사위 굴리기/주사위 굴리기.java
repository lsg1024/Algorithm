import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, x, y, K;
    static int[][] maps;
    static int[] dices = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {

            int way = Integer.parseInt(st.nextToken());
            int nx;
            int ny;

            if (way == 1) {
                nx = x;
                ny = y + 1;

                if (isVisited(nx, ny)) {
                    left();
                    printDice(nx, ny);
                    x = nx;
                    y = ny;
                    System.out.println(dices[0]);
                }
                
            } else if (way == 2) {
                 nx = x;
                 ny = y - 1;

                if (isVisited(nx, ny)) {
                    right();
                    printDice(nx, ny);
                    x = nx;
                    y = ny;
                    System.out.println(dices[0]);
                }

                
                
            } else if (way == 3) {
                 nx = x - 1;
                 ny = y;

                if (isVisited(nx, ny)) {
                    top();
                    printDice(nx, ny);
                    x = nx;
                    y = ny;
                    System.out.println(dices[0]);
                }

                
            } else {
                 nx = x + 1;
                 ny = y;

                if (isVisited(nx, ny)) {
                    bottom();
                    printDice(nx, ny);
                    x = nx;
                    y = ny;
                    System.out.println(dices[0]);
                }

                
            }


        }
        
    }

    static void printDice(int nx, int ny) {
        if (maps[nx][ny] == 0) {
                maps[nx][ny] = dices[2];
        } else {
            dices[2] = maps[nx][ny];
            maps[nx][ny] = 0;
        }
    }

    static boolean isVisited(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < M) {
            return true;
        }
        return false;
    }

    static void bottom() {
        int temp = dices[0];
        dices[0] = dices[1];
        dices[1] = dices[2];
        dices[2] = dices[3];
        dices[3] = temp;
    }

    static void top() {
        int temp = dices[0];
        dices[0] = dices[3];
        dices[3] = dices[2];
        dices[2] = dices[1];
        dices[1] = temp;
    }

    static void left() {
        int temp = dices[0];
        dices[0] = dices[4];
        dices[4] = dices[2];
        dices[2] = dices[5];
        dices[5] = temp;
    }

    static void right() {
        int temp = dices[0];
        dices[0] = dices[5];
        dices[5] = dices[2];
        dices[2] = dices[4];
        dices[4] = temp;
    }
    
}