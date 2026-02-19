import java.util.*;

class Solution {
    
    static int time;
    static int[] player;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        time = attacks[attacks.length - 1][0];
        player = new int[time + 1];
        
        for (int i = 1; i <= time; i++) {
            player[i] = bandage[1];
        }
        
        
        for (int i = 0; i < attacks.length; i++) {
            int attack_time = attacks[i][0];
            int attack_damage = attacks[i][1];
            
            player[attack_time] = -1 * attack_damage;
        }
        
        int max_health = health;
        int need_time = bandage[0];
        int heel = bandage[1];
        int bonus = bandage[2];
        
        int count = 0;
        for (int i = 1; i <= time; i++) {

            if (player[i] == heel) {
                health += heel;
                
                count+=1;
                
                if (count == need_time) {
                    health += bonus;
                    count = 0;
                }
                
                if (health > max_health) {
                    health = max_health;
                }
                
            } else {
                count = 0;
                health += player[i];
                
                if (health <= 0) {
                    return -1;
                }
            }
        } 
        
        return health;
    }
}