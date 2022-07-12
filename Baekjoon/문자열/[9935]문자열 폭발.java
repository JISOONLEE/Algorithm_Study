import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean contains = true;
                for (int j=0;j<bomb.length();j++) {
                    if (bomb.charAt(j) != stack.get(stack.size()-bomb.length()+j)) {
                        contains = false;
                        break;
                    }
                }

                if (contains) {
                    for (int j=0;j<bomb.length();j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
