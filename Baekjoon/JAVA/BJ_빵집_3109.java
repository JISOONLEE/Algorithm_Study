import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_빵집_3109 {
	static int R;
	static int C;
	static char[][] map;
	static int result;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 백트래킹 응용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String ch = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch.charAt(j);
			}
		}
		result = 0;
		for (int i = 0; i < R; i++) {
			setBackTrack(i, 0);
		}
		System.out.println(result);
	}

	private static boolean setBackTrack(int x, int y) {
		// TODO Auto-generated method stub
//		System.out.println(x+", "+y);
		map[x][0] = '-';
		if (y >= C-1) {
			result++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			
			if (map[nx][ny] == 'x' || map[nx][ny] == '-')
				continue;
			
			map[nx][ny] = '-';
			if(setBackTrack(nx, ny)) return true;
		}
		return false;
	}
}
