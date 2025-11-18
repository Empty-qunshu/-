package ch03_stack;
import java.util.Stack;

public class DelimiterMatch {
    public static boolean isMatch(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c + "");
            else if (c == '/' && i + 1 < exp.length() && exp.charAt(i + 1) == '*') {
                stack.push("/*"); i++;
            } else if (c == '*' && i + 1 < exp.length() && exp.charAt(i + 1) == '/') {
                if (stack.isEmpty() || !stack.peek().equals("/*")) return false;
                stack.pop(); i++;
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                String top = stack.pop();
                if ((c == ')' && !top.equals("(")) ||
                        (c == ']' && !top.equals("[")) ||
                        (c == '}' && !top.equals("{"))) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "[()]/*[]*/";
        String s2 = "[(])";
        System.out.println(s1 + " → " + isMatch(s1));
        System.out.println(s2 + " → " + isMatch(s2));
    }
}
