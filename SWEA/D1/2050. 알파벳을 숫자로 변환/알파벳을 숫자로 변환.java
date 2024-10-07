import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String s = br.readLine();
            
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 64;
                System.out.print(num + " ");

            }
        
    }
}
    