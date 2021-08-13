import java.util.LinkedList;
import java.util.Scanner;

public class BJ_치킨배달_15086 {
	static int N;
	static int M;
	static int[][] arr;
	static LinkedList<Point> chicken;
	static LinkedList<Point> home;
	static int[] check;
	static int totalDistance;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][N];
		chicken = new LinkedList<>();
		home = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) {
					chicken.add(new Point(i, j));
				} else if(arr[i][j]==1) {
					home.add(new Point(i, j));
				}
			}
		}
		totalDistance = Integer.MAX_VALUE;
		check = new int[chicken.size()];
		combination(0, 0);
		
		System.out.println(totalDistance);
	}

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			int sumDistance = 0;
			for(int i=0;i<home.size();i++) { // 모든 집에서
				int minChicken = Integer.MAX_VALUE;
				Point p = home.get(i);
				for(int j=0;j<M;j++) { // 최소 치킨 거리를 찾기 위해 반복문 돌리기
					
					int distance = Math.abs(p.x-chicken.get(check[j]).x) + Math.abs(p.y-chicken.get(check[j]).y);
					minChicken = Math.min(minChicken, distance);
				}
				sumDistance += minChicken;
			}
			totalDistance = Math.min(totalDistance, sumDistance);
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			check[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
