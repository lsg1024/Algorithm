import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static long a, b, c;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(powMethod(a, b, c));
    }

    static long powMethod(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }

        long n = powMethod(a, b / 2, c);

        if (b % 2 == 0) {
            return n * n % c;
        }
        else {
            return (n * n % c) * a % c;
        }
    }
}