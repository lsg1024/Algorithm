import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int x = 0;
    static int y = 0;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        find(r, c, size);

        System.out.println(count);
    }

    static void find(int r, int c, int size) {

        if (size == 1) {
            return;
        }
        
        size /= 2;

        if (r < size && c < size) {
            find(r, c, size);
        } else if (r < size && c >= size) {
            count += size * size;
            find(r, c - size, size);
        } else if (r >= size && c < size) {
            count += size * size * 2;
            find(r - size, c, size);
        } else {
            count += size * size * 3;
            find(r - size, c - size, size);
        }
    }
    
}