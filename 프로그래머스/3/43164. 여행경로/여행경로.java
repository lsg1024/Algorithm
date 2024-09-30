import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<String> airport = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        // start, path, cnt, tickets
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(airport);
        
        String[] first_line = airport.get(0).split(" ");

        String[] air_line = first_line[0].split(",");
        
        return first_line[0].split(",");
    }
    
    static void dfs(String start, String path, int cnt, String[][] tickets) {
        
        if (cnt == tickets.length) {
            airport.add(path);
            return;
        }
        

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], path + "," + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }

        }
        
    }
    
}