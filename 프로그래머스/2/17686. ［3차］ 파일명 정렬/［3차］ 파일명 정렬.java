import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = splitFileName(o1);
            String[] file2 = splitFileName(o2);
            
            int headCompare = file1[0].compareToIgnoreCase(file2[0]);
            if (headCompare != 0) {
                return headCompare;
            }
            
            int num1 = Integer.parseInt(file1[1]);
            int num2 = Integer.parseInt(file2[1]);
            return Integer.compare(num1, num2);
        });
        
        return files;
    }
    
    static String[] splitFileName(String file) {
        Matcher matcher = Pattern.compile("([a-zA-Z .-]+)([0-9]+)(.*)").matcher(file);
        
        if (matcher.matches()) {
            String head = matcher.group(1);
            String number = matcher.group(2);
            return new String[] { head, number };
        }
        return new String[] { "", "" };
    }
}