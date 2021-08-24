import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_최단경로_1753_AdjList {
	static class Node implements Comparable<Node>{
		int end, weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int E = Integer.parseInt(st.nextToken()); //간선 갯수
		
		int start = Integer.parseInt(br.readLine())-1;
		int end = V-1;
		int[] distance = new int[V];
		ArrayList<Node>[] list = new ArrayList[V+1];
		
		for(int i=0;i<V;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(distance[node.end]<node.weight) continue;
			
			for(int c = 0;c<list[node.end].size();++c) {
				Node node2 = list[node.end].get(c);
				int end2 = node2.end;
				int weight2 = node2.weight + node.weight;
				
				if(distance[end2] > weight2) {
					distance[end2] = weight2;
					queue.add(new Node(end2, weight2));
				}
			}
		}
		for(int i=0;i<V;i++)
			if(distance[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
	}

}

