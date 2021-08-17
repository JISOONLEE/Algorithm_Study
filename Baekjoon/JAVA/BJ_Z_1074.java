import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1074 {
	static int R;
	static int C;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Z(0, 0, (int)Math.pow(2, N));
		System.out.println(result);
	}
	static void Z(int x, int y, int size) {
		if(x == R && y == C)
			return;
		
		if(R<x+size/2 && C <y+size/2) {
			Z(x, y, size/2);
		} else if(R<x+size/2 && C>=y+size/2) {
			result += Math.pow(size/2, 2) * 1;
			Z(x, y+size/2, size/2);
		} else if(R>=x+size/2 && C<y+size/2) {
			result += Math.pow(size/2, 2) * 2;
			Z(x+size/2, y, size/2);
		} else if(R>=x+size/2 && C>=y+size/2) {
			result += Math.pow(size/2, 2) * 3;
			Z(x+size/2, y+size/2, size/2);
		}
	}
}
