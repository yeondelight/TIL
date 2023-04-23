import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class SOL25418 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int A, K;
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution_DP();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}
	
	public void solution_BFS() {
		boolean[] visited = new boolean[K+1];
		Queue<Integer> q = new LinkedList<>();
		
		visited[A] = true;
		q.offer(A);
		
		for (int t = 0; !q.isEmpty(); t++) {
			int currQSize = q.size();
			for (int s = 0; s < currQSize; s++) {
				int curr = q.poll();
				if (curr == K) {
					ans = t;
					return;
				}
				if (curr + 1 <= K && !visited[curr+1]) {
					visited[curr+1] = true;
					q.offer(curr+1);
				}
				if (curr * 2 <= K && !visited[curr*2]) {
					visited[curr*2] = true;
					q.offer(curr*2);
				}
			}
		}
	}
	
	public void solution_DP() {
		int[] dp = new int[K+1];
		
		for (int i = A+1; i <= K; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			if (i - 1 >= A) {
				pq.offer(dp[i-1] + 1);
			}
			if (i % 2 == 0 && i / 2 >= A) {
				pq.offer(dp[i/2] + 1);
			}
			dp[i] = pq.poll();
		}
		
		ans = dp[K];
	}
	
	public void print() {
		System.out.println(ans);
	}
}
