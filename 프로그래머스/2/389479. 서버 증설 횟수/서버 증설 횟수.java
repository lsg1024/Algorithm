class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for (int i = 0; i < players.length; i++) {
            int player = players[i];
            int server = servers[i];
            int needServer = player / m;
            
            if (needServer > server) {
                
                answer += needServer - server;
                
                int index = Math.min(i + k, 24);
                
                for (int j = i; j < index; j++) {
                    servers[j] += needServer - server;
                }
            }
        }
        
        return answer;
    }
}