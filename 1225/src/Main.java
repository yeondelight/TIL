import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	class Node {
		int v;
		int w;
		Node (int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	
	public void sol_18352() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			g.get(A).add(new Node(B, 1));
		}
		
		// Dijkstra
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.w, n2.w));
		pq.offer(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if (dist[curr.v] < curr.w) {
				continue;
			}
			for (int i = 0; i < g.get(curr.v).size(); i++) {
				Node next = g.get(curr.v).get(i);
				if (dist[next.v] > curr.w + next.w) {
					dist[next.v] = curr.w + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append('\n');
				flag = true;
			}
		}
		
		if (flag)	System.out.println(sb);
		else		System.out.println(-1);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_18352();
	}
}
