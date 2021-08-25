import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_컵홀더_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String str = "*"+br.readLine();
		
		str = str.replace("S", "*");
		str = str.replace("LL", "*");
//		System.out.println(str);
		if(str.length()<N) {
			System.out.println(str.length());
		} else {
			System.out.println(N);
		}
	}

}
