import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_낚시왕_17143 {
	static int R, C;
	static ArrayList<Shark>[][] map;
	static ArrayList<Shark> list;
	static int result;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};

	private static class Shark implements Comparable<Shark> {
		int r, c, s, d, z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.r, o.r); // 낚시왕이 잡을 상어 정렬
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new ArrayList[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = new ArrayList<Shark>();
			}
		}

		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Shark(r, c, s, d, z));
		}
		result = 0;
		for (int i = 0; i < C; i++) {
			Collections.sort(list);
			fishing(i);
			move();
			change();//같은 칸에 있는 상어 제거
		}
		
		System.out.println(result);
	}
	
	private static void change() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int size = map[i][j].size();
				if(size<2) { // 2보다 크지 않으면 넘어가
					map[i][j].clear(); // list 안에 상어 정보 있으니까 map 지워도 됨(다음을 위해 지운다.)
					continue;
				}
				
				int max = 0;
				Shark big = null;
				for(int k=0;k<map[i][j].size();k++) {
					if(max<map[i][j].get(k).z) {
						max = map[i][j].get(k).z; // 가장 큰 상어 찾기
					}
				}
				for(int k=0;k<map[i][j].size();k++) {
					if(max!=map[i][j].get(k).z) {
						list.remove(map[i][j].get(k)); // 가장 큰 상어를 제외한 다른 상어 지우기, 같은 크기 없음
					}
				}
				map[i][j].clear(); // 다 처리하면 map정보 지우기
			}
		}
	}
	
	private static void move() {
		for(Shark s: list) {
			int nx = s.r;
			int ny = s.c;
			int move = s.s;
			if(s.d == 1 || s.d == 2) { // 상하
				move %= (R-1)*2; //이동횟수
				while(move>0) {
					if(nx == 0) { 
						s.d = 2;
					}
					if(nx == R-1) {
						s.d = 1;
					}
					nx += dx[s.d];
					move--;
				}
			}
			else if(s.d == 3 || s.d == 4) { // 좌우
				move %= (C-1)*2;
				while(move>0) {
					if(ny==0) {
						s.d = 3;
					}
					if(ny == C-1) {
						s.d = 4;
					}
					ny += dy[s.d];
					move--;
				}
			}
			s.r = nx;
			s.c = ny;
			map[s.r][s.c].add(s); 			
		}
	}
	
	private static void fishing(int loc) { // 상어 낚시
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).c == loc) {
				result += list.get(i).z;
				list.remove(i);
				return;
			}
		}
	}
}
