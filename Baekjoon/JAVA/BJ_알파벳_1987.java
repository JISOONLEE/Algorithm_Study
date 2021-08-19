import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_알파벳_1987 {
	static int R;
	static int C;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] alpha;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		result = 0;
		alpha = new boolean[26];
		dfs(0, 0, 0);
		System.out.println(result);
	}

	private static void dfs(int x, int y, int count) {
		if (alpha[map[x][y] - 'A']) {
			result = Math.max(result, count);
			return;
		}

		alpha[map[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;

			dfs(nx, ny, count + 1);
		}
		alpha[map[x][y] - 'A'] = false;

	}
}
