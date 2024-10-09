import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
           
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] prices = new int[N];
            
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            
            long result = findMaxPrice(prices, N);

            sb.append("#").append(t).append(" ").append(result).append("\n");
            
     	}
        
        System.out.println(sb);
 
	}
    
    static long findMaxPrice(int[] prices, int N) {
        
        long totalPrice = 0;
        long maxPrice = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            
            if (prices[i] > maxPrice) {
             	maxPrice = prices[i];
            }
            
            totalPrice += maxPrice - prices[i];
            
        }
        
        return totalPrice;
        
    }
}