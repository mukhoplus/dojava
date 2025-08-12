import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; ++i) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        for (String[] p: photo) {
            int score = 0;
            for (String n: p) {
                if (scoreMap.containsKey(n)) score += scoreMap.get(n);
            }
            answer.add(score);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}