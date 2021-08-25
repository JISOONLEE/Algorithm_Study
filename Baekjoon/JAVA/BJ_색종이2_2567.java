import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로직 생각 안나서 인터넷 참조함..
public class BJ_색종이2_2567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[101][101];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1) {
					if (i-1>=0 && arr[i - 1][j] == 0) cnt++;
					if(i+1<101 && arr[i+1][j] == 0) cnt++;
					if(j-1>=0 && arr[i][j-1]==0) cnt++;
					if(j+1<101 && arr[i][j+1] == 0) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
