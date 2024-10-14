import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static String a, b;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

        int a_length = a.length();
        int b_length = b.length();
        int min_count = Integer.MAX_VALUE;

        for (int i = 0; i <= b_length - a_length; i++) {

            int count = 0;
            for (int j = 0; j < a_length; j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    count += 1;
                }
            }

            min_count = Math.min(count, min_count);
            
        }
        System.out.println(min_count);
    }

}