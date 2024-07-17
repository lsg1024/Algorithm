import java.util.*;

class Solution {
    
    HashSet<Integer> result = new HashSet<>();
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        // 약수 구하기
        ArrayList<Integer> arrA = div(arrayA[0]);
        ArrayList<Integer> arrB = div(arrayB[0]);
        
        // 최대 값 구하기
        maximum(arrA, arrayA, arrayB);
        maximum(arrB, arrayB, arrayA);
        
        if (result.isEmpty()) return 0;
        return Collections.max(result);
    }
    
    public void maximum(ArrayList<Integer> list, int[] mainArr, int[] subArr) {
        
        for (Integer arr : list) {
            boolean v = false;
            for (int i = 0; i < mainArr.length; i++) {
                // 배일 값 만큼 반복
                if (mainArr[i] % arr == 0 && subArr[i] % arr != 0) {
                    continue;
                }
                v = true;
                break;
            }
            if (!v) {
                result.add(arr);
            }
        }
        
    }
    
    public ArrayList<Integer> div(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i != 1) {
                    // i가 1이 아닌 나눠 떨어지는 경우
                    arr.add(i);
                }
                // 나눠 떨어지는 몫도 포함
                arr.add(num / i);
            }
        }
        
        return arr;
    }
    
}