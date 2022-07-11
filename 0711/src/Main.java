import java.io.*;
import java.util.*;

public class Main {
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	public void sol_2583() throws Exception {
		// scan
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[k][j] = true;
				}
			}
		}
		
		// BFS
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Vector<Integer> area = new Vector<>();
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j]) {
					int count = 1;
					map[i][j] = true;
					q.add(new Point(j, i));
					while(!q.isEmpty()) {
						Point p = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (0 <= nx && nx < N && 0 <= ny && ny < M && !map[ny][nx]) {
								count++;
								map[ny][nx] = true;
								q.add(new Point(nx, ny));
							}
						}
					}
					area.add(count);
				}
			}
		}
		
		// sort
		Collections.sort(area);
		sb.append(area.size()).append('\n');
		for (int i = 0; i < area.size(); i++) {
			sb.append(area.get(i)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	class Node{
		int v;
		int w;
		Node(int vertex, int weight){
			this.v = vertex;
			this.w = weight;
		}
	}
	
	public void sol_1753() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		
		for (int i = 0; i < V+1; i++) {
			g.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g.get(x).add(new Node(y, w));
		}
		
		 // Dijkstra
		int[] dist = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.w, n2.w));
		q.offer(new Node(K, 0));
		dist[K] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();					// min cost node.
			if (dist[cur.v] < cur.w)	continue;	// 현 노드 방문이 최선일때만 진행
			for (int i = 0; i < g.get(cur.v).size(); i++) {	// 인접 노드에 대해
				Node next = g.get(cur.v).get(i);			// 인접 노드의 정보를 가져옴
				if (dist[next.v] > cur.w + next.w) {		// cur를 거쳐 next로 가는게 최단이면
					dist[next.v] = cur.w + next.w;			// 거리 갱신
					q.offer(new Node(next.v, dist[next.v]));// 큐에 넣기 : 최소 가능성이 있으므로
				}
			}
		}
		
		
		// print
		for (int i = 1; i < V+1; i++) {
			if (dist[i] == Integer.MAX_VALUE)	sb.append("INF").append('\n');
			else								sb.append(dist[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_1753();
	}
}
