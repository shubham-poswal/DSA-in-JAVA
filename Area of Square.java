// 2943. Maximize Area of Square Hole in Grid


import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);
        
        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int maxConsecutive(int[] arr) {
        Arrays.sort(arr);
        int max = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max + 1; // +1 because bars removal creates gaps
    }
}
