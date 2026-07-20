class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                // A sign is only valid at the very beginning or right after an 'e' / 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (ch == 'e' || ch == 'E') {
                // An exponent is only valid if we haven't seen one yet AND we already saw a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure an integer follows the exponent
            } else if (ch == '.') {
                // A dot is only valid if we haven't seen a dot OR an exponent yet
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character (like letters besides e/E) makes it invalid
                return false;
            }
        }
        
        // The string is valid only if it ends having successfully processed at least one digit
        return seenDigit;
    }
}
