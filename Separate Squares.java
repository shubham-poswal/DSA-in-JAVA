// Separate Squares I

class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // find search range
        for (int[] sq : squares) {
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + sq[2]);
        }

        // binary search
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double below = 0, above = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double area = l * l;

                if (mid <= y) {
                    above += area;
                } else if (mid >= y + l) {
                    below += area;
                } else {
                    double lowerPart = (mid - y) * l;
                    double upperPart = area - lowerPart;
                    below += lowerPart;
                    above += upperPart;
                }
            }

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
