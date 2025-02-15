import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int K, x, y;
    static HashMap<Integer, int[]> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        x = 0;
        y = 0;

        for (int i = 0; i < 7; i++) {
            map.put(i, new int[2]);
        }
        
        StringTokenizer st;
        for (int i = 1; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (direction == 1) x += number;    
            else if (direction == 2) x -= number;
            else if (direction == 3) y -= number; 
            else y += number; 

            map.get(i)[0] = x;
            map.get(i)[1] = y;
        }

        int total = 0;
        
        for (int i = 1; i < 6; i++) {
            int x1 = map.get(i)[0];
            int y1 = map.get(i)[1];
            int x2 = map.get(i + 1)[0];
            int y2 = map.get(i + 1)[1];

            total += (x1 * y2) - (x2 * y1);
        }

        total += (map.get(6)[0] * map.get(1)[1]) - (map.get(1)[0] * map.get(6)[1]);
        
        total = K * (Math.abs(total) / 2);

        System.out.println(total);
        
    }

}