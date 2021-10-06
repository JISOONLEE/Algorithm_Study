import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_게리맨더링_17471 {
	static int[] population;
	static int N;
	static ArrayList[] map;
	static boolean[] visited;
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		map = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());

			for (int m = 0; m < M; m++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		solve(1);
		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}

	private static void solve(int idx) { // 부분집합
		if (idx == N + 1) {
			A = new ArrayList<>();
			B = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			if (A.size() == 0 || B.size() == 0)
				return;
			if (!isConnect(A, B) || !isConnect(B, A))
				return;

			int sumA = 0;
			int sumB = 0;
			for (int a : A) {
				sumA += population[a];
			}
			for (int b : B) {
				sumB += population[b];
			}
			result = Math.min(result, Math.abs(sumA - sumB));
			return;
		}
		visited[idx] = true;
		solve(idx + 1);
		visited[idx] = false;
		solve(idx + 1);
	}

	private static boolean isConnect(ArrayList<Integer> list, ArrayList<Integer> list2) {
		boolean[] check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(list.get(0));
		check[list.get(0)] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < map[current].size(); i++) {
				int next = (int) map[current].get(i);
				if (!check[next] && list.contains(next) && !list2.contains(next)) {
					queue.add(next);
					check[next] = true;
				}
			}
		}
		for (int i : list) {
			if (!check[i])
				return false;
		}
		return true;
	}

}
