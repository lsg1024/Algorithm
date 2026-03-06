import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N, a, b, c;
    static int[][] maps;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        maps = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        a = 0;
        b = 0;
        c = 0;
        func(0, 0, N);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
    }

    static void func(int x, int y, int n) {

        // 같은 종이인지 확인
        if (isPaper(x, y, n)) {
            // 종이 나누기
            int number = maps[x][y];
            if (number == -1) {
                a++;
            } else if (number == 0) {
                b++;
            } else {
                c++;
            }
            return;
            
        } else {
            int size = n / 3;

            func(x, y, size);
            func(x + size, y, size);
            func(x, y + size, size);
            func(x + size, y + size, size);
            func(x + 2*size, y, size);
            func(x, y + 2*size, size);
            func(x + 2*size, y + 2*size, size);
            func(x + size, y + 2 * size, size);
            func(x + 2 * size, y + size, size);
        }
        
    }


    static boolean isPaper(int x, int y, int size) {

        int number = maps[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (number != maps[i][j]) return false;
            }
        }
        return true;
    }
    
}