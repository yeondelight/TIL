import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	class Node {
		int v;
		int w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	
	class Pair {
		int val;		// 최소비용
		int previous;	// 직전에 어느 정점을 방문해야 하는가
	}
	
	public void sol_11779() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// scan Vertex
		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Node>());
		}
		
		// scan Edge
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			g.get(S).add(new Node(E, T));
		}
		
		// scan Start, End
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// Dijkstra
		Pair[] dist = new Pair[N+1];
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		
		// init val of dist[]
		for (int i = 0; i <= N; i++) {
			dist[i] = new Pair();
			dist[i].val = Integer.MAX_VALUE;
		}
		
		q.offer(new Node(S, 0));
		dist[S].val = 0;
		dist[S].previous = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if (dist[cur.v].val < cur.w)	continue;		// 현 노드 방문이 최선일때만 진행
			for (int j = 0; j < g.get(cur.v).size(); j++) {	// 인접 노드에 대해
				Node next = g.get(cur.v).get(j);			// 인접 노드의 정보를 가져옴
				if (dist[next.v].val > cur.w + next.w) {	// cur를 거쳐 next로 가는게 최단이면
					dist[next.v].val = cur.w + next.w;		// 거리 갱신
					dist[next.v].previous = cur.v;			// 방문 노드 갱신
					q.offer(new Node(next.v, dist[next.v].val));	// 큐에 넣기 : 최소 가능성이 있으므로
				}
			}
		}
		
		
		// route trace
		Stack<Integer> route = new Stack<>();
		route.push(E);
		int pre = E;
		while(true) {
			pre = dist[pre].previous;
			if (pre == 0)	break;
			route.push(pre);
		}
		
		// print
		sb.append(dist[E].val).append('\n');
		sb.append(route.size()).append('\n');
		while(!route.isEmpty()) sb.append(route.pop()).append(' ');
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11779();
	}
}
