import java.io.*;
import java.util.*;

public class Main {

	public void sol_2579() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		// cal : Buttom-up
		int[][] dp = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[1][0] = stairs[1];
				dp[1][1] = stairs[1];
			}
			else if (i == 2) {
				dp[2][0] = stairs[2];
				dp[2][1] = stairs[1] + stairs[2];
			}
			else {
				int com = dp[i-2][0] > dp[i-2][1] ? dp[i-2][0] : dp[i-2][1];
				dp[i][0] = com + stairs[i];
				dp[i][1] = dp[i-1][0] + stairs[i];
			}
		}
		
		int res = dp[N][0] > dp[N][1] ? dp[N][0] : dp[N][1];
		System.out.println(res);
	}
	
	public void sol_9375() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int res = 1;
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> clothes = new HashMap<>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				if (clothes.containsKey(type)) {
					int count = clothes.get(type);
					clothes.replace(type, count+1);
				} else {
					clothes.put(type, 2);		// 없는 경우도 하나로 세기: 2부터 시작
				}
			}
			for (String type : clothes.keySet()) {
				res *= clothes.get(type);
			}
			sb.append(res-1).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_9461() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			for (int j = 1; j <= N; j++) {
				if (j < 4)		dp[j] = 1;
				else if (j < 6)	dp[j] = 2;
				else {
					dp[j] = dp[j-1] + dp[j-5];
				}
			}
			
			sb.append(dp[N]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public class Graph{
		ArrayList<ArrayList<Integer>> graph;
		
		Graph() {
			graph = new ArrayList<ArrayList<Integer>>();	// root node
		}
		
		public void addVertex(int x) {
			graph.add(new ArrayList<Integer>());
		}
		
		public void addEdge(int x, int y) {
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		public void searchDFS(int V, boolean[] visited) {
			visited[V] = true;
			System.out.print(V + " ");
			ArrayList<Integer> node = graph.get(V);
			Collections.sort(node);
			for(int n : node) {
				if (!visited[n]) {
					searchDFS(n, visited);
				}
			}
		}
	}
	
	public void sol_2606() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		Graph g = new Graph();
		
		for (int i = 0; i <= V; i++) g.addVertex(i);
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.addEdge(x, y);
		}
		
		// BFS
		int count = 0;
		boolean[] visited = new boolean[V+1];
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		visited[1] = true;
		q.add(g.graph.get(1));
		while(!q.isEmpty()) {
			ArrayList<Integer> node = q.poll();
			for (int n : node) {
				if (!visited[n]) {
					count++;
					visited[n] = true;
					q.add(g.graph.get(n));
				}
			}
		}
		
		System.out.println(count);
	}
	
	public void sol_1260() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		Graph g = new Graph();
		
		for (int i = 0; i <= N; i++) g.addVertex(i);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.addEdge(x, y);
		}	
		
		// DFS
		boolean[] visited = new boolean[N+1];
		g.searchDFS(V, visited);
		
		sb.append('\n');
		
		// BFS
		visited = new boolean[N+1];
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		visited[V] = true;
		q.add(g.graph.get(V));
		sb.append(V).append(' ');
		while(!q.isEmpty()) {
			ArrayList<Integer> node = q.poll();
			Collections.sort(node);
			for (int n : node) {
				if (!visited[n]) {
					visited[n] = true;
					q.add(g.graph.get(n));
					sb.append(n).append(' ');
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public void sol_11659() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			sb.append(sums[J] - sums[I-1]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_11726() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (i < 3)	dp[i] = i;
			else {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
		}
		
		System.out.println(dp[N]);
	}
	
	public static void main (String[] args) throws Exception{
		new Main().sol_11726();
	}
}
