import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_RGB거리_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(str[0]);
			map[i][1] = Integer.parseInt(str[1]);
			map[i][2] = Integer.parseInt(str[2]);
		}
		
		int[][] D = new int[N][3];
		D[0] = map[0].clone();
		for(int i=1;i<N;i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + map[i][0];
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + map[i][1];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + map[i][2];
		}
		
		int answer = 0;
		answer = Math.min(D[N-1][0], D[N-1][1]);
		answer = Math.min(answer, D[N-1][2]);
		
		System.out.println(answer);
	}

}
