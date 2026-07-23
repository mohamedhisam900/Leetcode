class Solution {
    public boolean squareIsWhite(String coordinates) {
        // If the sum of ASCII values of column and row is odd, it's white.
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}
