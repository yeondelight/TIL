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
	
	Map<Long, Long> fibo;
	
	public long conquer(long N) {
		if (N == 0)	return 0;
		if (N == 1)	return 1;
		if (fibo.containsKey(N))	return fibo.get(N) % 1000000007;

		long mod = N % 2;
		long N0, N1;
		N0 = conquer(N/2);
		if (!fibo.containsKey(N/2)) {
			fibo.put(N/2, N0);
		}
		if (mod == 0) {
			N1 = conquer(N/2-1) % 1000000007;
			if (!fibo.containsKey(N/2-1)) {
				fibo.put(N/2-1, N1);
			}
			return N0 * (N0 + 2*N1 % 1000000007) % 1000000007;
		} else {
			N1 = conquer(N/2+1) % 1000000007;
			if (!fibo.containsKey(N/2-1)) {
				fibo.put(N/2+1, N1);
			}
			return (N0 * N0 % 1000000007 + N1 * N1 % 1000000007) % 1000000007;
		}
	}
	
	public void sol_11444() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		fibo = new HashMap<>();
		fibo.put((long)0, (long)0);
		fibo.put((long)1, (long)1);
		
		System.out.println(conquer(N));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11444();
	}
}