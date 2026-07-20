class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If we reached the end of the string after skipping spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign
        int sign = 1;
        char firstChar = s.charAt(i);
        if (firstChar == '+') {
            i++;
        } else if (firstChar == '-') {
            sign = -1;
            i++;
        }

        // 3. Convert digits and handle potential overflow
        int result = 0;
        int limit = Integer.MAX_VALUE / 10;

        while (i < n) {
            char ch = s.charAt(i);
            // Stop reading when a non-digit character is encountered
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // 4. Overflow check
            // If result * 10 will exceed Integer.MAX_VALUE, or 
            // if result * 10 == Integer.MAX_VALUE but the next digit is greater than 7 (or 8 for negative)
            if (result > limit || (result == limit && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
