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
	
	public void sol_1238() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		// get Edges
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			g.get(S).add(new Node(E, T));
		}
		
		// Dijkstra
		int[][] dist = new int[N+1][N+1];	// N번에서 N번까지 가는 거리의 최소
		PriorityQueue<Node> q;				// 최단거리를 저장할 큐
		
		for (int i = 1; i < N+1; i++) {	// i번째에서 출발하는 경우의 거리 구하기
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;				// 자기자신으로부터 탐색을 시작한다.
			q = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.w, n2.w));
			q.offer(new Node(i, 0));
			
			while(!q.isEmpty()) {
				Node cur = q.poll();								// min cost node.
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
		
		// cal Max
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			max = Math.max(max, dist[i][X] + dist[X][i]);
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1238();
	}
}
