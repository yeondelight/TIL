import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SOL6118 {
	
	public static int N, M;

	public static ArrayList<ArrayList<Integer>> g;
	public static boolean[] visited;
	
	public static int[] ans;	// 0 : 번호, 1 : 거리, 2 : 개수
	
	public void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 정점
		g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<Integer>());
		}
		
		// 간선
		for (int i = 0; i < M; i++) {
			StringTokenizer stEdge = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stEdge.nextToken());
			int B = Integer.parseInt(stEdge.nextToken());
			g.get(A).add(B);
			g.get(B).add(A);
		}
	}
	
	public void solution() {
		visited = new boolean[N+1];
		bfs();
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append(' ');
		sb.append(ans[1]).append(' ');
		sb.append(ans[2]);
		System.out.println(sb);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// bfs
	public void bfs() {
		ans = new int[3];
		
		// init
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(1);
		
		visited[1] = true;
		
		for (int d = 0; !q.isEmpty(); d++) {
			int currQSize = q.size();
			ans[0] = q.peek();
			ans[1] = d;
			ans[2] = currQSize;
			
			// 미리 빼둔다 - pq 특성상 바로하면 이상한거 빼올 수 있음
			ArrayList<Integer> checkList = new ArrayList<>();
			for (int i = 0; i < currQSize; i++) {
				checkList.add(q.poll());
			}
			
			for (int i : checkList) {
				ArrayList<Integer> nodes = g.get(i);
				for (int n : nodes) {
					if (!visited[n]) {
						visited[n] = true;
						q.offer(n);
					}
				}
			}
		}
	}
}
