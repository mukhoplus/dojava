import java.util.*;

class Solution {
    public List<Character> getNewAlphabet(String skip) {
        Map<Character, Integer> skipMap = new HashMap<>();
        for (Character c: skip.toCharArray())
            skipMap.put(c, 1);
        
        List<Character> newAlphabet = new ArrayList<>();
        
        for (int i = 0; i < 26; ++i) {
            char c = (char) (97 + i);
            
            if (skipMap.containsKey(c)) continue;
            newAlphabet.add(c);
        }    
        
        return newAlphabet;
    }
    
    public String solution(String s, String skip, int index) {  
        List<Character> newAlphabet = getNewAlphabet(skip);
        int len = newAlphabet.size();
        
        String answer = "";
        
        for (char c: s.toCharArray()) {
            int idx = (newAlphabet.indexOf(c) + index) % len;
            answer += newAlphabet.get(idx);
        }

        return answer;
    }
}