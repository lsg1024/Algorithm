import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> hashset = new HashSet<>();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            hashset.add(br.readLine());
        }

        ArrayList<String> arr = new ArrayList<>();
        count = 0;
        for (int j = 0; j < m; j++) {
            String input = br.readLine();

            if (hashset.contains(input)) {
                count++;
                arr.add(input);
            }
        }

        Collections.sort(arr);
        
        System.out.println(count);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        
    }
}