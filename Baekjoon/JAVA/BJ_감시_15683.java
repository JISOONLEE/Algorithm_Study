import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_감시_15683 {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<Point> cctvInfo;
	static boolean[] isSelected;
	static int[] numbers;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int spot = 0;
	static int result;
	static int[][][] dir = { 
			{ { 0 }, { 1 }, { 2 }, { 3 } }, // 1번 cctv
			{ { 1, 3 }, { 0, 2 } }, // 2번 cctv
			{ { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } }, // 3번 cctv  
			{ { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } },// 4번 cctv
			{ { 0, 1, 2, 3 } } // 5번 cctv
	};

	static class Point {
		int x, y, info;

		Point(int x, int y, int info) {
			this.x = x;
			this.y = y;
			this.info = info;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvInfo = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					cctvInfo.add(new Point(i, j, map[i][j])); //cctv는 리스트에 넣어주기
			}
		}
		result = Integer.MAX_VALUE;
		dfs(0, map);
		System.out.println(result);
	}

	static void dfs(int cnt, int[][] map) {
		if (cnt == cctvInfo.size()) { // 모든 cctv를 확인했다.
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 0) // 도달하지 못한 땅 카운트
						sum++;
				}
			}
			result = Math.min(sum, result);
			return;
		}

		int[][] copyMap = new int[N][M];
		copy(copyMap, map);
		Point point = cctvInfo.get(cnt);
		
		for(int i=0;i<dir[point.info-1].length;i++) { // cctv 번호를 찾아와 dir에서 몇번의 방향을 계산해야하는지 가져온다. 2번cctv의 경우 { { 1, 3 }, { 0, 2 } } 이므로 2번 for문 반복
			for(int j=0;j<dir[point.info-1][i].length;j++) { // {1,3} 1,3으로 2번, {0,2} 0, 2방향으로 2번
				int num = 0;
				int nx =point.x;
				int ny = point.y;
				while(true) {
					nx += dx[dir[point.info-1][i][j]];
					ny += dy[dir[point.info-1][i][j]];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M ||copyMap[nx][ny]==6) break;
					if(copyMap[nx][ny] != 0) continue;
					copyMap[nx][ny] = -1; // cctv범위에 있다면 처리
				}
			}
			dfs(cnt+1, copyMap); // 현재 지도 보내기
			copy(copyMap, map);
		}
	}
	
	static void copy(int[][] copyMap, int[][] oriMap) {
		for(int i=0;i<N;i++) 
			copyMap[i] = oriMap[i].clone();
	}
	
}
