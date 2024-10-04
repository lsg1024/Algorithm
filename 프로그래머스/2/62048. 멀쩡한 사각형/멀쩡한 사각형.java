class Solution {
    public long solution(int w, int h) {

        int gcd = GCD(w, h);
        
        
        return ((long) w * (long) h - (long) ((w / gcd) + ((h / gcd) - 1)) * gcd);
    }
    
    static int GCD(int num1, int num2) {

        if (num1 % num2 == 0) {
            return num2;
        }
        
        return GCD(num2, num1 % num2);
    }
}