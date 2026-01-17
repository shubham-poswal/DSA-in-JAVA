// 3047. Find the Largest Area of Square Inside Two Rectangles


class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {

        int overlapWidth = Math.min(topRight[0][0], topRight[1][0]) 
                         - Math.max(bottomLeft[0][0], bottomLeft[1][0]);

        int overlapHeight = Math.min(topRight[0][1], topRight[1][1]) 
                          - Math.max(bottomLeft[0][1], bottomLeft[1][1]);

        if (overlapWidth <= 0 || overlapHeight <= 0) {
            return 0;
        }

        long side = Math.min(overlapWidth, overlapHeight);
        return side * side;
    }
}
