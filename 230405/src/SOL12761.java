import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL12761 {
	
	public static int A, B, N, M;

	public static int MAX = 100000;
	public static boolean[] visited;
	
	public static int ans;
	
	public void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
	
	public void solution() {
		visited = new boolean[MAX+1];
		bfs();
	}
	
	public void print() {
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	// bfs
	public void bfs() {
		
		// init
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		visited[N] = true;
		
		for (int t = 0; !q.isEmpty(); t++) {
			
			int currQSize = q.size();
			
			for (int i = 0; i < currQSize; i++) {
				
				int curr = q.poll();
				
				if (curr == M) {	// 도달했으면 반환
					ans = t;
					return;
				}
				
				if (isInArea(curr+1) && !visited[curr+1]) {
					visited[curr+1] = true;
					q.offer(curr+1);
				}
				
				if (isInArea(curr-1) && !visited[curr-1]) {
					visited[curr-1] = true;
					q.offer(curr-1);
				}
				
				if (isInArea(curr+A) && !visited[curr+A]) {
					visited[curr+A] = true;
					q.offer(curr+A);
				}
				
				if (isInArea(curr+B) && !visited[curr+B]) {
					visited[curr+B] = true;
					q.offer(curr+B);
				}
				
				if (isInArea(curr-A) && !visited[curr-A]) {
					visited[curr-A] = true;
					q.offer(curr-A);
				}
				
				if (isInArea(curr-B) && !visited[curr-B]) {
					visited[curr-B] = true;
					q.offer(curr-B);
				}
				
				if (isInArea(curr*A) && !visited[curr*A]) {
					visited[curr*A] = true;
					q.offer(curr*A);
				}
				
				if (isInArea(curr*B) && !visited[curr*B]) {
					visited[curr*B] = true;
					q.offer(curr*B);
				}
			}
		}
	}
	
	public boolean isInArea(int num) {
		return 0 <= num && num <= MAX;
	}
}
