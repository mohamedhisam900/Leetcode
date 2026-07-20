import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // A stack to keep track of expected closing brackets
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If we see an opening bracket, push its matching closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If we see a closing bracket:
            // It must match the top of the stack. If the stack is empty or doesn't match, it's invalid.
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If the stack is empty, all opening brackets were matched correctly
        return stack.isEmpty();
    }
}
