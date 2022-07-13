import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	class Node {
		int vertex;
		int weight;
		Node(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public void sol_1916() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			g.get(X).add(new Node(Y, W));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// Dijkstra
		int[] dist = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(
				(n1, n2) -> Integer.compare(n1.weight, n2.weight));
		q.offer(new Node(start, 0));
		dist[start] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();					// min cost node.
			if (cur.vertex == end)				break;				// end를 찾으면 종료
			if (dist[cur.vertex] < cur.weight)	continue;			// 현 노드 방문이 최선일때만 진행
			for (int i = 0; i < g.get(cur.vertex).size(); i++) {	// 인접 노드에 대해
				Node next = g.get(cur.vertex).get(i);				// 인접 노드의 정보를 가져옴
				if (dist[next.vertex] > cur.weight + next.weight) {		// cur를 거쳐 next로 가는게 최단이면
					dist[next.vertex] = cur.weight + next.weight;		// 거리 갱신
					q.offer(new Node(next.vertex, dist[next.vertex]));	// 큐에 넣기 : 최소 가능성이 있으므로
				}
			}
		}
		
		
		// print
		System.out.println(dist[end]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1916();
	}
}
