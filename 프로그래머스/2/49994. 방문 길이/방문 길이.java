import java.util.*;

class Solution {
    
    static HashSet<String> moves = new HashSet<>();
    
    public int solution(String dirs) {
        int x = 5, y = 5;
        
        for (char dir : dirs.toCharArray()) {
            if (dir == 'U') {
                if (0 <= x + 1 && x + 1 < 11 && 0 <= y && y < 11) {
                    makeKey(dir, x, y);
                    x += 1;
                }
            } else if (dir == 'L') {
                if (0 <= x && x < 11 && 0 <= y - 1 && y - 1 < 11) {
                    makeKey(dir, x, y);
                    y -= 1;
                }
            } else if (dir == 'R') {
                if (0 <= x && x < 11 && 0 <= y + 1 && y + 1 < 11) {
                    makeKey(dir, x, y);
                    y += 1;
                }
            } else {
                if (0 <= x - 1 && x - 1 < 11 && 0 <= y && y < 11) {
                    makeKey(dir, x, y);
                    x -= 1;
                }
            }
            
        }
        
        return moves.size() / 2;
    }
    
    static void makeKey(char dir, int x, int y) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if (dir == 'U') {
            sb1.append(x).append(y).append(x + 1).append(y);
            sb2.append(x + 1).append(y).append(x).append(y);
        } else if (dir == 'L') {
            sb1.append(x).append(y).append(x).append(y - 1);
            sb2.append(x).append(y - 1).append(x).append(y);
        } else if (dir == 'R') {
            sb1.append(x).append(y).append(x).append(y + 1);
            sb2.append(x).append(y + 1).append(x).append(y);
        } else {
            sb1.append(x).append(y).append(x - 1).append(y);
            sb2.append(x - 1).append(y).append(x).append(y);
        }
        
        moves.add(sb1.toString());
        moves.add(sb2.toString());
    }
    
}