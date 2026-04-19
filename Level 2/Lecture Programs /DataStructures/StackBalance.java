package DataStructures;

import java.util.Stack;

class StackBalance {

    public static void main(String[] args) {
        //System.out.println(isBalanced("())"));
        System.out.println(isBalanced("(()"));
    }


    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        // look at each character in s
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            // if c is a left thing: { ( or [, push it on to a stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            // if c is a right thing: } ) or ], pop the top of the stack
            } else if (c == ')' || c == ']' || c == '}') {
                char top = stack.pop();

                // if the thing we popped "goes with" the current character, 
                // keep going; otherwise return false
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return true;
    }
}
