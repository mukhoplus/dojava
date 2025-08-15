import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> {
            return Integer.parseInt(b + a) - Integer.parseInt(a + b);
        });
        
        // "0"이 여러 개 있을 경우, "00..." 꼴 예외 처리
        if (strNumbers[0].equals("0")) return "0";

        // String += num은 매번 새로운 객체를 생성하므로 비효율적
        StringBuilder sb = new StringBuilder();
        for (String num: strNumbers)
            sb.append(num);
        return sb.toString();
    }
}