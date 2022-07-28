import java.io.*;
import java.util.*;

public class Main {
	
	class Edge {
		int s;
		int e;
		int t;
		Edge(int start, int end, int time){
			this.s = start;
			this.e = end;
			this.t = time;
		}
	}
	
	public void sol_1865() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			// Edges
			Vector<Edge> edges = new Vector<>();
			
			// get M
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}
			
			// get W
			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken()) * -1;
				edges.add(new Edge(S, E, T));
			}
			
			// Bellman-Ford
			int[] dist = new int[N+1];	
			Arrays.fill(dist, 0);			// 1. startNode = all, 2. set dist[]
			boolean isValid = false;
			
			for (int j = 0; j < N; j++) {
				for (Edge e : edges) {		// 3. check all edges
					dist[e.e] = Math.min(dist[e.e], dist[e.s] + e.t);
				}
			}
			
			for (Edge e : edges) {			// 4. check minus cycle
				if (dist[e.e] > dist[e.s] + e.t) {
					isValid = true;
					dist[e.e] = dist[e.s] + e.t;
				}
			}
			
			if (isValid)	sb.append("YES").append('\n');
			else			sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1865();
	}
}
