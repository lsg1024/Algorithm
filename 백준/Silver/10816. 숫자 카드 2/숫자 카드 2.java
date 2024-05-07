import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            if (hashmap.get(num) == null) {
                hashmap.put(num, 1);
            }
            else {
                Integer nnum = hashmap.get(num);
                hashmap.put(num, nnum + 1);
            }
            
        }

        HashMap<Integer, Integer> hashmap2 = new HashMap<>();

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            if (hashmap.get(num) == null) {
                sb.append("0").append(" ");
            }
            else {
                
                sb.append(hashmap.get(num).toString()).append(" ");
            }
        }

        System.out.println(sb);
    }
}