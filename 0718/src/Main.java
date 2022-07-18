import java.io.*;
import java.util.*;

public class Main {
	
	class Point {
		int x;
		int y;
		int count;
		boolean destoryed;
		Point(int x, int y, int c, boolean d){
			this.x = x;
			this.y = y;
			this.count = c;
			this.destoryed = d;
		}
	}
	
	public void sol_2206() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '0' ? true : false;
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int res = -1;
		boolean[][][] visit = new boolean[N][M][2];
		Queue<Point> q = new LinkedList<>();
		visit[0][0][0] = true;
		q.add(new Point(0, 0, 1, false));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N-1 && p.y == M-1) {
				System.out.println(p.count);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny]) {	// 원래 갈 수 있는 길
						if (p.destoryed && !visit[nx][ny][1]) {
							visit[nx][ny][1] = true;
							q.add(new Point(nx, ny, p.count + 1, true));
						} else if (!p.destoryed  && !visit[nx][ny][0]){
							visit[nx][ny][0] = true;
							q.add(new Point(nx, ny, p.count + 1, false));
						}
					} else {			// 원래 벽이었던 길
						if (!p.destoryed) {
							visit[nx][ny][1] = true;
							q.add(new Point(nx, ny, p.count + 1, true));
						}
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	class Node {
		int weight;
		int vertex;
		Node(int v, int w) {
			this.vertex = v;
			this.weight = w;
		}
	}
	
	public void sol_11404() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.get(a).add(new Node(b, c));
		}
		
		// Floyd
		// 1. copy
		int MAX = 10000001;
		int[][] dist = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dist[i][j] = MAX;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			ArrayList<Node> node = g.get(i);
			dist[i][i] = 0;
			for (Node n : node) {
				if (dist[i][n.vertex] < MAX) {
					dist[i][n.vertex] = Math.min(dist[i][n.vertex], n.weight);
				} else {
					dist[i][n.vertex] = n.weight;
				}
			}
		}
		
		// 2. check
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		// 3. print
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(dist[i][j] >= MAX ? 0 : dist[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	class Element implements Comparable<Element>{
		int u;
		int v;
		int key;
		Element(int u, int v, int key) {
			this.u = u;
			this.v = v;
			this.key = key;
		}
		
		@Override
		public int compareTo(Element compare) {
			return this.key - compare.key;
		}
	}
	
	public int getParent(int curr, int[] parent) {
		if (parent[curr] == curr)	return curr;
		return parent[curr] = getParent(parent[curr], parent);
	}
	
	public void sol_1197() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Element[] arr = new Element[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[i] = new Element(A, B, C);
		}

		// 1. set_init
		int[] parent = new int[V+1];
		for (int i = 0; i <= V; i++) {
			parent[i] = i;
		}
		
		// 2. sort arr
		Arrays.sort(arr);
		
		// 3. kruskal
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			Element e = arr[i];
			int uset = getParent(e.u, parent);
			int vset = getParent(e.v, parent);
			if (uset != vset) {
				//setUnion
				if (uset > vset)	parent[uset] = vset;
				else				parent[vset] = uset;
				res += e.key;
			}
		}
		
		System.out.println(res);
	}
	
	private ArrayList<ArrayList<Integer>> g;
	private boolean isBipartite;
	private int[] check;
	
	public void dfs(int start, int color) {
		check[start] = color;
		for (int n : g.get(start)) {
			if (check[n] == color) {
				isBipartite = false;
				return;
			}
			if (check[n] == 0) {
				dfs(n, color * -1);
			}
		}
	}
	
	public void sol_1707() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			g = new ArrayList<>();
			for (int j = 0; j <= V; j++) g.add(new ArrayList<Integer>());
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				g.get(u).add(v);
				g.get(v).add(u);
			}
			
			// BFS
			isBipartite = true;
			check = new int[V+1];
			
			for (int j = 1; j <= V; j++) {
				if (!isBipartite)	break;
				if (check[i] == 0) {
					dfs(i, 1);
				}
			}
			
			if (isBipartite)	sb.append("YES").append('\n');
			else				sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1707();
	}
}
