import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeSet<String> tree = new TreeSet<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            
            if (st.nextToken().equals("enter")) {
                tree.add(name);
            } else {
                tree.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : tree) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}