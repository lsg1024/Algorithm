import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static ArrayList<String> pocketmons;
    static HashMap<String, Integer> pocketmonNameList;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pocketmons = new ArrayList<>();
        pocketmonNameList = new HashMap();

        for (int i = 0; i < n; i++) {
            String pocketmon = bf.readLine();
            pocketmons.add(pocketmon);
            pocketmonNameList.put(pocketmon, i + 1);
        }

        for (int i = 0; i < m; i++) {
            String pocketmon = bf.readLine();
            if (pocketmon.chars().allMatch(Character::isDigit)) {
                sb.append(pocketmons.get(Integer.parseInt(pocketmon) - 1)).append("\n");
            } 
            else {
                sb.append(pocketmonNameList.get(pocketmon)).append("\n");
            }
        }

        System.out.print(sb);
    }
}