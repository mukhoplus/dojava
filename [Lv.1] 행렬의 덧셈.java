class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLen = arr1.length;
        int colLen = arr1[0].length;
        int[][] answer = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; ++i)
            for (int j = 0; j < colLen; ++j)
                answer[i][j] = arr1[i][j] + arr2[i][j];
        return answer;
    }
}