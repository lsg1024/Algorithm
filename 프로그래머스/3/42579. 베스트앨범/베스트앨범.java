import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        HashMap<String, Integer> types = new HashMap<>();
        HashMap<String, ArrayList<int[]>> playTimes = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            types.put(genres[i], types.getOrDefault(genres[i], 0) + plays[i]);
            
            if (playTimes.get(genres[i]) == null) {
                playTimes.put(genres[i], new ArrayList<>());
                playTimes.get(genres[i]).add(new int[] {i, plays[i]});
            } else {
                playTimes.get(genres[i]).add(new int[] {i, plays[i]});
            }
        }
        
        for (String key : playTimes.keySet()) {
            playTimes.get(key).sort((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });
        }
        
        List<String> genreOrder = new ArrayList<>(types.keySet());
        genreOrder.sort((o1, o2) -> types.get(o2) - types.get(o1));
        
        int index = 0;
        ArrayList<Integer> tracks = new ArrayList<>();
        for (String genre : genreOrder) {
            
            ArrayList<int[]> play = playTimes.get(genre);
            
            int count = 0;
            for (int i = 0; i < play.size(); i++) {
                if (count >= 2) {
                    break;
                } else {
                    tracks.add(play.get(i)[0]);
                    count++;
                }
            }

        }
        
        answer = new int[tracks.size()];
        
        for (int i = 0; i < tracks.size(); i++) {
            answer[i] = tracks.get(i);
        }
        
        return answer;
    }
}