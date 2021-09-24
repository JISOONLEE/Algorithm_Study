import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static Point[] airCleaner;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] temp;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
//		dust = new LinkedList<Point>();
		airCleaner = new Point[2];
		int idx = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == -1)
					airCleaner[idx++] = new Point(r, c);
			}
		}
		for(int i=0;i<T;i++) {
			setFineDust();
			setAirCleaner();
		}
		int result = 0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]>0) {
					result+=map[r][c];
				}
			}
		}
		System.out.println(result);
	}
	
	private static void setFineDust() {
		temp = new int[R][C];
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				temp[r][c] += map[r][c];
				
				int spreadValue = map[r][c]/5;
				for(int i=0;i<4;i++) {
					int nr = r+dx[i];
					int nc = c+dy[i];
					
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(map[nr][nc]==-1) continue;
					
					temp[r][c] -= spreadValue;
					temp[nr][nc] += spreadValue;
				}
			}
		}
		for(int r = 0;r<R;r++) {
			map[r] = temp[r].clone();
		}
	}
	
	private static void setAirCleaner() {
		int x1 = airCleaner[0].x;
		int y1 = airCleaner[0].y+1; // 공기청정기는 제자리에
		int x2 = airCleaner[1].x;
		int y2 = airCleaner[1].y+1; // 공기청정기는 제자리에
		
		temp[x1][y1] = 0;
		temp[x2][y2] = 0;
		while(y1<C-1 && y2<C-1) { // 좌->우
			temp[x1][y1+1] = map[x1][y1];
			temp[x2][y2+1] = map[x2][y2];
			y1++;
			y2++;
		}
		
		while(x1>0) { // 하->상
			temp[x1-1][y1] = map[x1][y1];
			x1--;
		}
		while(x2<R-1) { // 상->하
			temp[x2+1][y2] = map[x2][y2];
			x2++;
		}
		
		while(y1>0 && y2>0) {
			temp[x1][y1-1] = map[x1][y1];
			temp[x2][y2-1] = map[x2][y2];
			y1--;
			y2--;
		}
		
		while(x1<airCleaner[0].x-1) {
			temp[x1+1][y1] = map[x1][y1];
			x1++;
		}
		while(x2>airCleaner[1].x+1) {
			temp[x2-1][y2] = map[x2][y2];
			x2--;
		}
		for(int r = 0;r<R;r++) {
			map[r] = temp[r].clone();
		}
//		System.out.println(Arrays.deepToString(map));
	}
}
