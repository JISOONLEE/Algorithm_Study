import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_쿼드트리_1992 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		solve(0, 0, N);
	}
	static void solve(int x, int y, int n) {
		int temp = map[x][y];
		boolean check = false;
		
		outer: for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(temp != map[i][j]) {
					check = true;
					break outer;
				}
			}
		}
		if(check) {
			System.out.print("(");
			solve(x, y, n/2);
			solve(x, y+n/2, n/2);
			solve(x+n/2, y, n/2);
			solve(x+n/2, y+n/2, n/2);
			System.out.print(")");
		} else {
			System.out.print(temp);
		}
	}
}
