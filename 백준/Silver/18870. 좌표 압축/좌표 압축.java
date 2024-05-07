import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashmap = new HashMap();
        int[] x = new int[n];
        int[] sortList = new int[n];
        int count = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            sortList[i] = x[i];
        }

        Arrays.sort(sortList);

        for (int sortnum : sortList) {
            if (!hashmap.containsKey(sortnum)) {
                hashmap.put(sortnum, count);
                count++;
            }
        }

        
        for (int key : x) {
            sb.append(hashmap.get(key)).append(" ");
        }

        System.out.println(sb);
    }
}
