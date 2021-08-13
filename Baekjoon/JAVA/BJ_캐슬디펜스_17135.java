import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_캐슬디펜스_17135 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[] archer; //궁수의 위치
	static LinkedList<Point> enemy; 
	static int result;

	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		archer = new int[3]; // 궁수는 3명으로 고정
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MIN_VALUE;
		combination(0, 0);
		System.out.println(result);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			enemy = new LinkedList<>(); // 계속 갱신해줘야함
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1) {
						enemy.add(new Point(i, j));
					}
				}
			}
			attack();
			return;
			
		}
		for(int i=start;i<M;i++) {
			archer[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void attack() {
		int sum = 0;
		while(!enemy.isEmpty()) { // 적이 다 사라질때까지 반복
			ArrayList<Point> remove_enemy = new ArrayList<>(); 
			// 제거된 적을 담기 위한 arraylist 생성, 바로 enemy에서 제거하면 인덱스가 변경되서 안됨 
			for(int i=0;i<3;i++) { //궁수
				int[] dis = new int[enemy.size()]; // 적과 궁수와의 거리를 담을 배열 생성, 거리가 같은 경우를 위해 생성한다.
				int minDis = Integer.MAX_VALUE;
				int count = 0;
				for(int j=0;j<enemy.size();j++) { //적의 수
					dis[j] = Math.abs(N - enemy.get(j).x) + Math.abs(archer[i]-enemy.get(j).y);
					minDis = Math.min(minDis, dis[j]); // 어떤 값이 최소값인지 확인
				}
				
				for(int j=0;j<dis.length;j++) {
					if(dis[j] == minDis && dis[j] <=D) // 공격할 수 있는 적의 수 세기
						count++;
				}
				
				if(count == 0) continue; // 공격할 적이 없다면
				else if(count == 1) { // 공격할 적이 한명이라면
					
					for(int j=0;j<dis.length;j++) {
						if(dis[j]<=D && dis[j] == minDis) { // 공격할 수 있는 범위의 적을 배열에 넣는다.
							remove_enemy.add(enemy.get(j));
						}
					}
				}
				else if(count > 1) { // 공격할 적이 한명보다 많다면
					int minY = Integer.MAX_VALUE;
					int minX = Integer.MAX_VALUE;
					for(int j=0;j<dis.length;j++) {
						if(dis[j] == minDis && dis[j]<=D) { // 공격할 범위에서
							if(minY > enemy.get(j).y) { // y가 작은 값을 찾아서 x와 y에 저장
								minY = enemy.get(j).y;
								minX = enemy.get(j).x;
							}
						}
					}
					for(int j=0;j<dis.length;j++) {
						if(minY == enemy.get(j).y && minX == enemy.get(j).x) {
							remove_enemy.add(enemy.get(j)); // 값을 제거할 적 목록에 삽입
						}
					}
					
				}

			}
			for(int i=0;i<remove_enemy.size();i++) { // 제거할 목록을 담은 배열값을 비교해 enemy 리스트 제거
				for(int j=0;j<enemy.size();j++) {
					if(remove_enemy.get(i).x == enemy.get(j).x && remove_enemy.get(i).y == enemy.get(j).y) {
						enemy.remove(j);
						sum++;
						break;
					}
				}
			}

			for(int i=enemy.size()-1;i>=0;i--) { //한줄씩 밑으로
				if(enemy.get(i).x+1 < N)
					enemy.get(i).x = enemy.get(i).x+1;
				else enemy.remove(i);
			}
			
		}
		result = Math.max(result, sum);
	}
}
