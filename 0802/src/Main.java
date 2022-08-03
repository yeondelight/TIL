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
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public void sol_1504() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		// save edges
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.get(a).add(new Node(b, c));
			g.get(b).add(new Node(a, c));
		}
		
		// save checkpoints
		st = new StringTokenizer(br.readLine());
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());
		
		// Dijkstra
		int MAX = 500000000;
		int[] start = {1, V1, V2};
		int[][] dist = new int[3][N+1];
		PriorityQueue<Node> q;
		
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], MAX);
			q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
			q.offer(new Node(start[i], 0));
			dist[i][start[i]] = 0;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				if (dist[i][cur.v] < cur.w)	continue;				// 현 노드 방문이 최선일때만 진행
				for (int j = 0; j < g.get(cur.v).size(); j++) {		// 인접 노드에 대해
					Node next = g.get(cur.v).get(j);				// 인접 노드의 정보를 가져옴
					if (dist[i][next.v] > cur.w + next.w) {			// cur를 거쳐 next로 가는게 최단이면
						dist[i][next.v] = cur.w + next.w;			// 거리 갱신
						q.offer(new Node(next.v, dist[i][next.v]));	// 큐에 넣기 : 최소 가능성이 있으므로
					}
				}
			}
		}
		
		// cal res
		// 1 -> V1 -> V2 -> N
		// 1 -> V2 -> V1 -> N
		int case1 = dist[0][V1] + dist[1][V2] + dist[2][N];
		int case2 = dist[0][V2] + dist[2][V1] + dist[1][N];
		int res = case1 < case2 ? case1 : case2;
		
		if (res >= MAX)	System.out.println(-1);
		else			System.out.println(res);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1504();
	}
}
