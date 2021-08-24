import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_OX퀴즈_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++) {
			String str = br.readLine();
			int count = 0;
			int sum = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) =='O') {
					count++;
				} else {
					count = 0;
				}
				sum+=count;
			}
			System.out.println(sum);
		}
	}

}
