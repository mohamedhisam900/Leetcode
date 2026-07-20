class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Base case: Any 2 points always form a straight line
        if (coordinates.length <= 2) {
            return true;
        }

        // Calculate differences between the first two points
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        // Verify that all other points maintain the exact same slope ratio
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];

            // dy * (xi - x0) must equal dx * (yi - y0)
            if (dy * (xi - x0) != dx * (yi - y0)) {
                return false;
            }
        }

        return true;
    }
}
