import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_단어뒤집기2_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean check = false;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='<') {
				check = true;
				while(!stack.isEmpty())
					System.out.print(stack.pop());
				System.out.print(str.charAt(i));
			}
			else if(str.charAt(i) =='>') {
				check = false;
				System.out.print(str.charAt(i));
			}
			
			else if(check)
				System.out.print(str.charAt(i));
			else if(!check) {
				if(str.charAt(i) == ' ') {
					while(!stack.isEmpty())
						System.out.print(stack.pop());
					System.out.print(" ");
				}
				else {
					stack.add(str.charAt(i));
				}
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop());
		
	}

}
