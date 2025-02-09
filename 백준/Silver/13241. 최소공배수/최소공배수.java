import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        if (A > B) {
            System.out.println(A*B / find (A, B));
        } else {
            System.out.println(A*B / find(B, A));
        }
    }

    static long find(long A, long B) {
        while (B != 0) {
            long R = A % B;
            A = B;
            B = R;
        }
        return A;
    }    
}