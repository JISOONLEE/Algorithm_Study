import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_에디터_1406 {
	static int idx;
	static char ch;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String info = st.nextToken();
			
			if (info.equals("L")) {
				if (!stack.isEmpty())
					stack2.push(stack.pop());
			} else if (info.equals("D")) {
				if(!stack2.isEmpty())
					stack.push(stack2.pop());
			} else if (info.equals("B")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (info.equals("P")) {
				ch = st.nextToken().charAt(0);
				stack.push(ch);
			}
		}

		while(!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		System.out.println(sb.toString());
	}

}
