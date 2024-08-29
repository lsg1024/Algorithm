import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        HashMap<String, Integer> genresPlayCount = new HashMap<>();
        HashMap<String, List<int[]>> genresSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playtime = plays[i];
            
            genresPlayCount.put(genre, genresPlayCount.getOrDefault(genre, 0) + playtime);
            
            genresSongs.putIfAbsent(genre, new ArrayList<>());
            genresSongs.get(genre).add(new int[] {i, playtime});    
        }
        
        // 장르별 총 재생 횟수를 기준 정렬 (내림 차순)
        ArrayList<String> sortedGenres = new ArrayList<>(genresPlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genresPlayCount.get(g2).compareTo(genresPlayCount.get(g1)));
        ArrayList<Integer> best = new ArrayList<>();
        
        // 장르별 최고 엘범 선정 (
        // 장르 당 2개 이하인 경우 고려
        // 장르 당 같은 값인 경우 고려
        for (String genre : sortedGenres) {
            List<int[]> songs = genresSongs.get(genre);
            
            songs.sort((s1, s2) -> s2[1] == s1[1] ? s1[0] - s2[0] : s2[1] - s1[1]);
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                best.add(songs.get(i)[0]);
            }
            
        }
        
        answer = best.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}